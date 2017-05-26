package cn.jianmai;

import cn.zhouqifun.redis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by zhouqi on 2017/4/22.
 */
public class jedisTest {

    @Test
    public void tetsJedisClientSpring() throws Exception {
        // 创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //获取jedis对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);

        //jedisClient操作redis
        jedisClient.set("zhou", "heihei");
        String str = jedisClient.get("zhou");
        System.out.println(str);
    }
}
