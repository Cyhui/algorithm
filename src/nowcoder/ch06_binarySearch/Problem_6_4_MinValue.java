package nowcoder.ch06_binarySearch;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 给定数组arr及它的大小n，请返回最小值。
 测试样例：
 [4,1,2,3,3],5
 返回：1
 * Created by Cyhui on 2017/12/21 0021.
 */
public class Problem_6_4_MinValue {
    public static int getMin(int[] arr, int n) {
        // write code here
        int left = 0;
        int right = n - 1;
        int mid = 0;
        // 比较L与H值的大小  例4,1,2,3,3
        while(arr[left] >= arr[right]){
            //只有两个元素
            if (right - left == 1){
                return arr[right];
            }
            mid = left + (right - left) / 2;
            if (arr[left] > arr[mid]){
                right = mid;
            }else if (arr[mid] > arr[right]){
                left = mid;
            }
        }
        return arr[mid];
    }

}
