# SpringBoot

![](springboot.png)

> Short blurb about what your product does.

[![NPM Version][npm-image]][npm-url]
[![Build Status][travis-image]][travis-url]
[![Downloads Stats][npm-downloads]][npm-url]
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

本仓库包含以下内容：

1. SpringBoot各种Demo集合项目[demo](https://github.com/michrow/spring-boot/tree/master/demo)
2. SpringBoot各个知识点运用汇总项目[myapp](https://github.com/michrow/spring-boot/tree/master/myapp)

## 内容列表

- [背景](#背景)
- [安装](#安装)
- [使用](#使用)
- [项目更新记录](#文档)
- [相关仓库](#相关仓库)
- [维护者](#维护者)
- [如何贡献](#如何贡献)
- [使用许可](#使用许可)

## 背景

在SpringBoot学习过程会写大量的示例demo，本仓库主要记录各个demo代码。

这个仓库的目标是：


1. 记录SpringBoot学习历程
2. 记录各个demo
3. 学习结果检查，及做一个完成项目汇总
4. 学习应用github


## 安装

这个项目使用 [node](http://nodejs.org) 和 [npm](https://npmjs.com). 请确保你本地安装了它们。
```sh
$ npm install --global standard-readme-spec
```

## 使用
### case:
[custom-initializr](case/custom-initializr)

springboot initializr是新建SpringBoot项目的一个工具应用，用户可以根据需要定制此工具，
custom-initializr就是一个定制之后的一个应用。

使用方式：
可以直接启动项目，在开发工具中地址选择：<http://localhost:8080>即可。

## 文档

文档是对项目开发过程中遇到的一些问题的详细记录，主要是为了帮助没有基础的小伙伴快速理解这个项目。

1. [权限数据库设计](https://github.com/lenve/vhr/wiki/1.%E6%9D%83%E9%99%90%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1)
2. [服务端环境搭建](https://github.com/lenve/vhr/wiki/2.%E6%9C%8D%E5%8A%A1%E7%AB%AF%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA)

### 更新记录

### 2020.2.20

引入thymeleaf,首先取出原来演示mybatis分页插件引入的freemarker
修改：
1、pom.xml:
去处：
spring-boot-starter-freemarker引入

2、db配置文件，去除freemarker配置




### 2020.2.17

本阶段完成如下事：
1、补充Mybais 分页插件示例操作：

- 分页插件pageHelper
	* 引入依赖
	* 代码示例
	* 样例
	* 注意事项



### 2020.2.15

本阶段主要添加了db使用mybatis操作数据的操作。主要功能如下：
[具体可参看笔记](https://app.yinxiang.com/shard/s43/nl/23892682/f66de40b-3b40-4809-bf99-dc526230ec0e)

- Mapper.xml
	- CRUD标签
		- select insert update delete
	- \#{}和${}
		- 参数定位 
		- 模糊查询
	- ResultMap
		- POJO属性名与数据库列明不一致
		- 高级查询
			- 一对一 一对多 多对多 延迟加载
	- SQL片段 
	- 动态SQL
		if choose、when、otherwise where set foreach
	- SQL中特殊符号处理
		- 使用转义符
- 缓存
	- 一级缓存 
	- 二级缓存 
	- 总结（生产环境不建议使用）
- 问题及解决方式
	- 数据库列与POJO不一致 
	- mybatis 在多数据源情况下配置不生效 
	- POJO包扫描别称 
	- 获取自增主键 
	- MyBatis开启日志 
	- Mybatis 一对多查询时，数据覆盖


### 2020.2.13 更新

本次更新主要完善README.md，按照标准README.md建议修改文档


#### 相关文档：

1. [部门数据库设计与存储过程编写](https://github.com/lenve/vhr/wiki/12.%E9%83%A8%E9%97%A8%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1%E4%B8%8E%E5%AD%98%E5%82%A8%E8%BF%87%E7%A8%8B%E7%BC%96%E5%86%99)

## 相关仓库

- [Art of Readme](https://github.com/noffle/art-of-readme) - 💌 写高质量 README 的艺术。
- [open-source-template](https://github.com/davidbgk/open-source-template/) - 一个鼓励参与开源的 README 模板。

## 维护者

[@michrow](https://github.com/michrow).

## 如何贡献

非常欢迎你的加入! [提一个Issue](https://github.com/RichardLitt/standard-readme/issues/new) 或者提交一个 Pull R equest.


标准 Readme 遵循 [Contributor Covenant](http://contributor-covenant.org/version/1/3/0/) 行为规范.

### 贡献者

感谢以下参与项目的人：


## 使用许可

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki