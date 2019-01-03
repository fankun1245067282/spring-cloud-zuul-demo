#### 增加@EnableZuulProxy

#### 配置路由规则

基本模式：zuul.routes.${application-name}:/${app-url-prefix}/**



#### 整合ribbon

`Content-Type:application/json;charset=UTF-8`这是客户端的请求类型，要与服务端的接受类型匹配

accept：text/html;这是客户端的接受类型，服务端要返回客户端的接受的类型数据

##streamkafka

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-stream-binder-kafka</artifactId>
</dependency>
```

Alternatively, you can also use the Spring Cloud Stream Kafka Starter.

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-stream-kafka</artifactId>
</dependency>
```

官方说这两种都可以的

```
    compile('org.springframework.cloud:spring-cloud-stream')
    compile('org.springframework.cloud:spring-cloud-stream-binder-kafka')
    compile('org.springframework.kafka:spring-kafka')自动包括在内
```

#### kafka主要用途

消息中间件
流式计算处理
日志



### spring kafka

#### 设计模式

Spring 社区对data(spring-data)数据操作，有一个基本的模式，Template模式

JDBC:JdbcTemplate

Redis:RedisTemplate

Kafka:KafkaTemplate

Jms:JmsTemplate

Rest:RestTemplate

XxxTemplate 一定实现 XxxOperations

KafkaTemplate 实现 KafkaOperations



####Maven依赖

```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```



### Spring Boot Kafka

自动装备器：KafkaAutoConfiguration

其中 kafkaTemplate会自动装配



```java
@Bean
@ConditionalOnMissingBean({KafkaTemplate.class})
public KafkaTemplate<?, ?> kafkaTemplate(ProducerFactory<Object, Object> kafkaProducerFactory, ProducerListener<Object, Object> kafkaProducerListener) {
    KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate(kafkaProducerFactory);
    kafkaTemplate.setProducerListener(kafkaProducerListener);
    kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
    return kafkaTemplate;
}
```
###问题

1、kafka使用场景？

​	高性能的Stream处理

2、kafka如何使用后如何删除？



3、怎么没有看到Broker设置？

​	Broker不需要设置，它是单独启动

4、consumer为什么分组？

​	consumer需要定义不同逻辑分组，（是不是几个可以同时消费一个主题，否则，重启一个只能重新消费）

## Spring Cloud Stream (下)

RabbitMQ： AMQP,JMS 规范

Kafka：相对松散的消息队列协议

企业整合模式 Integration

### Spring Cloud Stream

基本概念



#### Source :   来源  近义词：Producer,Publisher

#### Sink ： 接收器  近义词：Consumer,Subsciber

#### Processor:     对于上流而言是Sink，对于下流而言是Source

Reactive Streams:

​	Publisher

​	Subscriber

​	Processor

消息大致分为两个部分：

消息头：（Headers)

消息体：（Body/Payload）

#### 定义标准的消息发送源头

```

```



#### 问答

@EnableBinding 有什么用

答：@EnableBinding 将`Source`、`Sink`以及`Processor`提升成相应的代理类





## Spring Cloud Sleuth

整合：

引入maven



