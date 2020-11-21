# SpringCloud 实践项目
- 本项目使用springcloud Finchley版本
- 使用eureka server作为服务注册中心
- 然后分别创建数据微服务、视图微服务
- 使用Feign完成负载均衡
- 使用zipkin进行服务链路追踪
- 增加配置服务器ConfigServer
- 使用rabbitMQ来进行消息广播，客户端可以动态获取配置服务器修改的数据
- 增加断路器Hystrix以及断路器监控HystrixDashboard
- 使用turbine将一个集群里多个实例汇聚在一起，实现断路器聚合监控
- 使用网关zuul解决微服务地址和端口的变化问题
## 微服务：
   - eureka-server: 8761
   - product-data-service: 8001,8002,8003
   - product-view-service-ribbon: 8010
   - product-view-service-feign: 8012, 8013, 8014
   - hystrix-dashboard: 8020
   - turbine: 8021
   - config-server: 8030
   - zuul: 8040
## 第三方
   - zipkin:9411
   - rabbitMQ: 5672
