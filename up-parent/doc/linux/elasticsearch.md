#Linux 下elasticsearch 环境搭建
elsticsearch 中文社区 https://elasticsearch.cn/

elasticsearch 配置文件详解参考：
http://blog.csdn.net/qinfei_635879582/article/details/51603219


###一.下载安装elasticsearch (单机)

安装亲检查下jdk elasticsearch5+ 要求jdk1.8+
	
rpm -qa | grep java
如果有就卸载
yum -y remove  java-1.7.0-openjdk-1.7.0.65-2.5.1.2.el65.x8664
yum -y remove java-1.6.0-openjdk-1.6.0.0-11.1.13.4.el6.x86_64


安装maven （后面安装ik分词器时要编译源码）

/usr/local下
wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz
tar -zxvf apache-maven-3.2.5-bin.tar.gz

配置环境变量etc/profile 最后添加以下两行
export MAVEN_HOME=/usr/local/apache-maven-3.2.5
export PATH=${PATH}:${MAVEN_HOME}/bin
检测是否安装成功
mvn -v

https://www.elastic.co/cn/downloads/elasticsearch 
将 elasticsearch-5.0.0.tar.gz 拷贝到 /opt 目录下。

在Linux中，/opt这个目录wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.2.2.tar.gz 下载 
安装到/opt目录下的程序，它所有的数据、库文件等等都是放在同个目录下面。
要删除某一程序的时候，你只需删除/opt/（安装的软件）目录即可，而不影响系统其他任何设置，非常简单。
tar -zxvf  elasticsearch-5.2.2.tar.gz

因为Elasticsearch5.0之后，不能使用root账户启动，我们先创建一个elasticsearch组和账户

useradd  elasticsearch -g elasticsearch -p elasticsearch

chown -R elasticsearch:elasticsearch elasticsearch-5.2.2




切换root用户更改系统参数（否则启动报错）
vi /etc/security/limits.conf 
添加如下内容:

* soft nofile 65536
* hard nofile 131072
* soft nproc 2048
* hard nproc 4096

vi /etc/security/limits.d/90-nproc.conf 
修改
* soft nproc 1024
为
* soft nproc 2048

vi /etc/sysctl.conf 
添加下面配置：
vm.max_map_count=655360
并执行命令：
sysctl -p


在elasticsearch.yml最后添加****************
Centos6不支持SecComp，而ES5.4.1默认bootstrap.system_call_filter为true进行检测，所以导致检测失败，失败后直接导致ES不能启动。
bootstrap.memory_lock: false
bootstrap.system_call_filter: false


启动elasticsearch

cd /usr/local/elasticsearch5.2.2/

su elasticsearch

./bin/elasticsearch


elasticsearch 默认 restful-api 的端口是 9200 不支持 IP 地址，也就是说无法从主机访问虚拟机中的服务，只能在本机用 http://localhost:9200 来访问。如果需要改变，需要修改配置文件 /usr/local/elasticsearch/config/elasticsearch.yml 文件，加入以下两行：

network.bind_host: 0.0.0.0
network.publish_host: _nonloopback:ipv4
或去除 network.host 和 http.port 之前的注释，并将 network.host 的 IP 地址修改为本机外网 IP。然后重启，Elasticsearch

关闭方法（输入命令：ps -ef | grep elasticsearch ，找到进程，然后 kill 掉就行了。


修改配置文件：vim config/elasticsearch.yml
cluster.name : my-app (集群的名字，名字相同的就是一个集群)

node.name : es1 （节点的名字, 和前面配置的 hosts 中的 name 要一致）
path.data: /data/elasticsearch/data （数据的路径。没有要创建（mkdir -p /data/elasticsearch/{data,logs}），
并且给执行用户权限 chown tzs /data/elasticsearch/{data,logs} -R ）
path.logs: /data/elasticsearch/logs （数据 log 信息的路径，同上）
network.host: 0.0.0.0 //允许外网访问，也可以是自己的ip地址
http.port: 9200 //访问的端口
discovery.zen.ping.unicast.hosts: [“192.168.153.133”, “192.168.153.134”, “192.168.153.132”] //各个节点的ip地址

记得需要添加上：（这个是安装 head 插件要用的）
http.cors.enabled: true
http.cors.allow-origin: "*"

如果外网还是不能访问，则有可能是防火墙设置导致的 ( 关闭防火墙：service iptables stop )


### 安装head插件
opt下 
安装git
 yum remove git
 yum install git
 git clone git://github.com/mobz/elasticsearch-head.git 拉取 head 插件到本地，或者直接在 GitHub 下载 压缩包下来
 安装nodejs
 先去官网下载 node-v8.4.0-linux-x64.tar.xz
 
 tar -Jxv -f  node-v8.4.0-linux-x64.tar.xz
 mv node-v8.4.0-linux-x64  node
 vim  /etc/profile
 export NODE_HOME=/usr/local/node
 export PATH=$PATH:$NODE_HOME/bin
 export NODE_PATH=$NODE_HOME/lib/node_modules
 
 source /etc/profile
 检测node版本
 node -v
 
 然后安装head
 mv elasticsearch-head head
 cd head/
 npm install -g grunt-cli
 npm install
 如果速度较慢或者安装失败，可以使用国内镜像:
 npm install -g cnpm --registry=https://registry.npm.taobao.org
 grunt server
 
 记得需要在elasticsearch.yml添加上：
 http.cors.enabled: true
 http.cors.allow-origin: "*"
 
 参考 ： http://blog.csdn.net/napoay/article/details/53896348
 
 在这里有个问题就是head插件一直是只能虚拟机本地访问  跨域不嫩给链接到集群(折腾好久)
 参考http://www.cnblogs.com/xing901022/p/6030296.html
 
 1.编辑 head/Gruntfile.js
 connect: {
     server: {
         options: {
             port: 9100,
             hostname: '*',
             base: '.',
             keepalive: true
         }
     }
 }
 hostname 改为* 表示所有域名可以访问
 2.编辑 head/_site/app.js

 this.base_uri = this.config.base_uri || this.prefs.get("app-base_uri") || "http://localhost:9200";
  grep -rn  "localhost" app.js 快速查找"localhost" 所在行数
 把localhost改为虚拟机ip
 重启head插件 ok
 
 注：head插件后台启动方式：
 nohup grunt server &exit
 如果想关闭head插件，使用linux查找进程命令：
 ps aux|grep head
 结束进程：
 kill 进程号

 
 
 ###安装ik分词
 参考 http://www.cnblogs.com/phpshen/p/6085274.html
 
 在github下载ik分词 
 https://github.com/medcl/elasticsearch-analysis-ik/releases/tag/v5.6.1
 如果下载源码则需要mvn clean package
 复制到el安装目录plugins下 解压重命名为 analysis-ik
 注：es5以后不支持在yml文家中指定ik分词器（会报错）
 所以在创建索引的时候指定分词器
 首先重启es
 用postman工具创建测试索引
 put 192.168.2.38:9200/test
 {
     "settings" : {
         "analysis" : {
             "analyzer" : {
                 "ik" : {
                     "tokenizer" : "ik_smart"
                 }
             }
         }
     },
     "mappings" : {
         "logs" : {
             "dynamic" : true,
             "properties" : {
                 "message" : {
                     "type" : "string",
                     "analyzer" : "ik_smart"
                 }
             }
         }
     }
 }
 
 完成后测试分词器
 
 get  192.168.2.38:9200/test/_analyze?analyzer=ik_max_word&text=陕西省西安市大唐芙蓉园
 
 {
     "tokens": [
         {
             "token": "陕西省",
             "start_offset": 0,
             "end_offset": 3,
             "type": "CN_WORD",
             "position": 0
         },
         {
             "token": "陕西",
             "start_offset": 0,
             "end_offset": 2,
             "type": "CN_WORD",
             "position": 1
         },
         {
             "token": "省",
             "start_offset": 2,
             "end_offset": 3,
             "type": "CN_CHAR",
             "position": 2
         },
         {
             "token": "西安市",
             "start_offset": 3,
             "end_offset": 6,
             "type": "CN_WORD",
             "position": 3
         },
         {
             "token": "西安",
             "start_offset": 3,
             "end_offset": 5,
             "type": "CN_WORD",
             "position": 4
         },
         {
             "token": "市",
             "start_offset": 5,
             "end_offset": 6,
             "type": "CN_CHAR",
             "position": 5
         },
         {
             "token": "大唐",
             "start_offset": 6,
             "end_offset": 8,
             "type": "CN_WORD",
             "position": 6
         },
         {
             "token": "芙蓉",
             "start_offset": 8,
             "end_offset": 10,
             "type": "CN_WORD",
             "position": 7
         },
         {
             "token": "蓉园",
             "start_offset": 9,
             "end_offset": 11,
             "type": "CN_WORD",
             "position": 8
         }
     ]
 }
 

 
 ###二.elasticsearch集群搭建
 
 创建slave1 slave2 并复制解压es5.6tar包
 
 
 在主节点配置文件加上
 node.master: true
 node.data: true 
  http.port: 9200
  transport.tcp.port: 9300
  discovery.zen.ping.unicast.hosts: ["192.168.2.38:9300"]
 
 对es账户授予slave1 slave2 操作权限
 配置文件中节点名必须与master一直 端口不能过冲突
 最后加上
 bootstrap.memory_lock: false
 bootstrap.system_call_filter: false
 分别启动两个slave节点和master节点
  参考 http://www.cnblogs.com/fastLearn/p/6509178.html
  
  ********************************************
 http://www.cnblogs.com/wxw16/p/6160186.html






处理 Java 的“Cannot allocate memory”错误

 编辑 /etc/sysctl.conf，修改参数 vm.overcommit_memory = 1
 
 
 
 
 
 vim /usr/local/elastic/config/jvm.options 
 -Xms512m
 -Xmx512m
 
 参考 http://www.huangxiaobai.com/archives/1007

------------------------------------------------------master---------------------------------------------------------------------------
cluster.name: mcgrady-cluster
node.name: master-node

path.data: /data/elasticsearch/data
path.logs: /data/elasticsearch/logs

node.master: true
node.data: true
network.host: 0.0.0.0
http.port: 9200
transport.tcp.port: 9300
discovery.zen.minimum_master_nodes: 1
discovery.zen.ping.unicast.hosts: ["127.0.0.1"]
http.cors.enabled: true
http.cors.allow-origin: "*"
bootstrap.memory_lock: false
bootstrap.system_call_filter: false

--------------------------------------------------------slaver-----------------------------------------------------------------------------
cluster.name: mcgrady-cluster
node.name: slaver01

node.data: true
network.host: 0.0.0.0
http.port: 9201
# transport.tcp.port: 9301  (改变之后集群不能自动识别)
discovery.zen.minimum_master_nodes: 1
discovery.zen.ping.unicast.hosts: ["127.0.0.1"]
bootstrap.memory_lock: false
bootstrap.system_call_filter: false
                                      



