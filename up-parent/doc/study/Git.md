### Git 学习笔记(入门级)

> 版本控制我只相信[Git](http://git-scm.com/download),包括github、gitlab都是git的衍生品
#### 1.概念
* 工作区：就是电脑的工作目录
* 版本库：每一个工作区中都有一个.git的隐藏目录，这个目录不属于工作区，这是版本库。其中版本库里面存了很多东西，其中最重要的就是stage(暂存区)，还有Git为我们自动创建了第一个分支master,以及指向master的一个指针HEAD。
* Git提交到版本库需要两部：
1. 第一步：使用git add 把文件添加到暂存区
2. 第二步：使用git commit提交修改
#### 2.安装
* Linux 平台安装很简单  $ yum install git 
* Windows平台也比较简单下载安装包一路Next 就行 ,我这里就是windows，因为之前已经安装，这里不再赘述
安装完成后检查下git版本 输入 ```git --version```
![](http://upload-images.jianshu.io/upload_images/8387919-1a087b48b085f34e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

出现对应版本说明安装成功
#### 2.配置
首先配置下你的git基本信息，用来标识以后谁对git执行了操作(提交、push)
```$ git config --global user.name "Your Name" ```
```$ git config --global user.email "email@example.com"```
#查看所有的配置信息
```$ git config --list```
![](http://upload-images.jianshu.io/upload_images/8387919-142c289c665fdc5b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 4.基本操作
-   初始化项目
 ```	$ git init```
比如我在E盘新建helloGit目录,并且要将此目录作为以后代码的本地版本库，那么需要在改目录中执行

![](http://upload-images.jianshu.io/upload_images/8387919-59949da1ff9bf562.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

-  添加文件，使该文件受按本控制
当我们在该目录下新建hello.txt时，改文件是不搜版本控制的，那么想让git管理该文件
 ```$ git add hello.txt```
-  查看是否有未提交的文件
	```$ git status```
- 提交本地修改
```$ git commit -m '第一次提交'```
其中-m 就是添加提交描述，团队协作时你的队友可以很清楚的看到你做了什么。
![](http://upload-images.jianshu.io/upload_images/8387919-9f41285970983c1a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 查看是否有未提交的文件
```$ git status```
 ![](http://upload-images.jianshu.io/upload_images/8387919-d0ee90aca01b2228.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如图，表示目前没有需要提交的文件，当前工作区与版本库
- 比较修改的内容
```$ git diff readme.txt```
![](http://upload-images.jianshu.io/upload_images/8387919-fa08d173ec6bc2bf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如图，修改hello.txt中内容为hello git 后可以看到图中--- +++ 表示删掉/新增内容
- 查看历史记录
```$ git log```
![](http://upload-images.jianshu.io/upload_images/8387919-f7940eb3745e14fa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- 退回上一个版本
```$ git reset --hard HEAD^```
![](http://upload-images.jianshu.io/upload_images/8387919-36cf6dd93193f1ce.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
并且本地文件也还原到上个版本了
- 退回上上个版本
```$ git reset --hard HEAD^^```
- 退回上100个版本
```$ git reset --hard HEAD~100```
- 显示版本号
```$ git reflog```
![](http://upload-images.jianshu.io/upload_images/8387919-6f647e81cc7d82ed.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- 回退到某一个版本号
$ git reset --hard 版本号
![](http://upload-images.jianshu.io/upload_images/8387919-1e4b8f0b60ae4ff8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
可以看到hello world 又出现了
- 放弃修改，这里 -- 很重要不写就变成了创建分支
$ git checkout -- hello.txt
- 删除文件
$ git rm hello.txt
![](http://upload-images.jianshu.io/upload_images/8387919-b2c571cd60d4df00.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
可以看到 hello.txt 么的了 





