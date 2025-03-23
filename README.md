# PMS-Boot 项目管理系统

基于 Java 17 + Spring Boot 3 + Spring Security 构建的项目开发管理系统。

## 项目介绍

PMS-Boot 是一个现代化的项目管理系统，采用最新的技术栈，提供完整的项目管理功能，包括用户管理、权限管理、项目管理、任务管理、工单管理、代码生成等功能。

## 技术栈

### 后端技术栈

- **基础框架**：Spring Boot 3.3.6
- **安全框架**：Spring Security
- **持久层框架**：MyBatis Plus 3.5.5
- **数据库连接池**：Druid 1.2.24
- **数据库**：MySQL 9.1.0
- **缓存**：Redis + Caffeine
- **文档工具**：Knife4j 4.5.0 (基于OpenAPI 3)
- **对象存储**：MinIO 8.5.10 / 阿里云OSS
- **工具类库**：Hutool 5.8.34
- **对象转换**：MapStruct 1.6.3
- **Excel处理**：EasyExcel 3.2.1
- **分布式锁**：Redisson 3.40.2
- **验证码**：Hutool Captcha
- **邮件服务**：Spring Mail
- **微信开发**：WxJava 4.5.5.B

### 前端技术栈

- Vue 3
- Element Plus
- TypeScript

## 功能特性

1. **用户权限管理**
   - 用户管理
   - 角色管理
   - 菜单管理
   - 权限控制

2. **项目管理**
   - 项目创建与配置
   - 项目成员管理
   - 项目进度跟踪
   - 项目文档管理

3. **任务管理**
   - 任务创建与分配
   - 任务状态跟踪
   - 任务优先级管理
   - 任务评论与附件

4. **工单系统**
   - 工单创建
   - 工单处理流程
   - 工单状态追踪
   - 工单统计分析

5. **代码生成器**
   - 自定义模板
   - 字段配置
   - 表单配置
   - 前后端代码生成

6. **系统功能**
   - 验证码登录
   - JWT 认证
   - 邮件通知
   - 文件上传
   - 接口文档
   - 多级缓存
   - 分布式锁

## 项目结构

```
pms-boot
├── src/main/java
│   └── com.yantz.boot
│       ├── config           // 配置类
│       ├── core            // 核心功能
│       │   ├── filter      // 过滤器
│       │   ├── security    // 安全相关
│       │   └── ...
│       ├── shared          // 共享模块
│       │   ├── auth        // 认证授权
│       │   ├── file        // 文件处理
│       │   └── codegen     // 代码生成
│       ├── system          // 系统管理
│       ├── project         // 项目管理
│       ├── task           // 任务管理
│       ├── workorder      // 工单管理
│       └── release        // 发布管理
├── src/main/resources
│   ├── mapper             // MyBatis映射文件
│   ├── templates          // 模板文件
│   └── application.yml    // 配置文件
└── pom.xml               // 项目依赖
```

## 快速开始

### 环境要求

- JDK 17+
- MySQL 8.0+
- Redis 6.0+
- Maven 3.8+

### 开发环境配置

1. **克隆项目**
```bash
git clone https://github.com/your-username/pms-boot.git
```

2. **配置数据库**
- 创建数据库：yantz_boot
- 导入数据库脚本：sql/yantz_boot.sql

3. **修改配置**
编辑 `application-dev.yml`，配置数据库连接信息：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/yantz_boot
    username: your-username
    password: your-password
```

4. **启动项目**
```bash
mvn spring-boot:run
```

5. **访问接口文档**
- 访问地址：http://localhost:8989/doc.html
- 默认账号：admin
- 默认密码：123456

### 生产环境部署

1. **打包**
```bash
mvn clean package
```

2. **运行**
```bash
java -jar yantz-boot.jar --spring.profiles.active=prod
```

## 开发指南

### 代码生成

1. 配置代码生成模板 (`codegen.yml`)
```yaml
codegen:
  defaultConfig:
    author: your-name
    moduleName: your-module
```

2. 使用代码生成器生成代码
- 访问代码生成器页面
- 选择数据表
- 配置生成选项
- 点击生成代码

### 新增功能模块

1. 创建实体类
2. 创建Mapper接口和XML
3. 创建Service接口和实现类
4. 创建Controller
5. 配置权限和菜单

## 项目特点

1. **现代化技术栈**
   - 采用 Java 17 新特性
   - 使用 Spring Boot 3 最新版本
   - 支持响应式编程

2. **安全性**
   - 基于 JWT 的认证
   - 细粒度的权限控制
   - 防止 XSS 攻击
   - 支持验证码登录

3. **高性能**
   - 多级缓存设计
   - 数据库连接池优化
   - 异步处理机制

4. **可扩展性**
   - 模块化设计
   - 插件化架构
   - 支持自定义开发

5. **开发效率**
   - 强大的代码生成器
   - 丰富的工具类库
   - 完善的开发文档

## 常见问题

1. **验证码无法显示**
   - 检查验证码配置是否正确
   - 确认Redis服务是否正常运行

2. **文件上传失败**
   - 检查存储服务配置
   - 确认文件大小是否超过限制

3. **接口访问异常**
   - 检查token是否过期
   - 确认是否有相应的访问权限

## 贡献指南

1. Fork 项目
2. 创建功能分支
3. 提交代码
4. 创建 Pull Request

## 版本历史

- v1.0.0 - 2024.03
  - 项目初始化
  - 基础功能实现
  - 核心模块开发

## 许可证

[MIT License](LICENSE)

## 联系方式

- 作者：Ray.Hao
- 邮箱：your-email@example.com
- 项目地址：https://github.com/your-username/pms-boot

## 致谢

感谢所有为这个项目做出贡献的开发者！

