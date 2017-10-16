#Linux 下ActiveMQ 安装

### 1.下载
 wget http://activemq.apache.org/path/tofile/apache-activemq-5.8-tar.gz
### 2.解压
 tar zxvf activemq-x.x.x.tar.gz
### 3.授权 
 cd [activemq_install_dir]/bin 
 chmod 755 activemq
### 4.开放端口 
 * vim /etc/sysconfig/iptables 
 * 开放61616 和8161端口 service 
 * iptables restart
### 5.启动
 ./bin/activemq start
### 6.补充命令 
* 启动重启activemq ./bin/activemq start/restart
* 查看进程 ps -ef|grep activemq //查看activemq进程


> 参考官方文档：http://activemq.apache.org/version-5-getting-started.html
