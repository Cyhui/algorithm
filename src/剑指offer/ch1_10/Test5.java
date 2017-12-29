package 剑指offer.ch1_10;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题5: 输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test5 {
    ArrayList<Integer> llist = new ArrayList<>();

    /**
     * 显示调用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        // 存放链表的值
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 使用递归  可能出现栈溢出
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead2(listNode.next);
            }
            llist.add(listNode.val);
        }
        return llist;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}