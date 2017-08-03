package zuochengyunbookcode.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * *
 * 有getMin(),getMax()功能的栈
 * <p>
 * pop(),push(),getMin().getMax()时间复杂度为O(1).
 * <p>
 * <p>
 * 第一种方法
 * 压入规则：
 * stackMin栈中不压入比栈顶元素大的数
 * stackMax栈中不压入比栈顶元素小的数
 * 弹出规则：
 * 将stackData栈顶元素设为value。比较当前stackMin的栈顶元素和value那个的值更小
 * 当value等于stackMin的栈顶元素时，stackMin弹出栈顶元素；当value大于stackMin的栈顶元素，
 * stackMin不弹出栈顶元素，返回value。
 * 当value等于stackMax的栈顶元素时，stackMin弹出栈顶元素；当value小于stackMax的栈顶元素，
 * stackMax不弹出栈顶元素，返回value。
 * 第二种方法
 * 压入规则：
 * newNum小于stackMin栈顶元素   stackMin栈中压入newNum
 * 否则stackMin栈顶元素重复压入栈中
 * newNum大于stackMax栈顶元素   stackMax栈中压入newNum
 * 否则stackMax栈顶元素重复压入栈中
 * 弹出规则：
 * 随着stackData弹出而弹出
 *
 * Created by Cyhui on 2017/8/3 0003.
 */
public class Problem_01_GetMinMaxStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        private Stack<Integer> stackMax;

        public MyStack1() {
            stackData = new Stack<>();
            stackMax = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }

            if (this.stackMax.isEmpty()) {
                this.stackMax.push(newNum);
            } else if (newNum >= this.getMax()) {
                this.stackMax.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            if (value == this.getMax()) {
                this.stackMax.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int getMax() {
            if (this.stackMax.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMax.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        private Stack<Integer> stackMax;

        public MyStack2() {
            stackData = new Stack<>();
            stackMax = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getMin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }

            if (this.stackMax.isEmpty()) {
                this.stackMax.push(newNum);
            } else if (newNum > this.getMax()) {
                this.stackMax.push(newNum);
            } else {
                int newMax = this.stackMax.peek();
                this.stackMax.push(newMax);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            this.stackMax.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int getMax() {
            if (this.stackMax.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMax.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        System.out.println(stack2.getMax());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
