package leetcode.lianbiao;

/**
 * @author : 石建雷
 * @date :2019/7/19
 */

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        ListNode second= head;
        while (true) {
            if ((second.next) != null && (second.next.next) != null) {
                second = second.next.next;
            } else {
                return false;
            }
            first = first.next;
            if (first == second) {
                return true;
            }
        }
    }
}
