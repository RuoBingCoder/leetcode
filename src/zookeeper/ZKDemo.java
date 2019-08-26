package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class ZKDemo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("node_1:2181,node_2:2181", 20000, watchedEvent -> {
            System.out.println("事件类型为：" + watchedEvent.getType());
            System.out.println("事件发生的路径：" + watchedEvent.getPath());
            System.out.println("通知状态：" + watchedEvent.getState());
        });
//        创建节点
        zooKeeper.create("/zk_key", "这是zk集群".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//        监听节点
        zooKeeper.getData("/zk_key", true, null);
//      修改  默认-1 不做修改
        zooKeeper.setData("/zk_key", "zk简单的例子".getBytes(), -1);
    }
}
