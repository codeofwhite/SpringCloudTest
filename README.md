# SpringCloudTest - Spring Cloud 微服务测试项目

欢迎来到 SpringCloudTest，一个基于 Spring Cloud 的微服务测试项目！本项目旨在通过实践掌握 Spring Cloud 的核心组件和技术。

## 项目背景
本项目为 Spring Cloud 微服务架构的学习和实践项目，涵盖了服务注册与发现、服务提供者、服务消费者、API 网关和容错机制等内容。

## 技术栈
- **Spring Cloud**：微服务架构。
- **Eureka**：服务注册与发现。
- **Feign**：声明式 REST 客户端。
- **Hystrix**：服务容错与熔断。
- **API Gateway**：统一 API 网关。
- **Maven**：项目依赖管理。

## 项目结构
### 主要模块
- **springCloud-api**：公共 API 模块。
- **springCloud-client-80**：普通客户端模块（端口 80）。
- **springCloud-client-feign-81**：使用 Feign 的客户端模块（端口 81）。
- **springCloud-eureka-8002/8003**：Eureka 注册中心（端口 8002 和 8003）。
- **springCloud-gateway-9527**：API 网关模块（端口 9527）。
- **springCloud-provider-8001/8005**：服务提供者模块（端口 8001 和 8005）。
- **springCloud-provider-hystrix-8004**：集成 Hystrix 的服务提供者模块（端口 8004）。
