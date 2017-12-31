package 剑指offer.ch11_20;

/**
 * 面试题15: 链表中倒数第k个结点
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test15 {

    /**
     *  通常思路 需要遍历两次，第一次统计链表中的结点个数，第二次找到倒数第k个结点。
     * 只遍历一次 就能找到倒数第k个结点。
     * 1. 第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持。
     * 2. 从第k步开始，第二个指针也开始遍历。
     * 3. 两个指针相差k-1，当第一个指针到达链表的尾节点是，第二个指针正好是倒数第k个结点
     *
     * 还需要考虑三种情况：
     * 1.链表为空 2.链表长度不足K 3.k=0
     * @param head  链表的头节点
     * @param k 倒数第K个结点
     * @return 结点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || 0 == k){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        //第一个指针先走k-1步
        for (int i = 1; i < k; i++) {
            if (first.next != null){
                first = first.next;
            }else{
                return null;
            }
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}