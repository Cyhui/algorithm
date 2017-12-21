package nowcoder.ch06_binarySearch;

/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，
 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 * Created by Cyhui on 2017/12/21 0021.
 */
public class Problem_6_2_Solution {
    public static int getLessIndex(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        } else if (arr.length == 1) {
            return 0;
        } else if (arr.length > 1 && arr[0] < arr[1]) {
            return 0;
        } else if (arr.length > 1 && arr[arr.length - 2] > arr[arr.length - 1]){
            return arr.length - 1;
        }
        int ans = -1;
        //arr[0] arr[1] arr[n-1] arr[n-2]已经判断过 从1-n-2判断
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {3,2,9,2,1,4,0,10,9,0,8,3,5,6,7,1,9,2,4,0,7};
        int x = getLessIndex(arr);
        System.out.println(x);
    }
}
