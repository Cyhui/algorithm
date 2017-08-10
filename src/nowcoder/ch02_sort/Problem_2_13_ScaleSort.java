package nowcoder.ch02_sort;

import java.util.PriorityQueue;

/**
 * Created by Cyhui on 2017/8/8 0008.
 * *********小范围排序练习题****************
 * <p>
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 * <p>
 * 使用优先队列进行小根堆的创建
 * PriorityQueue
 */


public class Problem_2_13_ScaleSort {
    public int[] sortElement(int[] arr, int n, int k) {
        if (arr == null || arr.length == 0 || n < k) {
            return null;
        }
        // 建立小根堆 a[0]...[k-1]
        int[] heap = getKHeap(arr, k);
        for (int i = k; i < arr.length; i++) {
            arr[i - k] = heap[0];
            heap[0] = arr[i];
            heapify(heap, 0, k);
        }
        for (int i = n - k; i < arr.length; i++) {
            arr[i] = heap[0];
            swap(heap, 0, k - 1);
            heapify(heap, 0, --k);
        }
        return arr;
    }

    public int[] getKHeap(int[] arr, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(heap, arr[i], i);
        }
        return heap;
    }

    public void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    // 小顶堆
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (arr[left] < arr[index]) {
                smallest = left;
            }
            if (right < heapSize && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(arr, smallest, index);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public int[] sortElement1(int[] A, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (int i = 0; i < k; i++) {
            pq.add(A[i]);
        }
        for (int i = k; i < n; i++) {
            A[idx++] = pq.peek();
            pq.poll();
            pq.add(A[i]);
        }
        while (!pq.isEmpty()) {
            A[idx++] = pq.peek();
            pq.poll();
        }
        return A;
    }

    public static void main(String[] args) {
        Problem_2_13_ScaleSort sort = new Problem_2_13_ScaleSort();
        int[] arr = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        int[] arr1 = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        sort.sortElement(arr, arr.length, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sort.sortElement1(arr1, arr1.length, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
