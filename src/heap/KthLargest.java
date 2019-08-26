package heap;

import java.util.PriorityQueue;

/**
 * @author : 石建雷
 * @date :2019/8/21
 * java自带优先队列
 */

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        minHeap = new PriorityQueue<Integer>(k);

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {

        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();

    }


    public static void main(String[] args) {
        System.out.println(22369621 & 16);

    }
}
