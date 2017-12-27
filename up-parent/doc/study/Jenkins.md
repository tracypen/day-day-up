### Jenkins 学习笔记一(简介&安装)

>    随着软件开发复杂度的不断提高，团队开发成员间如何更好地协同工作以确保软件开发的质量已经慢慢成为开发过程中不可回避的问题。尤其是近些年来，敏捷（Agile） 在软件工程领域越来越红火，如何能再不断变化的需求中快速适应和保证软件的质量也显得尤其的重要。

>  持续集成正是针对这一类问题的一种软件开发实践。它倡导团队开发成员必须经常集成他们的工作，甚至每天都可能发生多次集成。而每次的集成都是通过自动化的构建来验证，包括自动编译、发布和测试，从而尽快地发现集成错误，让团队能够更快的开发内聚的软件。

**1. Jenkins简介：**
* Jenkins由以前的hudson更名而来。Jenkins的主要功能是监视重复工作的执行，例如软件工程的构建或在cron下设置的jobs。具体地：

* Jenkins 是一个开源项目，提供了一种易于使用的持续集成系统，使开发者从繁杂的集成中解脱出来，专注于更为重要的业务逻辑实现上。同时 Jenkins 能实施监控集成中存在的错误，提供详细的日志文件和提醒功能，还能用图表的形式形象地展示项目构建的趋势和稳定性。下面将介绍 Jenkins 的基本功能。

* Jenkins 的安装非常简单，只需要从 Jenkins 的主页上下载最新的 jenkins.war 文件然后运行 java -jar jenkins.war。同时，还可以点击 Jenkins 页面上的 launch 按钮完成下载和运行 Jenkins。

**2. Jenkins的主要特点：**

* 容易安装，只需要执行Java -jar jenkins.war， 或者直接部署到一个servlet container中，例如tomcat。不需要安装，不需要数据库的支持。

* 容易配置，jenkins可以完全地通过友好的web GUI来配置，且配置页面支持配置项的错误检查和很好的在线帮助。不需要手动地编辑xml的配置文件，但是jenkins也支持手动修改xml配置文件。

* 项目源码修改的检测，jenkins能够从项目的Subversion/CVS生成最近修改的集合列表，且改方式非常有效，不会增加Subversion/CVS Repository的负载。

* 可读的永久的链接生成，jenkins对于大部分pages都生成清楚的可读的永久的链接，例如''latest build"/"latest successful build",因此可以容易地在其他的地方引用jenkins的生成的pages。

* RSS/EMail/IM集成，可以通过RSS，EMail或IM来实时地监视build的失败。

* Build完成后仍然可以tag，支持在build完成后tag或重tag。

* Junit/TestNG 测试报告，能够很好地显示各种测试的报告，且可以生成失败的趋向图。

* 分布式build，jenkins能够分发build/test的负载到多台机器，能够更好地利用硬件资源，提高build的时间。

* 文件标识，jenkins可以标识build产生的文件，例如jars。

* 插件支持，jenkins可以通过第三方的插件来扩展。

* 跨平台，支持几乎所有的平台，例如Windows,Ubuntu/Debian,Red Hat/Fedora/CentOS,Mac OS X,openSUSE,FreeBSD,OpenBSD,Solaris/OpenIndiana.Gentoo。

**3. Jenkin安装：**