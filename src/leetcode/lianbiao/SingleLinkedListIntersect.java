package leetcode.lianbiao;

/**
 * @author : 石建雷
 * @date :2019/7/20
 */

public class SingleLinkedListIntersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA1 = headA;
        ListNode headB1 = headB;
        ListNode result = null;
        int countA = 0;
        int countB = 0;
        if (headA == null || headB == null) {
            return null;
        }
        while (headA1 != null) {
            countA++;
            headA1 = headA1.next;
        }
        while (headB1 != null) {
            countB++;
            headB1 = headB1.next;
        }
        int temp = Math.max(countA, countB) - Math.min(countA, countB);
        if (countA > countB) {
            for (int i = 0; i < temp; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < temp; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                result = headA;
                return result;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return result;
    }
}
