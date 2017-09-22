#Linux 下Java 环境搭建

###一.安装JDK
解压后设置环境变量
JAVA_HOME=/usr/softwar/jdk/jdk1.8.0_112
JRE_HOME=/usr/softwar/jdk/jdk1.8.0_112/jre
CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
export JAVA_HOME JRE_HOME CLASS_PATH PATH
重新加载配置文件 source /etc/profile
##二.安装Apache Tomcat（多个） 
 - 分别mkdir tomcat8080 tomcat8081 tomcat802 
 
 - 编辑 /etc/profile 文件
		##########first tomcat########### 
CATALINA_HOME=/usr/software/tomcat/tomcat-8080/apache-tomcat-8.0.39
TOMCAT_HOME=/usr/software/tomcat/tomcat-8080/apache-tomcat-8.0.39
export CATALINA_BASE CATALINA_HOME TOMCAT_HOME
 
		##########secend tomcat###########
 CATALINA_2_BASE=/usr/software/tomcat/tomcat-8081/apache-tomcat-8.0.39
CATALINA_2_HOME=/usr/software/tomcat/tomcat-8081/apache-tomcat-8.0.39
TOMCAT_2_HOME=/usr/software/tomcat/tomcat-8081/apache-tomcat-8.0.39
export CATALINA_2_BASE CATALINA_2_HOME TOMCAT_2_HOME 
 
		##########third tomcat###########
CATALINA_3_BASE=/usr/software/tomcat/tomcat-8082/apache-tomcat-8.0.39
CATALINA_3_HOME=/usr/software/tomcat/tomcat-8082/apache-tomcat-8.0.39
TOMCAT_3_HOME=/usr/software/tomcat/tomcat-8082/apache-tomcat-8.0.39
export CATALINA_3_BASE CATALINA_3_HOME TOMCAT_3_HOME

- 分别修改config/server.xml,中各个端口保证与林割爱两个tomcat不冲突


- 最后分别修改第二个和第三个tomcat bin目录下的catalina.sh文件，
- 在该# OS specific support. $var _must_ be set to either true or false.注释后加上对应的（profile文件中对应配置的）
export CATALINA_BASE=$CATALINA_3_BASE
export CATALINA_HOME=$CATALINA_3_HOME
分别启动三个tomcat ok！

##三.Redis安装

 在Linux下安装Redis非常简单，具体步骤如下（官网有说明）：

- 1、下载源码，解压缩后编译源码。

$ wget http://download.redis.io/releases/redis-2.8.3.tar.gz
$ tar xzf redis-2.8.3.tar.gz
$ cd redis-2.8.3
$  make  && make install 

注意：如果报错：cc: command not found 由于没有gcc环境 所以吸纳安装gcc环境
yum  install  gcc 
验证是否安装成功

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

wget http://nginx.org/download/nginx-1.10.2.tar.gz
wget http://www.openssl.org/source/openssl-fips-2.0.10.tar.gz
wget http://zlib.net/zlib-1.2.11.tar.gz
wget ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/pcre-8.40.tar.gz

安装c++编译环境，如已安装可略过
yum install gcc-c++  （期间会有确认提示输入y回车）
2、安装Nginx及相关组件

openssl安装
tar zxvf openssl-fips-2.0.10.tar.gz
cd openssl-fips-2.0.10
./config && make && make install

pcre安装
tar zxvf pcre-8.40.tar.gz
cd pcre-8.40
./configure && make && make install

zlib安装
tar zxvf zlib-1.2.11.tar.gz
cd zlib-1.2.11
./configure && make && make install

nginx安装
tar zxvf nginx-1.10.2.tar.gz
cd nginx-1.10.2
./configure && make && make install

3、启动Nginx

直接启动nginx报错  解决如下：
1.用whereis libpcre.so.1命令找到libpcre.so.1在哪里
2.用ln -s /usr/local/lib/libpcre.so.1 /lib64命令做个软连接就可以了
3.用sbin/nginx启动Nginx
4.用ps -aux | grep nginx查看状态

