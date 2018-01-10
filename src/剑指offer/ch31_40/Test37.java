package 剑指offer.ch31_40;

/**
 * 面试题37：两个链表的第一个公共节点
 * Created by Cyhui on 2018/1/9 0009.
 */
public class Test37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while(node1 != node2){
            node1 = (node1 == null) ? pHead2 : node1.next;
            node2 = (node2 == null) ? pHead1 : node2.next;
        }
        return node1;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
