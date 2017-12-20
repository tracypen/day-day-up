### Lombok 学习笔记 

> Java 冗长的代码是可能是Java语言自身最大的不足了，而Lombok正是为了弥补这一不足而流行的工具，Lombok可以通过简单的注解形式来帮助我们最大程度的简化我们的Java代码，它可以根据不同的注解，在编译源码的时候生成对应的代码。
[官网网址](http://projectlombok.org/ )         [github地址](https://github.com/rzwitserloot/lombok)

#### 1.lombok 注解：
   lombok 提供的注解不多，可以参考官方视频的讲解和官方文档。
    Lombok 注解在线帮助文档：http://projectlombok.org/features/index.
    下面列举几个常用的 lombok 注解：
*  @Data   ：注解在类上；提供getting 和 setting、equals、canEqual、hashCode、toString 方法
*  @Setter：注解在属性上；为属性提供 setting 方法
* @Getter：注解在属性上；为属性提供 getting 方法
*  @Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
* @NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
*  @AllArgsConstructor：注解在类上；为类提供一个全参的构造方法

#### 2.安装
 这里我讲下IDEA安装lombok插件：
  Ctrl+shift+S  进入设置页面![](http://upload-images.jianshu.io/upload_images/8387919-573c812d219c1609.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

点击plugin -> Browse repositories   搜索框中输入 lombok
![](http://upload-images.jianshu.io/upload_images/8387919-3058ed380db944d1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

安装完成后重启即可 

####  3. 使用
引入依赖:
```
	    <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.14</version>
        </dependency>
 ```
  新建User类:
  
	package com.hp.up.lombok;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import lombok.extern.log4j.Log4j;

	/**
	 * Created by youBatis on 2017/12/20 14:09
	 */
	@Data
	@Log4j
	@NoArgsConstructor
	@AllArgsConstructor
	public class User {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别 1:男 2:女 99:未知
     */
    private Integer sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

	}
完成之后我们可以看到User类的结构，其中已经有Lombok帮我们生成的代码了:
![](http://upload-images.jianshu.io/upload_images/8387919-a6c1c5eb1be93509.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

测试类：

	public class TestLombok {
    public static void main(String[] args) {
        User user = new User();
        user.setId(123L);
        user.setName("youBatis");
        System.out.println(user.toString());
    }
	}
控制台输出 ：

	User(id=123, name=youBatis, sex=null, password=null, salt=null, avatar=null)			
		
如图:![](http://upload-images.jianshu.io/upload_images/8387919-f71ec391afe09649.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

更多用法参考 [官网资料](https://projectlombok.org/features/all)
 