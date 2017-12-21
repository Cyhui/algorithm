package nowcoder.ch06_binarySearch;

/**对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 测试样例：
 [1,2,3,3,4],5,3
 返回：2
 * Created by Cyhui on 2017/12/21 0021.
 */
public class Problem_6_3_LeftMostAppearance {
    public static int findPos(int[] arr, int n, int num) {
        // write code here
        int ans = -1;
        if (arr == null || n == 0){
            return -1;
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2 ;
            if (arr[mid] < num) {
                left = mid + 1;
            }else if (arr[mid] > num){
                right = mid - 1;
            }else{
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,3,4};
        int[] arr1 = {67,447,594};
        int ans = findPos(arr,5,3);
        int ans1 = findPos(arr1,3,67);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
