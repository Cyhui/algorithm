package 剑指offer.ch11_20;


/**
 * 面试题16: 输入一个链表，反转链表后，输出链表的所有元素。
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test16 {
    public ListNode ReverseList(ListNode head) {
        //链表只有一个节点或者到达链表的尾部
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = ReverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newList;
    }

    public ListNode ReverseList1(ListNode head) {
        // 定义一个结点，用来保存找到的反转链表的表头结点
        // 当前正在遍历的结点p
        ListNode pNode = head;
        // 结点p的前一个结点
        ListNode preNode = null;
        // 结点p的后一个结点
        ListNode reversHeadNode = null;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        } else {
            ListNode next = null;
            while (pNode != null) {
                next = pNode.next;
                if (next == null) {
                    reversHeadNode = pNode;
                }
                pNode.next = preNode;
                preNode = pNode;
                pNode = next;
            }
        }
        return reversHeadNode;
    }
}
