package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/8/4
 */

public class ArrayHasRepeatNum {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayHasRepeatNum arrayHasRepeatNum = new ArrayHasRepeatNum();
        int[] array = {1, 2, 2, 4};
        System.out.println(arrayHasRepeatNum.containsDuplicate(array));
    }
}
