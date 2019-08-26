package leetcode.lianbiao;

/**
 * @author : 石建雷
 * @date :2019/6/6
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 1->2->3->4   2->3->4
 */

public class MergeLianbiao {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {

                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;


            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return l3.next;
    }

    public void list(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static void main(String[] args) {
        MergeLianbiao lianbiao = new MergeLianbiao();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(4);

        ListNode l3 = lianbiao.mergeTwoLists(l1, l2);
        lianbiao.list(l3);


    }
}
