
#### 阿里大于短信验证集成
* AccessKeyID LTAIko6KKBiSHSaI

* AccessKeySecret yVt609yO7tKGYIu0AAXPSboIYJU65r

> 将阿里大于的两个jar文件安装到本地仓库 (后期开发需要安装到私服)

1. mvn install:install-file  -DgroupId=taobao -DartifactId=taobao-core -Dversion=1.0 -Dpackaging=jar -Dfile=d:\lib\aliyun-java-sdk-core-3.3.1.jar

2. mvn install:install-file  -DgroupId=taobao -DartifactId=taobao-sdk -Dversion=1.0 -Dpackaging=jar -Dfile=d:\lib\aliyun-java-sdk-dysmsapi-1.0.0.jar



