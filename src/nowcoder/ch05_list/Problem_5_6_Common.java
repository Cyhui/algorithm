package nowcoder.ch05_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * <p>
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * <p>
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 * Created by Cyhui on 2017/9/18 0018.
 */
public class Problem_5_6_Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        if (headA == null || headB == null) {
            return null;
        }
        List<Integer> a = new ArrayList<>();
        while (headA != null && headB != null){
            if (headA.val < headB.val){
                headA = headA.next;
            }else if (headA.val > headB.val){
                headB = headB.next;
            }else {
                a.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            }
        }
        int[] aa = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            aa[i] = a.get(i);
        }
        return aa;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
