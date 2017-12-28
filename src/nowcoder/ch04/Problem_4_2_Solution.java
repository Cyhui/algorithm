package nowcoder.ch04;

import java.util.Stack;

/**可查询最值的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by @author Cyhui on 2017/12/28 0028.
 */
public class Problem_4_2_Solution {

    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    Stack<Integer> stackMax = new Stack<>();

    /**
     * 插入数据
     * @param node int类型
     */
    public void push(int node){
        if (stackMin.empty()){
            stackMin.push(node);
        }else if (node <= stackMin.peek()){
            stackMin.push(node);
        }
        if (stackMax.empty()){
            stackMax.push(node);
        }else if (node >= stackMax.peek()){
            stackMax.push(node);
        }
        stackData.push(node);
    }

    /**
     * 弹出并返回栈顶元素
     * @return
     */
    public int pop(){
        if (stackData.empty()){
            throw new RuntimeException("stack is empty!");
        }else {
            int value = stackData.pop();
            if (value == stackMin.peek()) {
                stackMin.pop();
            }
            if (value == stackMax.peek()) {
                stackMax.pop();
            }
            return value;
        }
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public int peek(){
        if (stackData.empty()){
            throw new RuntimeException("stack is empty!");
        }else {
            return stackData.peek();
        }
    }

    /**
     * 获得最小值
     * @return
     */
    public int getMin(){
        if (stackData.empty()){
            throw new RuntimeException("stack is empty!");
        }else {
            return stackMin.peek();
        }
    }

    /**
     * 获得最大值
     * @return
     */
    public int getMax(){
        if (stackData.empty()){
            throw new RuntimeException("stack is empty!");
        }else {
            return stackMax.peek();
        }
    }

    public static void main(String[] args){
        Problem_4_2_Solution solution = new Problem_4_2_Solution();
        solution.push(4);
        solution.push(2);
        solution.push(1);
        solution.push(3);
        solution.push(7);
        System.out.println(solution.getMax());
        System.out.println(solution.getMin());
    }
}
