# SpringApplication 

SpringApplication封装了SpringBoot应用的启动过程，对于用户完全透明，因此用户只需要一行代码就可以启`SpringApplication.run(DemoApplication.class, args);`

如果对启动有什么特殊要求也可以按照如下方式来实现扩展：

```java
SpringApplication app = new SpringApplication( DemoApplication.class ); 
app.setXXX( ... ); // 用户自定的扩展在此 ！！！ 	
app.run( args );
```

> [Spring Boot 启动过程定制化](https://blog.csdn.net/dm_vincent/article/details/77151122)

# SpringApplication启动Spring Boot

一般情况下，SpringApplication按照下列步骤执行Spring Boot 应用的启动：

- Create an appropriate [`ApplicationContext`](https://docs.spring.io/spring-framework/docs/5.2.4.RELEASE/javadoc-api/org/springframework/context/ApplicationContext.html?is-external=true) instance (depending on your classpath)
- Register a [`CommandLinePropertySource`](https://docs.spring.io/spring-framework/docs/5.2.4.RELEASE/javadoc-api/org/springframework/core/env/CommandLinePropertySource.html?is-external=true) to expose command line arguments as Spring properties
- Refresh the application context, loading all singleton beans
- Trigger any [`CommandLineRunner`](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/api/org/springframework/boot/CommandLineRunner.html) beans

​	![](img\2020-03-22_123600.jpg)

**1、SpringApplication构造函数**

![](E:\work\SpringBoot-201912-2020\workspace\spring-boot\doc\img\2020-03-22_105147.jpg)

- 判断应用类型

  根据加载的类判断应用类型：REACTIVE、SERVLET、NONE

  ![](img\2020-03-22_105740.jpg)

- 加载初始化Initializer

  使用 `SpringFactoriesLoader`查找并加载 classpath下 `META-INF/spring.factories`文件中所有可用的 `ApplicationContextInitializer`

  ![](img\2020-03-22_110752.jpg)

- 加载监听Listener

  使用 `SpringFactoriesLoader`查找并加载 classpath下 `META-INF/spring.factories`文件中的所有可用的 `ApplicationListener`

- 推断设置main方法的定义类

  ![](img\2020-03-22_110931.jpg)

**2、SpringApplication的run**

![](img\2020-03-22_113438.jpg)