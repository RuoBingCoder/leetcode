package leetcode.lianbiao;

/**
 * @author : 石建雷
 * @date :2019/8/3
 * 反转链表
 * 1->2->3->4->5
 */

public class ConvertLink {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNode;
        }

        return pre;
    }

    public static void main(String[] args) {
        ConvertLink convertLink = new ConvertLink();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        convertLink.reverseList(l1);
    }
}
