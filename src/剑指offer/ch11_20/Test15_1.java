package 剑指offer.ch11_20;

/**
 * 相关题目：
 * 求链表的中间节点。
 * 如果链表中的节点总数为奇数，返回中间节点。
 * 如果链表节点总数1是偶数，返回中间两个结点的任意一个。
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test15_1 {
    public ListNode chkLoop(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
