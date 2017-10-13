title:使用Hexo搭建个人博客
 
参考：
http://blog.csdn.net/jzooo/article/details/46781805
http://www.jianshu.com/p/189fd945f38f
http://www.jianshu.com/p/4eaddcbe4d12
http://theme-next.iissnan.com/getting-started.html#theme-settings
http://blog.csdn.net/jzooo/article/details/46781805
http://hifor.net/2015/07/01/%E9%9B%B6%E5%9F%BA%E7%A1%80%E5%85%8D%E8%B4%B9%E6%90%AD%E5%BB%BA%E4%B8%AA%E4%BA%BA%E5%8D%9A%E5%AE%A2-hexo-github/
1.下载git  https://git-for-windows.github.io/       https://pan.baidu.com/s/1c0rroje
2.下载nodeJs https://nodejs.org/en/                 https://pan.baidu.com/s/1o6opb9g
检查版本信息
git --version
node -v
npm -v
3.安装hexo
npm install -g hexo
如果被墙 参考http://blog.csdn.net/jzooo/article/details/46781805
创建文件夹（我的是在E盘创建的Hexo）
在Hexo文件下，右键运行Git Bash，输入命令：hexo init
在_config.yml,进行基础配置
输入命令：git clone https://github.com/iissnan/hexo-theme-nextthemes/next 获取主题
 hexo g 重新生成
 hexo s 本地发布
 
 更多hexo命令 https://segmentfault.com/a/1190000002632530
  在浏览器输入：localhost：4000 ，就可以进行访问
  
  
  
  部署到github上 
  新建仓库 仓库名必须和用户名完全一样（作为自己的github主页）
  在_config.yml进行配置 deploy中配置刚才的github地址
  
  安装hexo-deployer-git自动部署发布工具
   npm instal lhexo-deployer-git  --save
   
   输入如下命令发布到github：
   hexo clean && hexo g && hexo d
   
   测试访问
   
   在浏览器输入：https://youBatis.github.io/
   
   传送门一波：
   https://jingyan.baidu.com/article/d8072ac47aca0fec95cefd2d.html
   http://www.cnblogs.com/liuxianan/p/build-blog-website-by-hexo-github.html
   http://www.jianshu.com/p/05289a4bc8b2
   http://www.jianshu.com/p/4eaddcbe4d12