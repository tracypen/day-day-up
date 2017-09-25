#Linux 下elasticsearch 环境搭建

###一.下载安装elasticsearch
https://www.elastic.co/cn/downloads/elasticsearch 右键复制链接地址
将 elasticsearch-5.0.0.tar.gz 拷贝到 /opt 目录下。

在Linux中，/opt这个目录wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.2.2.tar.gz 下载 
安装到/opt目录下的程序，它所有的数据、库文件等等都是放在同个目录下面。
要删除某一程序的时候，你只需删除/opt/（安装的软件）目录即可，而不影响系统其他任何设置，非常简单。
tar -zxvf  elasticsearch-5.2.2.tar.gz
因为Elasticsearch5.0之后，不能使用root账户启动，我们先创建一个elasticsearch组和账户

useradd  elasticsearch -g elasticsearch -p elasticsearch

chown -R elasticsearch:elasticsearch elasticsearch-5.2.2
启动elasticsearch

cd /usr/local/elasticsearch5.2.2/

su elasticsearch

./bin/elasticsearch


