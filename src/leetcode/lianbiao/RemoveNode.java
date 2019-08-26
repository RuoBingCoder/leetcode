package leetcode.lianbiao;

/**
 * @author : 石建雷
 * @date :2019/7/31
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {
        ListNode vm = new ListNode(val - 1);
        vm.next = head;
        ListNode temp = vm;

        if (head == null) {
            return head;
        }
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return vm.next;
    }

    public static void main(String[] args) {
        RemoveNode removeNode = new RemoveNode();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(6);
        removeNode.removeElements(l1, 6);
    }
}
