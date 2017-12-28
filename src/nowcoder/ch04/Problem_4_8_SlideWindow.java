package nowcoder.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 * 测试样例：[4,3,5,4,3,3,6,7],8,3
 * 返回：[5,5,5,4,6,7]
 * Created by Cyhui on 2017/12/28 0028.
 */
public class Problem_4_8_SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        // write code here
        if (arr == null || n < w ) {
            return null;
        }
        if (w == 0){
            return new int[0];
        }
        // 双端队列存放最大值的下标   队头是当前窗口最大值
        LinkedList<Integer> deque = new LinkedList<>();
        // 存放局部最大值的数据
        int[] max = new int[n - w + 1];

        /*
            [4,3,5,4,3,3,6,7],8,3
           1. i = 0  0入队   0< 0-3+1
           2. i = 1  1入队   0< 1-3+1
           3. i = 2  arr[2]>arr[1] arr[2] > arr[0] ,0 1 出队，2入队 ，2 < 2 - 2  , 2 >= 2, max[0] = arr[2]
           4. i = 3  arr[3]<arr[2] , 3 入队,  2< 3-2, 3>=2,max[1] = arr[2]    2,3
           5. i = 4  arr[4]<arr[2] , 4 入队， 2< 4-2  4>=2, max[2] =arr[2]    2,3,4
           6. i = 5  arr[5]<arr[2] , 5 入队， 2< 5-2,2出队  5>=2 , max[3] = arr[3]   3,4
           7. i = 6  arr[6]>arr[4] arr[6]>arr[3],  4,3出队, 6入队，  6<6-2,   6>=2  max[4] = arr[6]   6
           8. i = 7  arr[7]>arr[6] 6出队, 7入队,  7<7-2  7>=2 max[5] = arr[7]    7
         */
        for (int i = 0; i < n; i++) {
            // 如果双端队列不为空,且当前最大值小于arr[i]
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.getFirst() < i - w + 1){
                deque.removeFirst();
            }
            if (i >= w - 1){
                max[i - w + 1] = arr[deque.getFirst()];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Problem_4_8_SlideWindow slideWindow = new Problem_4_8_SlideWindow();
        int[] arr = {2,3,4,2,6,2,5,1};
        int[] max = slideWindow.slide(arr,arr.length,0);
        for (int n: max) {
            System.out.print(n + " ");
        }
    }
}
