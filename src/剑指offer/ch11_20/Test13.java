package 剑指offer.ch11_20;

/**
 * 面试题13：在O(1)时间删除链表节点
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test13 {

    /**
     * 平均时间复杂度 [(n-1)*O(1)+O(n)]/n
     * @param head
     * @param node
     */
    public void deleteNode(ListNode head,ListNode node){
        if (head == null || node == null){
            return;
        }
        //要删除的结点不是尾结点
        if (node.next != null){
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }else if(head == node){
            // 链表只有一个结点，删除头结点
            head = null;
        }else{
            // 链表中有多个结点，删除尾结点
            ListNode pNode = head;
            while(pNode.next != node){
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }
}
