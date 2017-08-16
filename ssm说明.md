# Intellij SSM ��Ŀ�

��ǩ���ո�ָ����� java

---

## Ŀ¼

[TOC]

---

## ����
> �½���Ŀ ����Ҫ���ñ���
Setting -> Editor -> File Encoding

> ��������Ŀ��Ϊ��

## ��������
>  �����ڹ�������
1. ��װ`java8`����
2. ��װ`maven`����
3. ��װ`tomcat`����
4. `mybatis`���ɴ��빤��
5. `mysql`���ݿ�
6. `navicat`���ݿ������

## Intellij tomcat ����
>  �ο���ַ��`http://www.cnblogs.com/Miracle-Maker/articles/6476687.html`
1. `Run` -> `Edit Configurations` -> `+`�� -> ѡ�� `Tomcat Server` -> `Local`
2. `Server` ����, ������ο������ַ
3. `Deployment`����, ������ο������ַ

## Maven ��װ������

- `Maven`��������

> 
1. �½���������`MAVEN_HOME`  ����ֵ��`E:\apache-maven-3.3.9`�������ҵ�`maven`·����
2. �༭��������`Path`  ����ǰ����ϣ�`%MAVEN_HOME%\bin;`��ע�⣬���Ҫ�и�";"��Ϊ�ָ�����
    
   
**- ��`E:\apache-maven-3.3.9\conf` ��`settings.xml` �ļ�������`mirrors`���ӽڵ㣬�������`mirror`**
```
    <!--ָ�����زֿ�-->
    <localRepository>E:\apache-maven-3.3.9\localRepository</localRepository>

    <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>*</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror> 
```

- `Intellij`������`maven`

> 
1. File -> Settings -> Build -> Build Tool -> Maven
    - Maven home directory => E:/apache-maven-3.3.9
    - User setting file => E:\apache-maven-3.3.9\conf\settings.xml
    - Local Repository => E:\apache-maven-3.3.9\localRepository
2. �ο���ַ: http://blog.csdn.net/qq_32588349/article/details/51461182
    
## `SSM` ��Ŀ����

> 
1. �ο���ַ: 
**http://blog.csdn.net/w8897282/article/details/71173211**
http://www.cnblogs.com/jingpeipei/p/6291071.html
http://blog.csdn.net/jiangpeng59/article/details/52118664
http://blog.csdn.net/gebitan505/article/details/44455235/

## `Maven` `pom.xml` ����


## `jdbc.properties` ����
```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8
username=root
password=123456
#�����ʼ������
initialSize=0
#�������������
maxActive=20
#����������
maxIdle=20
#������С����
minIdle=1
#������ȴ�ʱ��
maxWait=60000
```

## `log4j.properties` ����

> �ο���ַ: http://blog.csdn.net/zhshulin/article/details/37937365

```
#����LOG�������
log4j.rootLogger=INFO,Console,File
#������־���Ŀ�ĵ�Ϊ����̨
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.Target=System.out
#��������ָ����־�����ʽ������һ����ָ������ĸ�ʽ
log4j.appender.Console.layout = org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=[%c] - %m%n

#�ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ�
log4j.appender.File = org.apache.log4j.RollingFileAppender
#ָ�����Ŀ¼
log4j.appender.File.File = logs/ssm.log
#�����ļ�����С
log4j.appender.File.MaxFileSize = 10MB
# ���������־���������DEBUG��ʾ���DEBUG���ϼ�����־
log4j.appender.File.Threshold = ALL
log4j.appender.File.layout = org.apache.log4j.PatternLayout
log4j.appender.File.layout.ConversionPattern =[%p] [%d{yyyy-MM-dd HH\:mm\:ss}][%c]%m%n
```

## WEB-INF->web.xml ����
```
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">
  <display-name>Archetype Created Web Application</display-name>
  <!-- Spring��mybatis�������ļ� -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring-mybatis.xml</param-value>
  </context-param>

  <!--Log4j����-->
  <context-param>
    <param-name>log4jRefreshInterval</param-name>
    <param-value>60000</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>

  <!-- ��������� -->
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

  <!--Spring������ ApplicationContext ���� -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!-- ��ֹSpring�ڴ���������� -->
  <listener>
    <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
  </listener>

  <!-- Spring MVC �������ÿ�ʼ -->
  <servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- ����ͨ��contextConfigLocation���Զ���SpringMVC�����ļ���λ�ã��粻ָ������Ĭ����WEB-INFĿ¼�£�����Ϊ[<servlet-name>]-servlet.xml��
         ��ʱ�ļ�������Ϊ[<servlet-name>]-servlet.xml����������-->
    <!--����init-param���Զ���SpringMVC�������ļ���λ�� -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>


  <!-- �������� -->
  <servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <!-- �˴����Կ������ó�*.do����Ӧstruts�ĺ�׺ϰ�� -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <!-- Spring MVC �������ý��� -->

  <!-- ����SESSION��ʱ����λ�Ƿ��� -->
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
    <!-- �Զ�ɨ��ð���ʹSpringMVC��Ϊ��������@controllerע������ǿ����� -->
    <context:component-scan base-package="com.springmvc.controller" />

    <!--����IEִ��AJAXʱ������JSON���������ļ� -->
    <bean id="mappingJacksonHttpMessageConverter"
          class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/html;charset=UTF-8</value>
            </list>
        </property>
    </bean>
    <!-- ����SpringMVC��ע�⹦�ܣ���������ע��POJO��ӳ�� -->
    <bean
            class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="messageConverters">
            <list>
                <ref bean="mappingJacksonHttpMessageConverter" />   <!-- JSONת���� -->
            </list>
        </property>
    </bean>
    <!-- ������ת���ļ���ǰ��׺ ����ͼģʽ����-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- ����������ҵ�������Զ�������action�ķ���return���ַ�������ǰ׺�ͺ�׺�����һ�� ���õ�url��ַ -->
        <property name="prefix" value="/WEB-INF/page/" />
        <property name="suffix" value=".jsp" />
    </bean>

    <!-- �����ļ��ϴ������û��ʹ���ļ��ϴ����Բ������ã���Ȼ������䣬��ô�����ļ���Ҳ���������ϴ������ -->
    <bean id="multipartResolver"
          class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!-- Ĭ�ϱ��� -->
        <property name="defaultEncoding" value="utf-8" />
        <!-- �ļ���С���ֵ -->
        <property name="maxUploadSize" value="10485760000" />
        <!-- �ڴ��е����ֵ -->
        <property name="maxInMemorySize" value="40960" />
    </bean>

    <!-- �������󷵻�json�ַ����������������� -->
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
    <!-- �Զ�ɨ�� -->
    <context:component-scan base-package="com.springmvc" />
    <!-- ���������ļ� -->
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
        <!-- ��ʼ�����Ӵ�С -->
        <property name="initialSize" value="${initialSize}"></property>
        <!-- ���ӳ�������� -->
        <property name="maxActive" value="${maxActive}"></property>
        <!-- ���ӳ������� -->
        <property name="maxIdle" value="${maxIdle}"></property>
        <!-- ���ӳ���С���� -->
        <property name="minIdle" value="${minIdle}"></property>
        <!-- ��ȡ�������ȴ�ʱ�� -->
        <property name="maxWait" value="${maxWait}"></property>
    </bean>

    <!-- spring��MyBatis�������ϣ�����Ҫmybatis������ӳ���ļ� -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--<property name="configLocation" value="classpath:/mybatis-config.xml"></property>-->
        <!-- �Զ�ɨ��mapping.xml�ļ� -->
        <property name="mapperLocations" value="classpath:com/springmvc/mapping/*.xml"></property>

    </bean>

    <!-- DAO�ӿ����ڰ�����Spring���Զ��������µ��� -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.springmvc.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>

    <!-- (�������)transaction manager, use JtaTransactionManager for global tx -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
</beans>
```