#  Linux下zookeeper安装

- 注：演示过程中使用的时候centOS6.5
#### 1.下载
 ` 
cd /usr/software/zookeper  
wget https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.3.6/zookeeper-3.3.6.tar.gz
   ` 
#### 2.解压
 ` 
   tar -zxvf zookeeper-3.3.6.tar.gz   
   cd zookeeper/zookeeper-3.3.6
  ` 
#### 3.配置
   复制 zoo_sample.cfg 文件的并命名为为 zoo.cfg
   
   ` 
   cp zoo_sample.cfg zoo.cfg
    ` 
    
   编辑： 
   
    # The number of milliseconds of each tick
    tickTime=2000
    # The number of ticks that the initial
    # synchronization phase can take
    initLimit=10
    # The number of ticks that can pass between
    # sending a request and getting an acknowledgement
    syncLimit=5
    # the directory where the snapshot is stored.
    # 数据文件夹
    dataDir=/usr/software/zookeeper/zookeeper-3.3.6/data
    # 日志文件夹
    dataLogDir=/usr/software/zookeeper/zookeeper-3.3.6/logs
    # the port at which the clients will connect
    clientPort=2181
    server.1=192.168.32.129:2888:3888

#### 4.添加环境变量
 ` 
   vim /etc/profile
  `   
     
    export ZOOKEEPER_HOME=/usr/software/zookeeper/zookeeper-3.3.6/
    export PATH=$ZOOKEEPER_HOME/bin:$PATH
    export PATH
    
 立即生效  
  ` source /etc/profile
  ` 

#### 5.启动 zookeeper 服务：
      zkServer.sh start
      
   如打印如下信息则表明启动成功：
       
       ZooKeeper JMX enabled by default
       Using config: /usr/local/services/zookeeper/zookeeper-3.4.9/bin/../conf/zoo.cfg
       Starting zookeeper ... STARTED
#### 6.查询 zookeeper 状态：
    zkServer.sh status
#### 7.关闭 zookeeper 服务：
    zkServer.sh stop
   如打印如下信息则表明成功关闭：
   
    ZooKeeper JMX enabled by default
    Using config: /usr/local/services/zookeeper/zookeeper-3.4.9/bin/../conf/zoo.cfg
    Stopping zookeeper ... STOPPED
#### 8.重启 zookeeper 服务：
    zkServer.sh restart
    
  如打印如下信息则表明重启成功：
    
    ZooKeeper JMX enabled by default
    Using config: /usr/local/services/zookeeper/zookeeper-3.4.9/bin/../conf/zoo.cfg
    ZooKeeper JMX enabled by default
    Using config: /usr/local/services/zookeeper/zookeeper-3.4.9/bin/../conf/zoo.cfg
    Stopping zookeeper ... STOPPED
    ZooKeeper JMX enabled by default
    Using config: /usr/local/services/zookeeper/zookeeper-3.4.9/bin/../conf/zoo.cfg
    Starting zookeeper ... STARTED
#### 9.附防墙命令

    关闭命令：service iptables stop 
 
    永久关闭防火墙：chkconfig iptables off
 
    查看防火墙关闭状态：service iptables status