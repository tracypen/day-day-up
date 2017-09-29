#Linux 下Java 环境搭建

###一.安装JDK
解压后设置环境变量
JAVA_HOME=/usr/software/jdk
JRE_HOME=/usr/software/jdk/jre
CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
export JAVA_HOME JRE_HOME CLASS_PATH PATH
重新加载配置文件 source /etc/profile
##二.安装Apache Tomcat（多个） 
 分别mkdir tomcat8080 tomcat8081 tomcat802 
  编辑/etc/profile 文件
  
          ##########first tomcat########### 
CATALINA_HOME=/usr/software/tomcat/tomcat8080/apache-tomcat-8.0.39
TOMCAT_HOME=/usr/software/tomcat/tomcat8080/apache-tomcat-8.0.39
export CATALINA_BASE CATALINA_HOME TOMCAT_HOME
 
		##########secend tomcat###########
 CATALINA_2_BASE=/usr/software/tomcat/tomcat8081/apache-tomcat-8.0.39
CATALINA_2_HOME=/usr/software/tomcat/tomcat8081/apache-tomcat-8.0.39
TOMCAT_2_HOME=/usr/software/tomcat/tomcat8081/apache-tomcat-8.0.39
export CATALINA_2_BASE CATALINA_2_HOME TOMCAT_2_HOME 
 
		##########third tomcat###########
CATALINA_3_BASE=/usr/software/tomcat/tomcat8082/apache-tomcat-8.0.39
CATALINA_3_HOME=/usr/software/tomcat/tomcat8082/apache-tomcat-8.0.39
TOMCAT_3_HOME=/usr/software/tomcat/tomcat8082/apache-tomcat-8.0.39
export CATALINA_3_BASE CATALINA_3_HOME TOMCAT_3_HOME

- 分别修改config/server.xml,中各个端口保证与另外两个tomcat不冲突


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
参考 http://www.cnblogs.com/taiyonghai/p/6728707.html
- 1.下载Nginx及相关组件
wget http://nginx.org/download/nginx-1.10.2.tar.gz
wget http://www.openssl.org/source/openssl-fips-2.0.10.tar.gz
wget http://zlib.net/zlib-1.2.11.tar.gz
wget ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/pcre-8.40.tar.gz

安装c++编译环境，如已安装可略过
yum install gcc-c++  （期间会有确认提示输入y回车）
- 2、安装Nginx及相关组件

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

- 3、启动Nginx

直接启动nginx报错  解决如下：
1.用whereis libpcre.so.1命令找到libpcre.so.1在哪里
2.用ln -s /usr/local/lib/libpcre.so.1 /lib64命令做个软连接就可以了
3.用sbin/nginx启动Nginx
4.用ps -aux | grep nginx查看状态


启动
 /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
停止/重启
 /usr/local/nginx/sbin/nginx -s stop(quit、reload)
命令帮助
 /usr/local/nginx/sbin/nginx -h
验证配置文件
 /usr/local/nginx/sbin/nginx -t
配置文件
 vim /usr/local/nginx/conf/nginx.conf
 
 补充：
 1、查看进程号 ps -ef|grep nginx
 2、杀死进程 kill -QUIT 2072
 
## 五 Mysql 安装
- 1.检测系统是否已经安装过mysql或其依赖，若已装过要先将其删除
yum list installed | grep mysql
yum -y remove mysql-libs.i686 (如果有之前安装的mysql执行删除)
- 2.从mysql的官网下载mysql57-community-release-el6-5.noarch.rpm（注意这里的el6-5即适配RHEL6.5的版本，如果下载了其它版本后面的安装过程中可能会报错）：
wget dev.mysql.com/get/mysql-community-release-el6-5.noarch.rpm
- 3.安装第一步下载的rpm文件：
yum install mysql-community-release-el6-5.noarch.rpm
安装成功后，我们可以看到/etc/yum.repos.d/目录下增加了以下两个文件
    ls /etc/yum.repos.d
 1. mysql-community-source.repo
 2. mysql-community.repo

查看mysql57的安装源是否可用，如不可用请自行修改配置文件（/etc/yum.repos.d/mysql-community.repo）使mysql57下面的enable=1

若有mysql其它版本的安装源可用，也请自行修改配置文件使其enable=0
yum repolist enabled | grep mysql
出现以下内容表示安装源可用
    || mysql-connectors-community MySQL Connectors Community                        13
    || mysql-tools-community      MySQL Tools Community                             18
    || mysql57-community-dmr      MySQL 5.7 Community Server Development Milesto    65

- 4.使用yum安装mysql：

yum install mysql-community-server
- 5.启动mysql服务：
service mysqld start
修改密码
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('newpass');
- 6.查看mysqld是否开机自启动，并设置为开机自启动：
chkconfig --list | grep mysqld
chkconfig mysqld on
- 7.修改字符集为UTF-8：
vim /etc/my.cnf
在[mysqld]部分添加：

character-set-server=utf8

在文件末尾新增[client]段，并在[client]段添加：

default-character-set=utf8

修改好之后重启mysqld服务：

service mysqld restart


- 8.解决Mysql远程访问问题
安装成功后，得做相应配置才能从别的机器访问mysql:
.开放mysql访问端口3306

    修改防火墙配置文件
        vi /etc/sysconfig/iptables

    加入端口配置
       -A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT

    重新加载规则

        service iptables restart 

2.修改mysql库里的host

   登录mysql:

   use mysql

   update user set host='%' where user='root' and host='localhost';

   记得一定还得修改密码，因为这时密码已失效，虽然本地还可以原密码登录，可远程改了host后还是没法访问

   UPDATE user SET password=password("root") WHERE user='root';

   flush privileges;

3.重启mysql，远程就可以访问了


ps:如果由于操作错误，本地得登录不了，可以通过

mysqld_safe --skip-grant-tables &

方式启动mysql，这里不用密码就可以登录mysql，改完后再通过正常方式启动