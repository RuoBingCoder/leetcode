package loop;

/**
 * @author : 石建雷
 * @date :2019/7/22
 */

public class YueSeFuLoop {
    public int loop(int n, int m) {
        if (n == 1) {
            return n;
        }
        return (loop(n - 1, m) + m - 1) % n + 1;
    }

    public static void main(String[] args) {
        YueSeFuLoop yueSeFuLoop = new YueSeFuLoop();
        System.out.println(yueSeFuLoop.loop(6, 4));
    }
}
