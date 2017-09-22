#Linux常用命令 

 关闭防火墙
关闭命令：
service iptables stop
永久关闭防火墙：
chkconfig iptables off
两个命令同时运行，运行完成后查看防火墙关闭状态 ：
service iptables status


编辑防火墙白名单
 vim /etc/sysconfig/iptables
增加下面一行代码
-A INPUT -p tcp -m state -- state NEW -m tcp --dport 80 -j ACCEPT
保存退出，重启防火墙
 service iptables restart