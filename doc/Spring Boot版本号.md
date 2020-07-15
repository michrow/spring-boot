# Spring Boot版本号
1.传统的版本号规则是什么？

springframework-4.3.11.RELEASE


主版本号.次版本号.增强版本号.里程碑版本号

主版本号：项目的重大重构

次版本号：新功能的添加和变化

增强版本号：BUG的修复

里程碑版本号：release

Alpha: 此版本表示该软件在此阶段主要是以实现软件功能为主，通常只在软件开发者内部交流，一般而言，该版本软件的Bug较多，需要继续修改。

Beta: 该版本相对于α版已有了很大的改进，消除了严重的错误，但还是存在着一些缺陷，需要经过多次测试来进一步消除，此版本主要的修改对像是软件的UI。

M: 又叫里程碑版本，表示该版本较之前版本有功能上的重大更新。

RC: 该版本已经相当成熟了，基本上不存在导致错误的BUG，与即将发行的正式版相差无几。

Release: 该版本意味“最终版本”，在前面版本的一系列测试版之后，终归会有一个正式版本，是最终交付用户使用的一个版本。该版本有时也称为标准版。一般情况下，Release不会以单词形式出现在软件封面上，取而代之的是符号(R)。

2.为什么springcloud版本用的是单词而不是数字？
设计的目的是为了管理好每个springcloud的子项目清单，避免自己的版本和子项目（子框架）的版本号混淆。

大版本对应关系

| SpringBoot版本 | Spring Cloud             |
| -------------- | ------------------------ |
| 1.2.x          | Angel版本                |
| 1.3.x          | Brixton版本              |
| 1.4.x stripes  | Camden版本               |
| 1.5.x          | Dalston版本、Edgware版本 |
| 2.0.x          | Finchley版本             |
| 2.1.x          | Greenwich.SR2            |
[详细版本信息](https://start.spring.io/actuator/info)

3.什么是版本的发布计划？

| 版本号    | 版本说明        | 用途                                                         |
| --------- | --------------- | ------------------------------------------------------------ |
| BUILD-XXX | 开发版          | 一般是开发团队内部用的                                       |
| GA        | 稳定版          | 内部开发到一定阶段了，各个模块集成后，经过全面测试，发现没有问题了，可以对外发型了，这个时候就叫GA（AenrallyAvailable）版，系统的核心功能已经可以使用。意思就是基本上可以使用了。 |
| PRE       | (M1,M2)里程碑版 | 由于GA版还不属于公开的发行版，里面还有功能不完善的或者一些BUG，于是就有了milestone（里程碑）版，milestone版本主要修复一些BUG和调整UI。一个GA后，一般有多个里程碑，例如 M1 M2 M3 |
| RC        | 候选发布版      | 从BUILD后GA再到M基本上系统就定型了，这个时候系统就进入RELEASE candidates（RC候选发布）版，该阶段的软件类似于最终发行前的一个观察期，该期间只对一些发现的等级高的BUG进行修复，发布RC1,RC2等版本。 |
| SR        | 正式发布版      | 公开正式发布。正式发布板一般也有多个发布，例如SR1 SR2 SR3等等，一般是用来修复大BUG或优化。 |

作者：微信公众号_Java技术干货
链接：https://www.jianshu.com/p/4094ed555042
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

# Spring Boot 官方版本说明
[Spring Boot 版本更新说明](https://github.com/spring-projects/spring-boot/releases)


```
版本--发布年份--N(新增特性)--B(Bug修复)--E(功能增强)

v2.2.2.RELEASE  2019 12 06 N  B
v2.2.1.RELEASE  2019 11 07 N B
v2.2.0.RELEASE  2019 10 17 N B



v2.1.11.RELEASE 2019 12 06 _ B
v2.1.10.RELEASE 2019 11 06 N B
v2.1.9.RELEASE 2019 10 13 _ B
v2.1.8.RELEASE 2019 09 06 N B
v2.1.7.RELEASE 2019 08 06 N B
v2.1.6.RELEASE 2019 06 19 N B
v2.1.5.RELEASE 2019 05 15 N B 
v2.1.4.RELEASE 2019 04 04 N B
v2.1.3.RELEASE 2019 02 15 _ B
v2.1.2.RELEASE 2019 01 12 N B
v2.1.1.RELEASE 2018 11 30 N B
v2.1.0.RELEASE 2018 10 30 N B

v2.0.9.RELEASE 2019 04 04 _ B
v2.0.8.RELEASE 2019 01 12 N B
v2.0.7.RELEASE 2018 11 30 N B
v2.0.6.RELEASE 2018 10 17 N B 
v2.0.5.RELEASE 2018 09 12 N B
v2.0.4.RELEASE 2018 07 31 N B
v2.0.3.RELEASE 2018 06 15 _ _ E
v2.0.2.RELEASE 2018 05 10 _ B


v1.5.22.RELEASE 2019 08 06 _ B
v1.5.21.RELEASE 2019 05 14 _ B
v1.5.20.RELEASE 2019 04 03 _ B
v1.5.19.RELEASE 2019 01 12 _ _
v1.5.18.RELEASE 2019 11 29 N B
v1.5.17.RELEASE 2018 10 16 _ B
v1.5.16.RELEASE 2018 09 12 N B
v1.5.15.RELEASE 2018 07 31 N B
```


[Spring Boot wiki(版本升级)](https://github.com/spring-projects/spring-boot/wiki)
### Supported Releases
- 2.2.x was released October 2019 and is actively maintained
- 2.1.x was released October 2018 and remains supported until the end of October 2020

### End of Life Releases
- 2.0.x was released March 2018 and entered EOL on April 3rd 2019
- 1.5.x was released January 2017 and is the last in the 1.x line. It entered EOL on August 1st 2019

[spring boot 版本清单 maven仓库](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter)

# 非官方
[JDK与Spring Boot 版本](https://www.cnblogs.com/harrychinese/p/jdk_and_springboot_version.html)

- 优先选择官方指定的long-term support(LTS)版本, 非LTS版本往往会引入较多实验性的特性, 稳定性要比LTS要差一些, LTS版本生命周期甚至会比晚发行的非LTS版更长久.
- 优先选择纯粹的bugfix版, 而不是那种有引入新特性的版本.
- 如果不想跟最新的技术, 选择上一个大版本的最后一个小版本, 这个小版本往往是一个比较稳定的版本
## JDK

JDK 8是LTS版，Jdk 8u191/Jdk 8u192 Oracle官方同时推出的两个最后免费jdk 8发行版更推荐使用 8u191 版. 原因是: 奇数编号的发行版仅包含经验证的bug fix, 偶数编号的发行版不含经验证和非经验证的改进, 所以生产环境推荐使用奇数编号的发行版

openjdk 是一个厂商中立的 jdk, 目前看是一个很好的选择,  下载地址  https://adoptopenjdk.net
## Spring Boot

主要分支：
- 1.5.x 分支(主要依赖Spring framework 4.3)
- 2.0.x 分支(主要依赖Spring framework 5.0.x)
- 2.1.x 分支(主要依赖Spring framework 5.1.x)

# 初步结论
Spring Boot 2.X 选择2.1.3：修复较多Bug且无引入新特性

Spring Boot 1.X 选择1.5.22: 2019的几个版本都在修复BUG，且无引入新特性
## 依赖更新

```
2.1.3 依赖更新
Dependency Upgrades
Upgrade to Commons Pool2 2.6.1 #15946
Upgrade to Lettuce 5.1.4.RELEASE #15945
Upgrade to Lombok 1.18.6 #15928
Upgrade to Pooled Jms Version 1.0.4 #15927
Upgrade to Liquibase 3.6.3 #15926
Upgrade to Mimepull 1.9.11 #15925
Upgrade to Infinispan 9.4.6.Final #15924
Upgrade to Groovy 2.5.6 #15923
Upgrade to Tomcat 9.0.16 #15922
Upgrade to Log4j2 2.11.2 #15921
Upgrade to Artemis 2.6.4 #15920
Upgrade to Byte Buddy 1.9.10 #15919
Upgrade to Mysql 8.0.15 #15918
Upgrade to Undertow 2.0.17.Final #15917
Upgrade to Rxjava2 2.2.6 #15916
Upgrade to Reactor Bom Californium-SR5 #15878
Upgrade to Micrometer 1.1.3 #15869
Upgrade to Spring Session Bean-SR3 #15868
Upgrade to Spring Kafka 2.2.4 #15867
Upgrade to Spring Integration 5.1.3 #15866
Upgrade to Spring AMQP 2.1.4 #15865
Upgrade to Spring Data Lovelace-SR5 #15864
Upgrade to Spring Security 5.1.4 #15863
Upgrade to Spring Framework 5.1.5 #15862
```

```
1.5.22 依赖更新：
Dependency Upgrades
Upgrade to Mysql 5.1.48 #17783
Upgrade to Spring Security Oauth 2.0.18.RELEASE #17671
Upgrade to Spring Security 4.2.13.RELEASE #17670
Upgrade to Spring Cloud Connectors 1.2.9.RELEASE #17669
Upgrade to Jetty 9.4.19.v20190610 #17668
Upgrade to Tomcat 8.5.43 #17667
Upgrade to Httpclient 4.5.9 #17666
Upgrade to Appengine Sdk 1.9.76 #17665
Upgrade to Spring Integration 4.3.21 #17642
Upgrade to Spring AMQP 1.7.14 #17640
Upgrade to spring-javaformat 0.0.15 #17359
Upgrade to Spring Data Ingalls-SR23 #17352
Upgrade to Spring Framework 4.3.25 #17221
Upgrade to Dependency Management Plugin 1.0.8.RELEASE #17149
```
## [环境要求 1.5.22](https://docs.spring.io/spring-boot/docs/1.5.22.RELEASE/reference/html/getting-started-system-requirements.html)

By default, Spring Boot 1.5.22.RELEASE requires Java 7 and Spring Framework 4.3.25.RELEASE or above. You can use Spring Boot with Java 6 with some additional configuration. See Section 85.11, “How to use Java 6” for more details.
- Maven:3.2+
- Gradle:2.9,3.x

```
Name	Servlet Version	Java Version
Tomcat 8	3.1	Java 7+
Tomcat 7	3	Java 6+
Jetty 9.3	3.1	Java 8+
Jetty 9.2	3.1	Java 7+
Jetty 8	3	Java 6+
Undertow 1.3	3.1	Java 7+

You can also deploy Spring Boot applications to any Servlet 3.0+ compatible container.
```
## [环境要求 2.1.3](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/getting-started-system-requirements.html)

Spring Boot 2.1.3.RELEASE requires Java 8 and is compatible up to Java 11 (included). Spring Framework 5.1.5.RELEASE or above is also required.
- Maven:3.3+
- Gradle:4.4+

```
Name	Servlet Version
Tomcat 9.0	4
Jetty 9.4	3.1
Undertow 2.0	4
You can also deploy Spring Boot applications to any Servlet 3.1+ compatible container.
```