package 剑指offer.ch1_10;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 *  用两个栈来实现一个队列，完成队列的Push和Pop操作。
 *  队列中的元素为int类型。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test7 {
    Stack<Integer> sPush = new Stack<Integer>();
    Stack<Integer> sPop = new Stack<Integer>();

    public void push(int node) {
       sPush.push(node);
    }

    public int pop() {
        if (sPush.empty() && sPop.empty()){
            throw new RuntimeException("queue is empty");
        }else if (sPop.empty()){
            while (!sPush.empty()){
                sPop.push(sPush.pop());
            }
        }
        return sPop.pop();
    }
}
