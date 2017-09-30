#Linux常用命令 

 关闭防火墙
关闭命令：
service iptables stop
永久关闭防火墙：
chkconfig iptables off
两个命令同时运行，运行完成后查看防火墙关闭状态 ：
service iptables status


注意 CentOS 7.0默认使用的是firewall作为防火墙，这里改为iptables防火墙步骤。

1、关闭firewall：
systemctl stop firewalld.service #停止firewall
systemctl disable firewalld.service #禁止firewall开机启动
firewall-cmd --state #查看默认防火墙状态（关闭后显示notrunning，开启后显示running）

编辑防火墙白名单
 vim /etc/sysconfig/iptables
增加下面一行代码
-A INPUT -p tcp -m state -- state NEW -m tcp --dport 80 -j ACCEPT
保存退出，重启防火墙
 service iptables restart
 
 
 
 
 文件查找与替换
 grep "要查找的字符串" 文件名 
 grep -rn "要找查找的文本" 文件名（显示行数）
 进入vi 编辑 :123 (定位到123行)  