package 剑指offer.ch21_30;

import java.util.HashMap;
import java.util.Set;

/**
 * 面试题26：复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test26 {
    /*
        1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
    2、遍历链表，A1->random = A->random->next;
    3、将链表拆分成原链表和复制后的链表
     */

    /**
     * 在不使用额外空间的O(n)
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        RandomListNode pCur = pHead;
        // 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while(pCur != null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        // 复制random  pCur是原来链表的结点 pCur.next是复制pCur的结点
        while(pCur != null){
            if (pCur.random != null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        // 拆分链表
        while(pCur != null){
            pCur.next = pCur.next.next;
            if (cur.next != null){
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }

    /*
       使用哈希表：使用O（n）的额外空间 O(n)的时间
        1.复制原始链表上的结点N创建结点N’，如何将这些创建出来的结点用m_next连接
          将N,N'配对信息放到一个哈希表中。
        2.设置复制链表上每个结点的m_pSibling.如果在原始链表中结点N的m_pSibling指向结点s
          那么在复制链表中，对应的n'应该指向s'.有了哈希表，我们就可以在O(1)时间根据s找到s'.
     */

    /**
     * 第二种方法
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode pNode = pHead;
        RandomListNode q = new RandomListNode(-1);
        while(pNode != null){
            RandomListNode t = new RandomListNode(pNode.label);
            map.put(pNode,t);
            pNode = pNode.next;
            // 将复制的结点连接
            q.next = t;
            q = t;
        }
        pNode = pHead;
        // 为每个结点的random赋值
        while(pNode != null){
            map.get(pNode).random = pNode.random;
            pNode = pNode.next;
        }
        return map.get(pHead);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}