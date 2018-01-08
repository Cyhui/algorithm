package 剑指offer.ch21_30;

import java.util.Arrays;

/**
 * 面试题24: 二叉搜索树的后序遍历序列
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * Created by Cyhui on 2017/12/31 0031.
 */
public class Test24 {
    /**
     * 思路 ：
     * 在后序遍历序列中，最后一个数字是树的根节点的值。
     * 递归解法
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        int len = sequence.length;
        return judge(sequence,0,len - 1);
    }

    private boolean judge(int[] sequence,int start,int end) {
        int root = sequence[end];
        //在二叉搜索树中左子树的结点小于根结点
        int i = 0;
        for (; i < end; i++) {
            if (sequence[i] > root){
                break;
            }
        }
        //在二叉搜索树中右子树的结点大于根结点
        int j = i;
        for (; j < end; j++) {
            if (sequence[i] < root){
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0){
            left = judge(sequence,start,i-1);
        }
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end){
            right = judge(sequence,i,end - i);
        }
        return left&&right;
    }

    /*****       非递归解法           *****/
    public boolean VerifySquenceOfBST1(int [] sequence) {
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        int len = sequence.length;
        int i = 0;
        while(--len != 0){
            while(sequence[i] < sequence[len]){
                i++;
            }
            while(sequence[i] > sequence[len]){
                i++;
            }
            if (i < len){
                return false;
            }
            i = 0;
        }
        return true;

    }
}
