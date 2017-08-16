# Intellij SSM 项目搭建

标签（空格分隔）： java

---

## 目录

[TOC]

---

## 描述
> 新建项目 都需要设置编码
Setting -> Editor -> File Encoding

> 配置以项目中为主

## 环境所需
>  都可在官网下载
1. 安装`java8`环境
2. 安装`maven`环境
3. 安装`tomcat`环境
4. `mybatis`生成代码工具
5. `mysql`数据库
6. `navicat`数据库管理工具

## Intellij tomcat 配置
>  参考地址：`http://www.cnblogs.com/Miracle-Maker/articles/6476687.html`
1. `Run` -> `Edit Configurations` -> `+`号 -> 选择 `Tomcat Server` -> `Local`
2. `Server` 配置, 具体请参考上面地址
3. `Deployment`配置, 具体请参考上面地址

## Maven 安装及配置

- `Maven`环境变量

> 
1. 新建变量名：`MAVEN_HOME`  变量值：`E:\apache-maven-3.3.9`（这是我的`maven`路径）
2. 编辑变量名：`Path`  在最前面加上：`%MAVEN_HOME%\bin;`（注意，最后要有个";"作为分隔符）
    
   
**- 在`E:\apache-maven-3.3.9\conf` 的`settings.xml` 文件里配置`mirrors`的子节点，添加如下`mirror`**
```
    <!--指定本地仓库-->
    <localRepository>E:\apache-maven-3.3.9\localRepository</localRepository>

    <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>*</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror> 
```

- `Intellij`中配置`maven`

> 
1. File -> Settings -> Build -> Build Tool -> Maven
    - Maven home directory => E:/apache-maven-3.3.9
    - User setting file => E:\apache-maven-3.3.9\conf\settings.xml
    - Local Repository => E:\apache-maven-3.3.9\localRepository
2. 参考地址: http://blog.csdn.net/qq_32588349/article/details/51461182
    
## `SSM` 项目创建

> 
1. 参考地址: 
**http://blog.csdn.net/w8897282/article/details/71173211**
http://www.cnblogs.com/jingpeipei/p/6291071.html
http://blog.csdn.net/jiangpeng59/article/details/52118664
http://blog.csdn.net/gebitan505/article/details/44455235/

## `Maven` `pom.xml` 配置


## `jdbc.properties` 配置
```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8
username=root
password=123456
#定义初始连接数
initialSize=0
#定义最大连接数
maxActive=20
#定义最大空闲
maxIdle=20
#定义最小空闲
minIdle=1
#定义最长等待时间
maxWait=60000
```

## `log4j.properties` 配置

> 参考地址: http://blog.csdn.net/zhshulin/article/details/37937365

```
#定义LOG输出级别
log4j.rootLogger=INFO,Console,File
#定义日志输出目的地为控制台
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.Target=System.out
#可以灵活地指定日志输出格式，下面一行是指定具体的格式
log4j.appender.Console.layout = org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=[%c] - %m%n

#文件大小到达指定尺寸的时候产生一个新的文件
log4j.appender.File = org.apache.log4j.RollingFileAppender
#指定输出目录
log4j.appender.File.File = logs/ssm.log
#定义文件最大大小
log4j.appender.File.MaxFileSize = 10MB
# 输出所以日志，如果换成DEBUG表示输出DEBUG以上级别日志
log4j.appender.File.Threshold = ALL
log4j.appender.File.layout = org.apache.log4j.PatternLayout
log4j.appender.File.layout.ConversionPattern =[%p] [%d{yyyy-MM-dd HH\:mm\:ss}][%c]%m%n
```

## WEB-INF->web.xml 配置
```
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">
  <display-name>Archetype Created Web Application</display-name>
  <!-- Spring和mybatis的配置文件 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring-mybatis.xml</param-value>
  </context-param>

  <!--Log4j配置-->
  <context-param>
    <param-name>log4jRefreshInterval</param-name>
    <param-value>60000</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>

  <!-- 编码过滤器 -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>

  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--Spring监听器 ApplicationContext 载入 -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!-- 防止Spring内存溢出监听器 -->
  <listener>
    <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
  </listener>

  <!-- Spring MVC 核心配置开始 -->
  <servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 可以通过contextConfigLocation来自定义SpringMVC配置文件的位置，如不指定，则默认在WEB-INF目录下，名称为[<servlet-name>]-servlet.xml，
         此时文件名必须为[<servlet-name>]-servlet.xml，否则会出错-->
    <!--以下init-param是自定义SpringMVC的配置文件的位置 -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>


  <!-- 拦截设置 -->
  <servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <!-- 此处可以可以配置成*.do，对应struts的后缀习惯 -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <!-- Spring MVC 核心配置结束 -->

  <!-- 配置SESSION超时，单位是分钟 -->
  <session-config>
    <session-timeout>15</session-timeout>
  </session-config>

</web-app>
```

## spring-mvc.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd
                        http://www.springframework.org/schema/mvc
                        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">
    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
    <context:component-scan base-package="com.springmvc.controller" />

    <!--避免IE执行AJAX时，返回JSON出现下载文件 -->
    <bean id="mappingJacksonHttpMessageConverter"
          class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/html;charset=UTF-8</value>
            </list>
        </property>
    </bean>
    <!-- 启动SpringMVC的注解功能，完成请求和注解POJO的映射 -->
    <bean
            class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="messageConverters">
            <list>
                <ref bean="mappingJacksonHttpMessageConverter" />   <!-- JSON转换器 -->
            </list>
        </property>
    </bean>
    <!-- 定义跳转的文件的前后缀 ，视图模式配置-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 这里的配置我的理解是自动给后面action的方法return的字符串加上前缀和后缀，变成一个 可用的url地址 -->
        <property name="prefix" value="/WEB-INF/page/" />
        <property name="suffix" value=".jsp" />
    </bean>

    <!-- 配置文件上传，如果没有使用文件上传可以不用配置，当然如果不配，那么配置文件中也不必引入上传组件包 -->
    <bean id="multipartResolver"
          class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!-- 默认编码 -->
        <property name="defaultEncoding" value="utf-8" />
        <!-- 文件大小最大值 -->
        <property name="maxUploadSize" value="10485760000" />
        <!-- 内存中的最大值 -->
        <property name="maxInMemorySize" value="40960" />
    </bean>

    <!-- 处理请求返回json字符串的中文乱码问题 -->
    <mvc:annotation-driven>
        <mvc:message-converters>
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>application/json;charset=UTF-8</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
</beans>
```

## spring-mybatis.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd
                        http://www.springframework.org/schema/mvc
                        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">
    <!-- 自动扫描 -->
    <context:component-scan base-package="com.springmvc" />
    <!-- 引入配置文件 -->
    <bean id="propertyConfigurer"
          class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location" value="classpath:jdbc.properties" />
    </bean>

    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
          destroy-method="close">
        <property name="driverClassName" value="${driver}" />
        <property name="url" value="${url}" />
        <property name="username" value="${username}" />
        <property name="password" value="${password}" />
        <!-- 初始化连接大小 -->
        <property name="initialSize" value="${initialSize}"></property>
        <!-- 连接池最大数量 -->
        <property name="maxActive" value="${maxActive}"></property>
        <!-- 连接池最大空闲 -->
        <property name="maxIdle" value="${maxIdle}"></property>
        <!-- 连接池最小空闲 -->
        <property name="minIdle" value="${minIdle}"></property>
        <!-- 获取连接最大等待时间 -->
        <property name="maxWait" value="${maxWait}"></property>
    </bean>

    <!-- spring和MyBatis完美整合，不需要mybatis的配置映射文件 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--<property name="configLocation" value="classpath:/mybatis-config.xml"></property>-->
        <!-- 自动扫描mapping.xml文件 -->
        <property name="mapperLocations" value="classpath:com/springmvc/mapping/*.xml"></property>

    </bean>

    <!-- DAO接口所在包名，Spring会自动查找其下的类 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.springmvc.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>

    <!-- (事务管理)transaction manager, use JtaTransactionManager for global tx -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
</beans>
```