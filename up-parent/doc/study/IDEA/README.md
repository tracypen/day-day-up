###一、IDEA快捷键
##### 1.智能IDE
* CTRL + P 显示所有的类或者方法的同名的类型，废弃的还划线了。

* ALT + ENTER 可以补全调用方法返回的类型。
#####2.重构
* CTRL + ALT + P 提取写死的参数到方法参数。

* CTRL + ALT + M 抽取代码块新建一个方法。
##### 3.Debug调试
* Debug模式下自动显示每个变量的值，还可以选中对某个表达式进行演算（ALT+F８）
* CTRL + SHIFT + ENTER 在当前行任何地方可以快速在末尾生成分号；
* CTRL + SHIFT + F 可以快速查找在文件中的内容并显示。

* CTRL + ALT + SHIFT 显示类图



### 二、IDEA乱码解决
#####1.工程代码乱码 
* Settings > Editor > File Encodings > Global Encodings & Project Encodings 
 设置为：UTF-8。
  
#####2.main方法运行，控制台乱码
 * Settings > Build, Execution, Deployment > Compile > Java Compiler > Additional command line parameters > 
 设置为：-encoding utf-8。
#####3.tomcat运行，控制台乱码
 * Edit Configurations > Tomcat Server > server > VM options > 
 设置为：-Dfile.encoding=UTF-8。
  
  * idea > bin > idea.exe.vmoptions或者idea64.exe.vmoptions配置文件末尾添加：
  -Dfile.encoding=UTF-8。