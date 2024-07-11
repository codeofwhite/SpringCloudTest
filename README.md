# 个人博客系统的后端

1. 后端采用SpringCloud开发，主要文件在springCloud-provider-8005和springCloud-provider-hystrix-8004。
2. 由于这次实践还有其他项目的问题，时间比较紧张，所以对于微服务只是先做一个大体框架的整理。这里的微服务架构只是实现了最简单的部分

- `/SpringCloudTest`：包含所有后端源代码文件。
    - `/springCloud-api`：一些pojo
    - `/springCloud-client-83`：客户端，由于用了gateway，然后规模不是很大，所以没用
    - `/springCloud-client-feign-84`：组件内通信，由于组件较少，没用到
    - `/springCloud-eureka-8002`：注册中心8002
    - `/springCloud-eureka-8003`：注册中心8003
    - `/springCloud-gateway-9527`：网关，负责过滤路由和安全检查的工作
    - `/springCloud-provider-8001`：集成SpringSecurity，还没使用，后期会用到
    - `/springCloud-provider-8005`：负责提供博客和评论的服务
    - `/springCloud-provider-8006`：负责提供弹幕服务
    - `/springCloud-provider-8007-Question`：负责提供“送给作者的话”和提问服务
    - `/springCloud-provider-hystrix-8004`：负责提供登录服务，加了个服务降级熔断器