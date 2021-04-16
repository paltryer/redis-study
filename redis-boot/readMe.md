### redis的自动配置类：RedisAutoConfiguration
>其中注解信息 @EnableConfigurationProperties(RedisProperties.class)
    说明对于redis的配置信息类为 RedisProperties

RedisAutoConfiguration 中有两个方法：

    1.redisTemplate
   > @ConditionalOnMissingBean(name = "redisTemplate")  当容器中没有RedisTemplate对象时，此方法生效
    默认的RedisTemplate  没有过多设置，redis 对象 都是需要序列化的
    RedisTemplate<Object, Object> 两个泛型都是Object，使用时可以强转为<String,Object>
   
    2.stringRedisTemplate
   
   > 由于String类型为经常使用的数据类型，所以单独提出一个bean

### 1.导入依赖
```ftl>        
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-data-redis</artifactId>
               </dependency>
```
### 2.添加配置
```
   # 配置 redis
   spring.redis.host=127.0.0.1
   spring.redis.port=6379
```