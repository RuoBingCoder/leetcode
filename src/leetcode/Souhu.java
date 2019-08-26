package leetcode;

/**
 * @author : 石建雷
 * @date :2019/6/1
 * 2  1   2   3  1
 * 20 12 23 32 13
 * 1  2  1  2   3  1   2  3   4  1
 * 20 32 12 32 45 11 21 31 41 33
 * 20
 */

public class Souhu {

    public int num(String[] strings) {
        String[] array = strings;
        int[] money = new int[strings.length];
        int sumMoney = 0;
        int count = 0;
        if (strings.length == 0) {
            return 0;
        }
        if (strings.length == 1) {
            return 1;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (Integer.parseInt(array[i + 1]) > Integer.parseInt(array[i])) {
//                当i+1>i时 给money[0]附初始值
                if (money[0] == 0 && i < 2) {
                    money[0] = 1;
                }
//                计算开始到某个位置不相等时赋值例如：20 ,20, 20,31...
                if (count > 0) {
                    for (int j = 0; j <= count; j++) {
                        if (money[count + 1] == 1) {
                            money[j] = 2;
                        } else {
                            money[j] = 1;
                        }
                    }
                    count = 0;
                }
                money[i + 1] = money[i] + 1;
//                1 1 1 2 3
            } else if (Integer.parseInt(array[i + 1]) == Integer.parseInt(array[i])) {
                if (Integer.parseInt(array[0]) == Integer.parseInt(array[1])) {
                    count++;
                    if (count == strings.length - 1) {
                        sumMoney = count + 1;
                        break;
                    }
                    continue;
                } else {
                    money[i + 1] = money[i];
                }

            } else {
//                当i+1<i时，给money[0]和[1]附初始值
                if (i <= 1) {
                    if (Integer.parseInt(array[0]) > Integer.parseInt(array[1])) {
                        money[i + 1] = 1;
                        money[i] = money[i + 1] + 1;
                    }
                }
                money[i + 1] = 1;
            }
        }
        for (int i : money) {
            sumMoney += i;
        }
        return sumMoney;
    }

    public static void main(String[] args) {
        Souhu souhu = new Souhu();
//        String[] str = {"20", "20", "20", "12", "32", "45", "11", "21", "31", "41", "33"};
//        String[] str = {"20", "12", "20", "20", "20", "32", "12", "43"};
//        String[] str = {"20", "20", "20", "20", "20"};
        String[] str = {"20", "20", "20", "20", "20","1"};

        long startTime = System.currentTimeMillis();
        System.out.println(souhu.num(str));
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("时间为：" + time);


    }
}
