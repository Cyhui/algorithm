package 剑指offer.ch21_30;

import java.util.Stack;

/**
 * 面试题21: 包含min函数的栈
 *
 * Created by Cyhui on 2017/12/31 0031.
 */
public class Test21 {
    private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();
    public void push(int node) {
        if(this.stackMin.isEmpty()){
            this.stackMin.push(node);
        }else if(node <= this.stackMin.peek()){
            this.stackMin.push(node);
        }
        this.stackData.push(node);
    }

    public void pop() {
        if(this.stackData.isEmpty()){
            throw new RuntimeException("stackData is empty");
        }
        int value = this.stackData.pop();
        if(value == this.min()){
            this.stackMin.pop();
        }
    }

    public int top() {
        if(this.stackData.isEmpty()){
            throw new RuntimeException("stackData is empty");
        }
        int value = this.stackData.pop();
        return value;
    }

    public int min() {
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("stackMin is empty");
        }
        return this.stackMin.peek();
    }
}
