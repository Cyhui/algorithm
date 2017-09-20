package nowcoder.ch02_sort;

/**
 * 三色排序问题
 * <p>
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * <p>
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * <p>
 * 测试样例：
 * [0,1,1,0,2,2],6
 * 返回：[0,0,1,1,2,2]
 * Created by Cyhui on 2017/9/20 0020.
 */
public class Problem_2_17_ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        if (A == null|| n < 2){
            return null;
        }
        int left = -1;
        int right = A.length;
        int index = 0;
        while(index < right){
            if(A[index] == 2){
                swap(A,index,--right);
            }else if (A[index] == 0){
                swap(A,++left,index++);
            }else{
                index++;
            }
        }
        return A;
    }
    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
