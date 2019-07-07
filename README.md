# 项目名: idea-coding-proj

## 内容包括
- java
- j2ee
  - mysql
  - mongo
- scala
- design
- redis
- thrift
- play
- spark

## 日志记录
- 日志均记录在项目路径下

## 编译部署
- 编译项目
    - mvn clean compile
- 将项目编译到本地仓库
    - mvn compile -pl java,scala install
- 打包
    - mvn package
- 插件
    - maven-assembly-plugin
    - maven-shade-plugin
    - maven-compiler-plugin
    - maven-jar-plugin
    - maven-dependency-plugin
- 部署
    - 通过指令    

## 测试
> 新知识点，可以合并到该项目中，形成测试用例

## pom版本
> 测试环境下使用version-SNAPSHOT，正式环境下使用version即可