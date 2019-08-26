package leetcode.appearnum;

/**
 * @author : 石建雷
 * @date :2019/7/18
 * 1,1,2,3,3,4,4
 */

public class AppearFirstNumer {
    public int singleNumber(int[] nums) {

        int value = 0;
        for (int i = 0; i <nums.length ; i++) {
           value = value ^ nums[i];

        }

        return value;
    }

    public static void main(String[] args) {
        AppearFirstNumer appearFirstNumer=new AppearFirstNumer();
        int[] array = {2,2,1};
        System.out.println(appearFirstNumer.singleNumber(array));
    }
}
