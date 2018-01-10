package 剑指offer.ch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test63 {
    /*
    思路：
    为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
    1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
    2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。

    数为：6,1,3,0,9,8,7,2
    较小的一半：0,1,2,3    3是这一半的数组成的大顶堆的堆顶
    较大的一半：6,7,8,9    6是这一半的数组成的小顶堆的堆顶
     */

    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
        count++;
        if ((count & 1 )== 0){
            // 偶数位时
            if (!maxHeap.isEmpty() && num < maxHeap.peek()){
                // 1.新元素先加入大顶堆中，由大顶堆筛出最大的元素
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            //  2.将筛出后的最大元素放入小顶堆
            minHeap.offer(num);
        }else{
            // 奇数位时
            if (!minHeap.isEmpty() && num > minHeap.peek()){
                // 1.新元素先加入小顶堆中，由小顶堆筛出最小的元素
                minHeap.offer(num);
                num = minHeap.poll();
            }
            //  2.将筛出后的最小元素放入大顶堆
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count==0) {
            throw new RuntimeException("no available number!");
        }
        double result = 0;
        // 总数为奇数时，大顶堆的堆顶就是中位数
        if ((count & 1) == 1){
            result = maxHeap.peek();
        }else{
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }
}
