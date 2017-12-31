package 剑指offer.ch11_20;

/**
 * 面试题17: 合并两个排序的链表
 * 题目描述:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test17 {

    // 测试
    public static void main(String[] args) {
        // 功能测试：输入的两个链表有多个结点，结点的值互不相同或者存在相等的多个结点
        // 特殊输入测试：两个链表中的一个或者两个头结点为null指针、两个链表中只有一个结点
        Test17 test = new Test17();
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(8);
        head1.next = head2;
        head2.next = head3;
        head3.next = null;
        ListNode sec1 = new ListNode(1);
        ListNode sec2 = new ListNode(3);
        ListNode sec3 = new ListNode(9);
        sec1.next = sec2;
        sec2.next = sec3;
        sec3.next = null;
        test.Merge(head1,sec1);
        test.Merge1(head1,sec1);
    }

    /**
     * 非递归解法
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode Merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        // 新链表的头节点
        ListNode head = null;
        //
        ListNode current = null;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                if (head == null) {
                    head = current = head1;
                } else {
                    current.next = head1;
                    current = current.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = current = head2;
                } else {
                    current.next = head2;
                    current = current.next;
                }
                head2 = head2.next;
            }
        }
        current.next = head1 == null ? head2 : head1;
        return head;
    }

    /**
     * 递归解法
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode Merge1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        if (head1.val <= head2.val) {
            //链表1的头节点的值小于链表2的头节点的值，链表1的头节点是合并后链表的头节点
            head1.next = Merge1(head1.next, head2);
            return head1;
        } else {
            //链表1的头节点的值大于链表2的头节点的值，链表2的头节点是合并后链表的头节点
            head2.next = Merge1(head1, head2.next);
            return head2;
        }
    }
}
