package 剑指offer.ch;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：二叉搜索树的第k个结点
 *
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5
 *       / \
 *      3   7
 *     /\   /\
 *    2 4  6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test62 {

    /****       使用递归中序遍历            ******/
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(pRoot,list);
        if (k > list.size() || k <= 0){
            return null;
        }
        return list.get(k - 1);
    }

    public void inorder(TreeNode pRoot,ArrayList<TreeNode> list){
        if (pRoot == null){
            return;
        }
        inorder(pRoot.left, list);
        list.add(pRoot);
        inorder(pRoot.right,list);
    }

    /****       使用非递归中序遍历            ******/
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        while(pRoot != null || !stack.isEmpty()){
            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                pRoot = stack.pop();
                list.add(pRoot);
                pRoot = pRoot.right;
            }
        }
        if (k > list.size() || k <= 0){
            return null;
        }
        return list.get(k-1);
    }
}
