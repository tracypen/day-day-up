#Linux 下Java 环境搭建

###一.安装JDK
解压后设置环境变量
JAVA_HOME=/usr/softwar/jdk/jdk1.8.0_112
JRE_HOME=/usr/softwar/jdk/jdk1.8.0_112/jre
CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
export JAVA_HOME JRE_HOME CLASS_PATH PATH

##二.安装Apache Tomcat（多个） 
 - 分别mkdir tomcat8080 tomcat8081 tomcat802 
 
 - 编辑 /etc/profile 文件
		##########first tomcat###########
CATALINA_HOME=/usr/softwar/tomcat/tomcat8080/apache-tomcat-8.0.39
TOMCAT_HOME=/usr/softwar/tomcat/tomcat8080/apache-tomcat-8.0.39
export CATALINA_BASE CATALINA_HOME TOMCAT_HOME
 
		##########secend tomcat###########
 CATALINA_2_BASE=/usr/softwar/tomcat/tomcat8081/apache-tomcat-8.0.39
CATALINA_2_HOME=/usr/softwar/tomcat/tomcat8081/apache-tomcat-8.0.39
TOMCAT_2_HOME=/usr/softwar/tomcat/tomcat8081/apache-tomcat-8.0.39
export CATALINA_2_BASE CATALINA_2_HOME TOMCAT_2_HOME 
 
		##########third tomcat###########
CATALINA_3_BASE=/usr/softwar/tomcat/tomcat8082/apache-tomcat-8.0.39
CATALINA_3_HOME=/usr/softwar/tomcat/tomcat8082/apache-tomcat-8.0.39
TOMCAT_3_HOME=/usr/softwar/tomcat/tomcat8082/apache-tomcat-8.0.39
export CATALINA_3_BASE CATALINA_3_HOME TOMCAT_3_HOME

- 分别修改config/server.xml,中各个端口保证与林割爱两个tomcat不冲突


- 最后分别修改bin目录下的catalina.sh文件，使用第二套tomcat环境变量：
- 在该# OS specific support. $var _must_ be set to either true or false.注释后加上对应的（profile文件中对应配置的）
export CATALINA_BASE=$CATALINA_2_BASE
export CATALINA_HOME=$CATALINA_2_HOME
分别启动三个tomcat ok！

##三.Redis安装

 在Linux下安装Redis非常简单，具体步骤如下（官网有说明）：

- 1、下载源码，解压缩后编译源码。

$ wget http://download.redis.io/releases/redis-2.8.3.tar.gz
$ tar xzf redis-2.8.3.tar.gz
$ cd redis-2.8.3
$ make

- 2、编译完成后，在Src目录下，有四个可执行文件redis-server、redis-benchmark、redis-cli和redis.conf。然后拷贝到一个目录下。

mkdir /usr/redis
cp redis-server  /usr/redis
cp redis-benchmark /usr/redis
cp redis-cli  /usr/redis
cp redis.conf  /usr/redis
cd /usr/redis

- 3、启动Redis服务。

$ redis-server   redis.conf

- 4、设置redis后台启动
vim redis.conf 
daemonize 设置为yes
ok!!!

##四 Nginx 安装
http://www.cnblogs.com/taiyonghai/p/6728707.html