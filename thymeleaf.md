--- thymeleaf使用
项目结构：
插入图片；

基于maven工程springboot项目配置
在pox.xml文件添加thymeleaf的依赖
```
<!-- 模板引擎 Thymeleaf 依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

启用thymeleaf模版引擎
application.properties文件中加入配置：
```
#thymeleaf配置
#指定国际化文件
#spring.messages.basename=templates/home
# Enable template caching.
spring.thymeleaf.cache=true
# Check that the template exists before rendering it.
spring.thymeleaf.check-template=true
# Check that the templates location exists.
spring.thymeleaf.check-template-location=true
# Enable Thymeleaf view resolution for Web frameworks.
spring.thymeleaf.enabled=true
# Template files encoding.
spring.thymeleaf.encoding=UTF-8
# Comma-separated list of view names that should be excluded from resolution.
#spring.thymeleaf.excluded-view-names=
# Template mode to be applied to templates. See also StandardTemplateModeHandlers.
spring.thymeleaf.mode=HTML
# Prefix that gets prepended to view names when building a URL.
spring.thymeleaf.prefix=classpath:/templates/
# Maximum size of data buffers used for writing to the response, in bytes.
#spring.thymeleaf.reactive.max-chunk-size=
# Media types supported by the view technology.
#spring.thymeleaf.reactive.media-types=
# Content-Type value written to HTTP responses.
spring.thymeleaf.servlet.content-type=text/html
# Suffix that gets appended to view names when building a URL.
spring.thymeleaf.suffix=.html
# Order of the template resolver in the chain.
# spring.thymeleaf.template-resolver-order=
# Comma-separated list of view names that can be resolved.
# spring.thymeleaf.view-names=
```
--- 页面引入thymeleaf
> thymeleaf标签使用的两种形式
```
data-th-text形式 :<div data-th-text="${title}"></div>    （无需引入命名空间，html5支持的自定义属性）
th:text形式 :<div data-th-text="${title}"></div>  （需引入命名空间）
```

thymeleaf命名空间
```
<html xmlns:th="http://www.thymeleaf.org">
```

--- thymeleaf语法
> th:text 文本显示
```
<div th:text="${title}">hello world</div>
```


可以在标签中使用运算符`+, -, *, /, %`：
```
运算符：<div th:text="'1 + 1 =' + ${number} * 2 "></div>
```

--- thymeleaf表达式
> ${} 变量表达式：引用页面中的变量，同EL表达式中的${}作用一样；
```
<div th:text="${title}"></div>
```

> #{} 消息表达式（文字国际化表达式）：用来引用国际化资源文件中的文字信息；
如home.properties:
```
home.welcome=this messages is from home.properties!
```
home_zh_CN.properties:
```
home.welcome=来自于home.properties消息
```
Note：配置国际化资源文件时，一定要建立默认的XX.properties文件，再建立各个区域下的XX_zh_CN.properties文件；

使用消息表达式引用文字：
```
<div th:text="#{home.welcome}"></div>
```
> 使用消息表达式时，经常出现的错误??home.welcome_zh_CN??
> 网上提供的解决方案：
> 第一种：在thymeleaf页面中引入：
>
> `<link rel="stylesheet" type="text/css" media="all" href="../../css/gtvg.css" th:href="@{/css/gtvg.css}" />`
>
> 引入css文件夹下的gtvg.css，不过发现没有这个文件，尝试这种解决方式发现没有效果
> 第二种：
> 在application.properties文件中加入一条配置：
> #指定国际化文件位置
> spring.messages.basename=templates/home
> 亲测有效，加入配置运行成功；

> *{} 选择表达式 :选择上文中对象的属性

```
<div th:object="${user}">
	<span th:text="*{name}">
	</span>
</div>
```

> @{} 链接表达式:链接的书写
```
链接表达式:
<a th:href="@{../static/js/test.js}">相对当前路径</a>
<a th:href="@{~/static/js/test.js}">相对服务器</a>
<a th:href="@{//static/js/test.js}">相对协议路径</a>
<a th:href="@{http://localhost:8080/static/js/test.js}">绝对路径</a>
```
> 分段表达式
```
<!-- footer页面中定义碎片footer_fragment -->
<div th:fragment="footer_fragment">
    &copy;2019 sdongwan
</div>

<!-- 其他页面引用footer页面中的碎片-->
<div th:insert="~{footer::footer_fragment}">
		测试insert碎片
	</div>

<div th:replace="~{footer::footer_fragment}">
	测试insert碎片
</div>
```
