--- thymeleafʹ��
��Ŀ�ṹ��
����ͼƬ��

����maven����springboot��Ŀ����
��pox.xml�ļ����thymeleaf������
```
<!-- ģ������ Thymeleaf ���� -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

����thymeleafģ������
application.properties�ļ��м������ã�
```
#thymeleaf����
#ָ�����ʻ��ļ�
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
--- ҳ������thymeleaf
> thymeleaf��ǩʹ�õ�������ʽ
```
data-th-text��ʽ :<div data-th-text="${title}"></div>    ���������������ռ䣬html5֧�ֵ��Զ������ԣ�
th:text��ʽ :<div data-th-text="${title}"></div>  �������������ռ䣩
```

thymeleaf�����ռ�
```
<html xmlns:th="http://www.thymeleaf.org">
```

--- thymeleaf�﷨
> th:text �ı���ʾ
```
<div th:text="${title}">hello world</div>
```


�����ڱ�ǩ��ʹ�������`+, -, *, /, %`��
```
�������<div th:text="'1 + 1 =' + ${number} * 2 "></div>
```

--- thymeleaf���ʽ
> ${} �������ʽ������ҳ���еı�����ͬEL���ʽ�е�${}����һ����
```
<div th:text="${title}"></div>
```

> #{} ��Ϣ���ʽ�����ֹ��ʻ����ʽ�����������ù��ʻ���Դ�ļ��е�������Ϣ��
��home.properties:
```
home.welcome=this messages is from home.properties!
```
home_zh_CN.properties:
```
home.welcome=������home.properties��Ϣ
```
Note�����ù��ʻ���Դ�ļ�ʱ��һ��Ҫ����Ĭ�ϵ�XX.properties�ļ����ٽ������������µ�XX_zh_CN.properties�ļ���

ʹ����Ϣ���ʽ�������֣�
```
<div th:text="#{home.welcome}"></div>
```
> ʹ����Ϣ���ʽʱ���������ֵĴ���??home.welcome_zh_CN??
> �����ṩ�Ľ��������
> ��һ�֣���thymeleafҳ�������룺
>
> `<link rel="stylesheet" type="text/css" media="all" href="../../css/gtvg.css" th:href="@{/css/gtvg.css}" />`
>
> ����css�ļ����µ�gtvg.css����������û������ļ����������ֽ����ʽ����û��Ч��
> �ڶ��֣�
> ��application.properties�ļ��м���һ�����ã�
> #ָ�����ʻ��ļ�λ��
> spring.messages.basename=templates/home
> �ײ���Ч�������������гɹ���

> *{} ѡ����ʽ :ѡ�������ж��������

```
<div th:object="${user}">
	<span th:text="*{name}">
	</span>
</div>
```

> @{} ���ӱ��ʽ:���ӵ���д
```
���ӱ��ʽ:
<a th:href="@{../static/js/test.js}">��Ե�ǰ·��</a>
<a th:href="@{~/static/js/test.js}">��Է�����</a>
<a th:href="@{//static/js/test.js}">���Э��·��</a>
<a th:href="@{http://localhost:8080/static/js/test.js}">����·��</a>
```
> �ֶα��ʽ
```
<!-- footerҳ���ж�����Ƭfooter_fragment -->
<div th:fragment="footer_fragment">
    &copy;2019 sdongwan
</div>

<!-- ����ҳ������footerҳ���е���Ƭ-->
<div th:insert="~{footer::footer_fragment}">
		����insert��Ƭ
	</div>

<div th:replace="~{footer::footer_fragment}">
	����insert��Ƭ
</div>
```
