package nowcoder.ch02_sort.sort;

/**
 * 测试Sort
 *
 * Created by Cyhui on 2017/8/8 0008.
 */

public class TestSort {

    public static void main(String[] args) {
        int[] arr = { -150, -230, -2, 7, 4, 3, 1 };

        System.out.println("冒泡排序：");
        BubbleSort.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] arr1 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("选择排序：");
        SelectionSort.selectionSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        int[] arr2 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("插入排序：");
        InsertionSort.insertionSort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int[] arr3 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("归并排序：");
        MergeSort.mergeSort(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        int[] arr4 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("快速排序：");
        QuickSort.quickSort(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();

        int[] arr5 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("堆排序：");
        HeapSort.heapSort(arr5);
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();

        int[] arr6 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("希尔排序：");
        ShellSort.shellSort(arr6);
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
        System.out.println();

        int[] arr7 = { -150, -230, -2, 7, 4, 3, 1 };
        System.out.println("计数排序：");
        CountingSort.countingSort(arr7);
        ;
        for (int i = 0; i < arr7.length; i++) {
            System.out.print(arr7[i] + " ");
        }
        System.out.println();

        int[] arr8 = { -1500, -230, -2, 7, 4, 3, 1 };
        System.out.println("基数排序：");
        RadixSort.radixSort(arr8);
        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i] + " ");
        }
        System.out.println();
    }
}