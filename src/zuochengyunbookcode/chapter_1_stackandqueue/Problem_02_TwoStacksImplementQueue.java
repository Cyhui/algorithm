package zuochengyunbookcode.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * Created by Cyhui on 2017/8/3 0003.
 */
public class Problem_02_TwoStacksImplementQueue {

    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
        }

        public int poll(){
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
