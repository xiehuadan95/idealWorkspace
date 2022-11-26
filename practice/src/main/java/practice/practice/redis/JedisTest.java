package practice.practice.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author xiehu
 * @Date 2022/6/28 15:25
 * @Version 1.0
 * @Description 用Jedis连接Redis
 */
public class JedisTest {
    //连接redis
    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
    }
}
