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