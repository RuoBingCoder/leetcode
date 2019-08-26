package leetcode.bitopertion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/8/24
 */

public class Watch {

    public List<String> readBinaryWatch(int num) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return list;
    }

    public int countBit2(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        final Watch watch = new Watch();
//        System.out.println(watch.readBinaryWatch(0).toString());
        System.out.println(8 - ((8 >>> 1) & 0x55555555));

        System.out.println(watch.countBit2(9));
//        1001  1000
    }
}
