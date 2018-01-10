package 剑指offer.ch;

/**
 * 题目：链表中环的入口结点
 *
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * 问题延伸：
 *  （1）环的长度
 *    当快慢指针第一次相遇的时候，把该节点保存下来，让慢指针接着走，当再次到达刚才相遇的节点时所走过的步数就是环的长度。
 *  （2）整个链表的长度
 *    除环以外的长度再加上环的长度，就是整个链表的长度
 *  （3）两个无环链表第一次相交的公共节点
 *   先分别求出两个链表的长度，让长的链表先走两个链表长度差的步数，再让两个链表一起走，当走到节点值相同的那个节点时，就是相交的第一个公共节点。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test55 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        // 慢指针
        ListNode p1 = pHead;
        // 快指针
        ListNode p2 = pHead;
        // 相遇后让快指针从头开始走，每次走一半，再次相遇的节点就是环的入口
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
