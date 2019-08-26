package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : 石建雷
 * @date :2019/8/11
 */

public class NextMaxElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) {
            result[i] = hasMap.getOrDefault(nums1[i], -1);
        }

        return result;
        }



    public static void main(String[] args) {
        NextMaxElement maxElement = new NextMaxElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(maxElement.nextGreaterElement(nums1, nums2).toString());
    }
}
