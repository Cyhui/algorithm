package 剑指offer.ch;

import java.util.HashSet;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test56 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 解决头节点重复
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while(p != null && p.next != null){
            if (p.val == p.next.val){
                int val = p.val;
                // 指向不同的节点
                while(p != null && p.val == val){
                    p = p.next;
                }
                last.next = p;
            }else{
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args){
        Test56 test56 = new Test56();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        test56.deleteDuplication(head);
    }
}
