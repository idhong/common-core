# common-core
基于maven的spring4.3+mybatis3.4+swagger2.6的后台整合，用于快速构建中小型API、RESTful API项目，该项目简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写。


### 已完成功能
- 增加权限统一拦截注解`@Authentication`
- 增加方法性能统计注解`@printRunTime`
- 实现了简单的权限系统
- 实现了简单的操作日志
- 生成entity类时自动提取数据库注释生成swagger文档
- 实现了更漂亮的swagger-ui

### 快速开始
- clone本项目，创建下面的数据库和表
- 使用IDE导入本项目，使用maven方式导入项目
- 配置`jdbc.properties`下面的数据库相关信息（如果你需要使用mybitis逆向插件，也需要配置`generatorConfig.xml`这个文件中的数据库信息）
- 使用maven编译后，配置tomcat并部署
- 启动tomcat,访问以下链接测试接口；
- 访问`http://localhost:8080/docs/index.html` 查看swagger生成的Api文档信息


### 建表语句
```sql
create database playground;

use playground;

create table user (
   id int unsigned  primary key AUTO_INCREMENT comment '用户表',
   username varchar(100),
   password varchar(100),
   idcard varchar(100) comment '身份证',
   email varchar(100),
   name varchar(100),
   sex int comment '性别0女2男',
   phone varchar(100),
   enable int comment '是否启用0false，1true',
   isdel int comment '是否删除0false, 1true'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 create table role (
   id int unsigned  primary key AUTO_INCREMENT comment '角色表',
   name varchar(100),
   enable int,
   isdel int
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  create table permission (
   id int unsigned  primary key AUTO_INCREMENT comment '权限表',
   name varchar(100),
   isdel int
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 create table role_permission_map (
   id int unsigned  primary key AUTO_INCREMENT comment '角色-权限映射表',
   role_id int unsigned,
   permission_id int unsigned,
   isdel int
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 create table user_role_map (
   id int unsigned  primary key AUTO_INCREMENT comment '用户-角色映射表',
   user_id int unsigned,
   role_id int unsigned,
   isdel int
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```


### 开发者建议
- 表名，建议使用小写，多个单词使用下划线拼接
- entity内成员变量建议与表字段数量对应,`controller`层使用`application/json`传参,参数可以考虑封装成DTO对象
- 需要工具类的话建议先从`common/utils`中找，实在没有再造轮子或引入类库，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/lihengming/java-codes/blob/master/shared-resources/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8CV1.2.0.pdf))
- 建议在公司内部使用ShowDoc、Swagger2 、RAP等开源项目来编写、管理API文档


### 相关环境
- OS Microsoft Windows 10 Pro
- Java 8
- springMVC 4.3
- Mybitis 3.4
- Mysql 5.5.50
- Restful interface
- Maven 3.5.3
- Git 2.14.1
- Swagger 2.6.1


### 注意事项
- 下载后请修改`pom.xml`里面的,这里需要引入你的tomcat下的servlet.api.jar
```xml 
<!-- 添加tomcat/bin下servlet-api.jar 注意你tomcat下这个jar包版本-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
    </dependency>
```
- 使用mybaitis-generator插件生成dao层时请先删除原来的文件,不然生的的内容会追加到源文件中,出现代码重复
- 下载后可能需要修改/webapp/swagger-ui/index.html文件中的url地址.
