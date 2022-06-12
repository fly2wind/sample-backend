# Sample Backend 项目

## 项目背景

本项目旨在提供一个基于Spring Boot的DDD示例，帮助开发者理解和应用领域驱动设计的思想。

## DDD分层架构

本项目严格遵循领域驱动设计(DDD)的分层架构，包含以下四个核心层：

### 展现层 (Representation Layer)

展现层对应了DDD中的「展现层」，同时也对应了Clean Architecture中的「用户界面层」。

**职责**：
- 为外部用户访问底层系统提供交互界面和数据表示
- 从用户处接收命令操作，改变底层系统状态
- 从用户处接收查询操作，将底层系统状态以合适的形式呈现给用户

**对应模块**：`api`

### 应用层 (Application Layer)

应用层对应了DDD中的「应用层」，同时也对应了Clean Architecture中的Application Business Rule。

**职责**：
- 定义系统的业务功能，并指挥领域层中的领域对象实现这些功能
- 作为粗粒度业务的入口（Use Case）
- 不包含复杂的业务规则，而是对领域层进行协调，对业务逻辑进行编排
- 应用层映射到系统用例模型，是系统用例模型在软件中的反映
- 应用层接口描述了系统的全部功能
- 实现类通过排列组合领域层的领域对象来实现用例，职责是「编排和转发」

**对应模块**：`application`

### 领域层 (Domain Layer)

领域层是DDD中的「核心层」，包含业务的核心逻辑。

**职责**：
- 实现业务逻辑，包含业务实体（领域对象）、业务规则、业务策略、完整性约束和业务流程
- 定义领域对象，采用「充血模型」进行建模
- 定义领域对象对应的「仓库」
- 定义「领域服务」对象
- 定义领域层相关的异常（BusinessException）

**对应模块**：`domain`

### 基础设施层 (Infrastructure Layer)

基础设施层对应了DDD中的「基础设施层」。

**职责**：
- 为其余各层提供技术支持
- 是系统中的技术密集部分，为领域层、应用层的业务服务提供具体的技术支持能力
- 提供消息队列中间件、分布式缓存框架、流程引擎、规则引擎、数据库持久化、数据序列化等技术实现

**对应模块**：`infrastructure`

## 项目结构

项目采用模块化设计，包含以下模块：

```
├── api                 # API接口定义和控制器
├── application         # 应用服务层，包含业务逻辑
├── domain              # 领域模型和领域服务
├── infrastructure      # 基础设施层，包含数据库访问、外部服务集成等
├── shared              # 共享模块，包含通用工具类和常量
├── start               # 应用启动模块
└── pom.xml             # Maven项目配置文件
```

## 环境要求

- JDK 17+
- Maven 3.9.3+
- Docker (可选，用于本地开发环境)

## 本地开发环境

项目提供了Docker Compose配置，可以快速启动开发所需的基础设施服务：

```bash
# 启动所有服务
cd .tools/local
./start.sh

# 停止所有服务
./stop.sh
```

可用的Docker服务包括：

- MySQL 数据库
- RabbitMQ 消息队列
- Kafka 消息队列
- Nacos 服务注册与配置中心
- ELK 日志收集与分析

## 构建与运行

### 构建项目

```bash
# 编译整个项目
mvn clean package
```

### 运行应用

```bash
# 方式1：使用Maven运行
cd start
mvn spring-boot:run

# 方式2：直接运行JAR包
java -jar start/target/start-1.0.0-SNAPSHOT.jar
```

## API文档

项目集成了Swagger/OpenAPI，启动应用后可通过以下地址访问API文档：

```
http://localhost:8080/swagger-ui.html
```