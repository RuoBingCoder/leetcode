package redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author : 石建雷
 * @date :2019/5/8
 * jedis连接池
 */

public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil() {
    }

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    /*最大连接空闲数*/
                    poolConfig.setMaxIdle(32);
                    /*最大等待时间*/
                    poolConfig.setMaxWaitMillis(1000);
                    /*/ 最大连接数*/
                    poolConfig.setMaxTotal(1000);
                    /*检查连接可用性, 确保获取的redis实例可用*/
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
                }
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedisPool.close();
        }
    }
}
