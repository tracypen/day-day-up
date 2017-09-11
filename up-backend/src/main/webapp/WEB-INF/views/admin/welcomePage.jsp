<%--
  Created by IntelliJ IDEA.
  User: vincent
  Date: 15-9-18
  Time: 下午3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/plugin/thinker-md/thinker-md.vendor.css" />
<h4 id="whereta-springmvc-mybatis-shiro-mysql-activemq-redis-easyui-">
  WhereTa权限管理系统以SpringMvc+MyBatis+Shiro+MySQL+ActiveMQ+Redis+Easyui为架构，实现了用户-角色-权限三者结合的功能权限颗粒化控制：</h4>
<pre><code class="hljs livecodeserver">按钮根据权限限制
  菜单根据权限显示
  所有相关<span class="hljs-built_in"><span class="hljs-built_in">URL</span></span>根据权限拦截
</code></pre>
<span id="OSC_h4_2"></span><h4>数据权限暂时以用户为中心查询：</h4>
<pre><code class="hljs">查询部门只能查询本部门以及子级部门
  查询用户只能查询本级没有管理权限的用户以及所有子级用户
</code></pre>
<span id="OSC_h4_3"></span><h4 id="-shiro-redis-map-ehcache-shiro-xml-">
  会话管理使用Shiro的框架，结合Redis缓存，便于缓存控制以及实现分布式部署。如果想要实现自带的Map缓存或者使用Ehcache缓存都可以直接修改<code>shiro.xml</code>文件即可</h4>
<span id="OSC_h4_4"></span><h4>以下是程序屏幕截图：</h4>
<span id="OSC_h5_5"></span><h5>登录页面</h5>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图1.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图1.png" alt="登录页面"></a>
</p>
<span id="OSC_h5_6"></span><h5>权限页面</h5>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图2.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图2.png" alt="权限页面"></a>
</p>
<span id="OSC_h5_7"></span><h5>角色页面</h5>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图3.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图3.png" alt="角色页面"></a>
</p>
<span id="OSC_h5_8"></span><h5>菜单页面</h5>

<%--<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图4.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图4.png" alt="菜单页面"></a>
</p>
<span id="OSC_h5_9"></span><h5>部门页面</h5>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图5.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图5.png" alt="部门页面"></a>
</p>
<span id="OSC_h5_10"></span><h5>用户页面</h5>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图6.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图6.png" alt="用户页面"></a>
</p>--%>
<span id="OSC_h4_11"></span><h4>用户登陆分布图</h4>

<p><a href="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图8.png" target="_blank"><img
        style="cursor: pointer;" src="http://7u2jlp.com1.z0.glb.clouddn.com/whereurp抓图8.png" alt="用户页面"></a>
</p>
<span id="OSC_h4_12"></span><h4>未完待续。。。</h4>
<span id="OSC_h4_13"></span><h4 id="-test-123456">测试账号：test-123456</h4>

</body>
</html>
