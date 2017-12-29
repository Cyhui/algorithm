package 剑指offer.ch1_10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列来实现一个栈，完成队列的Push和Pop操作。
 *  队列中的元素为int类型。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test7_1 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node){
        if (queue1.isEmpty()) {
            queue2.offer(node);
        }
        if (queue2.isEmpty()){
            queue1.offer(node);
        }
    }

    public int poll(){
        //需要另一个队列留一个元素
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        if(queue1.isEmpty()){
            while(queue2.size() > 1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()){
            while(queue1.size() > 1){
                queue1.offer(queue2.poll());
            }
            return queue1.poll();
        }
        return -1;
    }
}
