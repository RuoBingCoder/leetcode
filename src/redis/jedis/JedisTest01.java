package redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author : 石建雷
 * @date :2019/5/6
 */

public class JedisTest01 {

    public boolean jedis() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("k5", "今天天气很好");
        int blance;  //总额
        int debt;  //欠额
        //实刷额度
        int amtToSubtract = 10;
//        开启监控
        jedis.watch("blance");
//        执行事务回滚
        Thread.sleep(7000);
        blance = Integer.parseInt(jedis.get("blance"));
        if (blance < amtToSubtract) {
            jedis.unwatch();
            System.out.println("Modify");
            return false;
        } else {
            System.out.println("=======================Transaction=====");
            Transaction transaction = jedis.multi();
            transaction.decrBy("blance", amtToSubtract);
            transaction.incrBy("debt", amtToSubtract);
            transaction.exec();
            blance = Integer.parseInt(jedis.get("blance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println(blance);
            System.out.println(debt);
            return true;


        }


    }

    public static void main(String[] args) throws InterruptedException {
        JedisTest01 jedisTest01 = new JedisTest01();
        jedisTest01.jedis();
    }
}
