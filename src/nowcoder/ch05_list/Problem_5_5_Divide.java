package nowcoder.ch05_list;

/**
 * 链表的分化
 * <p>
 * Created by Cyhui on 2017/9/18 0018.
 */
public class Problem_5_5_Divide {
    public ListNode listDivide(ListNode head, int val) {
        ListNode next = null;//下一个节点
        ListNode sH = null;  //小的头
        ListNode sT = null;  //小的尾
        ListNode eH = null;  //相等的头
        ListNode eT = null;  //相等的尾
        ListNode bH = null;  //大的头
        ListNode bT = null;  //大的尾

        while (head != null) {
            if (head.val < val) {
                next = head.next;
                head.next = null;
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == val) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null){
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
