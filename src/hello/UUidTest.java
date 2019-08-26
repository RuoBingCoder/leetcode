package hello;

import java.util.UUID;

/**
 * @author : 石建雷
 * @date :2019/6/3
 */

public class UUidTest {

    public static void main(String[] args) {
        String num = UUID.randomUUID().toString().substring(0, 4);
        int uuid = Integer.parseInt(num);
        System.out.println(uuid);
    }
}
