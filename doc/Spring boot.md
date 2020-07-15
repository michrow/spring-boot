# 简介

##　基础知识

​		学习SpringBoot之前最好有Spring相关的基础知识(IOC、AOP)、熟悉Spring MVC等

## Spring Boot 指导文档

可以从下述地方寻求帮助：

- 使用[方法文档](https://www.springcloud.cc/spring-boot.html#howto)。他们为最常见的问题提供解决方案。
- 了解Spring基础知识。Spring Boot以许多其他Spring项目为基础。查看 [spring.io](https://spring.io/)网站以获取大量参考文档。如果您从Spring开始，请尝试其中一个[指南](https://spring.io/guides)。
- 问一个问题。我们监控[stackoverflow.com](https://stackoverflow.com/)以获取标记的问题[`spring-boot`](https://stackoverflow.com/tags/spring-boot)。
- 在[github.com/spring-projects/spring-boot/issues上](https://github.com/spring-projects/spring-boot/issues)使用Spring Boot报告错误。

# 起步

## Spring Boot 概述

Spring Boot 可以轻松的创建可以独立运行的，基于生产级Spring的应用程序。Spring Boot 对Spring 平台和第三方库有自己的理解，即约定优于配置，开发者只需要很少的配置即可构建自己的应用。

SpringBoot是目前业内主流的Java开发框架，尤其是在微服务、轻量化方面有着自身的优势，是目前[微服务](https://martinfowler.com/microservices/)开发的首要选择。

**1、 Spring Boot 的主要目标**

- 更快、更广泛入门体验

- 开箱即用，约定优于配置

- 大型项目通用非功能支持：内嵌服务器、安全、监控、健康检查、扩展配置

- 绝对无代码生成，不需要xml配置

**2、系统要求 **

Spring Boot 2.1.x需要Java8 并且与Java11 兼容。Spring框架5.1.3或以上

Spring Boot支持下列三种Servlet 容器[^ 1 ]

| 名称         | Servlet版本 |
| ------------ | ----------- |
| Tomcat 9.0   | 4.0         |
| Jetty 9.4    | 3.1         |
| Undertow 2.0 | 4.0         |

>  Spring Boot 应用可以部署到任意Servlet3.1+兼容的容器中。

构建工具支持Maven和Gradle:

| 构建工具 | 版   |
| -------- | ---- |
| Maven    | 3.3+ |
| Gradle   | 4.4+ |

## Spring Boot 安装

​	Spring Boot 安装有很多种方式可以通过Maven、Gradle、Spring Boot CLI等，下面主要介绍Maven方式，其他方式使用可以参照[官方文档](https://www.springcloud.cc/spring-boot.html#getting-started-installing-spring-boot)。

Spring Boot 与Maven3.3+版本兼容，Spring Boot 依赖项使用`org.springframework.boot` `groupId`。通常，您的Maven POM文件继承自`spring-boot-starter-parent`项目，并声明对一个或多个[“Starters”的](https://www.springcloud.cc/spring-boot.html#using-boot-starter)依赖关系。Spring Boot还提供了一个可选的 [Maven插件](https://www.springcloud.cc/spring-boot.html#build-tool-plugins-maven-plugin)来创建可执行jar。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.example</groupId>
	<artifactId>myproject</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<!-- Inherit defaults from Spring Boot -->
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.7.RELEASE</version>
	</parent>

	<!-- Add typical dependencies for a web application -->
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>

	<!-- Package as an executable jar -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

## Spring Boot 版本升级

> 版本详情参考：Spring Boot版本号.md

如果要从早期版本的Spring Boot升级，请查看 [项目Wiki上的“迁移指南”，](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Migration-Guide) 其中提供了详细的升级说明。另请查看 [“发行说明”](https://github.com/spring-projects/spring-boot/wiki)，了解每个版本的“新的和值得注意的”功能列表。

升级到新版本，某些属性可能发生变更，Spring Boot 提供了一种在启动时分析应用程序并打印诊断报告的方法，需要在项目中添加如下依赖：

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-properties-migrator</artifactId>
	<scope>runtime</scope>
</dependency>
```

> 学习maven[^2]

## 编写第一个Spring Boot 程序

**1、创建POM**

`spring-boot-starter-parent` 是一个特殊的启动器，提供了Maven的默认值，还提供了`dependency-management` 部分，这样在添加依赖时可以不写version。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.7.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example.tools</groupId>
    <artifactId>demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo</name>
    <description>Demo project for Spring Boot</description>
    
</project>
```

>  parent.relativePath：指定parent依赖来源，空值表示取自仓库

添加Web开发相关依赖：

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>
```

> 可以通过 mvn denpendency:tree查看依赖关系

**2、编写程序**

```java
@EnableAutoConfiguration
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

}
```

相关注解解释：

- @EnableAutoConfiguration

  Spring Boot注解，根据配置的jar依赖关系推测如何配置Spring，例如添加了`spring-boot-starter-web` 依赖添加了Tomcat和SpringMVC，所以自动装配认为你正在开发web项目并自动配置相关Spring配置。

- @RestController和@RequestMapping

  这两个注解为SpringMVC注解，详细信息查看[SpringMVC文档](https://docs.spring.io/spring/docs/5.1.3.RELEASE/spring-framework-reference/web.html#mvc)

- run

  参看Spring Boot 启动.md

**3、创建可执行jar**

```
Executable jars and Java:

Java 自身并不提供标准的方法载入内嵌jar，为了解决这个问题，很多开发者使用“超级” jar，即将所有的classes文件打包在一起，这种方法的问题在于很难看出应用程序中有哪些库，并且如果多个jar中含有相同的文件名也会带来问题，所以Spring Boot采用[不同的方法](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#executable-jar)，可以实现加载内嵌jar。
```

添加Spring Boot 应用maven打包插件：spring-boot-maven-plugin

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

# 使用Spring Boot

## 构建项目

1. 继承spring-boot-starter-parent

   **parent 提供了如下基本功能：**

   1. 定义了 Java 编译版本为 1.8 。
   2. 使用 UTF-8 格式编码。
   3. 继承自 `spring-boot-dependencies`，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。
   4. 执行打包操作的配置。[`repackage`](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/maven-plugin/repackage-mojo.html)。
   5. 自动化的资源过滤。[资源过滤](https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html)。
   6. 自动化的插件配置。（[exec插件](http://www.mojohaus.org/exec-maven-plugin/)， [Git提交ID](https://github.com/ktoso/maven-git-commit-id-plugin)和 [shade](https://maven.apache.org/plugins/maven-shade-plugin/)）。
   7. 针对 application.properties 和 application.yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev.properties 和 application-dev.yml。

   ![](img\2020-03-22_175600.jpg)

   **重写版本号**

   ```xml
   <properties>
       <spring-data-releasetrain.version>Fowler-SR2</spring-data-releasetrain.version>
   </properties>
   ```

2. 不继承spring-boot-starter-parent

   **重写依赖**

   有时候项目可能有自己的parent poms，Maven中只允许定义一个parent pom,所以此时不能继承自spring-boot-starter-paretn，采用如下方式引入依赖：

   ```xml
   <dependencyManagement>
       <dependencies>
           <dependency>
               <!-- Import dependency management from Spring Boot -->
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-dependencies</artifactId>
               <version>2.2.0.BUILD-SNAPSHOT</version>
               <type>pom</type>
               <scope>import</scope> 
           </dependency>
       </dependencies>
   </dependencyManagement>
   ```

   **重写版本号**

   ```xml
   <dependencyManagement>
       <dependencies>
           <!-- Override Spring Data release train provided by Spring Boot -->
           <dependency>
               <groupId>org.springframework.data</groupId>
               <artifactId>spring-data-releasetrain</artifactId>
               <version>Fowler-SR2</version>
               <type>pom</type>
               <scope>import</scope>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-dependencies</artifactId>
               <version>2.2.0.BUILD-SNAPSHOT</version>
               <type>pom</type>
               <scope>import</scope>
           </dependency>
       </dependencies>
   </dependencyManagement>
   ```

   **重写打包管理**

   ```xml
   <build>
     <plugins>
       <plugin>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin</artifactId>
         <version>1.4.0.RELEASE</version>
         <configuration>
           <executable>true</executable>
         </configuration>
         <executions>
           <execution>
             <goals>
               <goal>repackage</goal>
             </goals>
           </execution>
         </executions>
       </plugin>
     </plugins>
   </build>
   ```

3. Starters

   Spring Boot  通过提供一组依赖集解决依赖，例如你如果想使用 JPA 操作数据库，只需要添加 spring-boot-starter-data-jpa 依赖。

   - [Spring Boot 官方](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter)：spring-boot-starter-*

   - [第三方提供](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-starters/README.adoc)：thirdpartyproject-spring-boot-starter

   - [自定义Starter](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-custom-starter)

# 架构概述

# 应用程序开发

# Web应用程序开发功能

# 网络服务

# 资料存取

# 通用功能

# 消息链接

# 安全措施

# 单元测试

# 教程

# 附录

[^ 1 ]:  https://www.jianshu.com/p/10ba7a7406ad
[^2]: https://www.jianshu.com/p/a4fc54b5a6bf