#Linux 下elasticsearch 环境搭建

###一.下载安装elasticsearch (单机)
https://www.elastic.co/cn/downloads/elasticsearch 右键复制链接地址
将 elasticsearch-5.0.0.tar.gz 拷贝到 /opt 目录下。

在Linux中，/opt这个目录wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.2.2.tar.gz 下载 
安装到/opt目录下的程序，它所有的数据、库文件等等都是放在同个目录下面。
要删除某一程序的时候，你只需删除/opt/（安装的软件）目录即可，而不影响系统其他任何设置，非常简单。
tar -zxvf  elasticsearch-5.2.2.tar.gz

因为Elasticsearch5.0之后，不能使用root账户启动，我们先创建一个elasticsearch组和账户

useradd  elasticsearch -g elasticsearch -p elasticsearch

chown -R elasticsearch:elasticsearch elasticsearch-5.2.2


切换root用户更改系统参数
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
bootstrap.system_call_filter: false


启动elasticsearch

cd /usr/local/elasticsearch5.2.2/

su elasticsearch

./bin/elasticsearch

### 安装head插件




