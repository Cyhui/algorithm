package 剑指offer.ch21_30;

import java.util.ArrayList;

/**
 * 面试题 25: 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test25 {

    /** 存放路径 */
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        // 找到路径.
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 返回到根节点
        list.remove(list.size() - 1);
        return listAll;
    }


}
