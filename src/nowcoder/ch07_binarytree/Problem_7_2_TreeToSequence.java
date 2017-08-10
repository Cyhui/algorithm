package nowcoder.ch07_binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后序遍历(二维数组的形式)。
 * <p>
 * Created by Cyhui on 2017/8/10 0010.
 */
public class Problem_7_2_TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        preOrderRecur(pre, root);
        inOrderRecur(in, root);
        postOrderRecur(post, root);

        res[0] = listToArray(pre);
        res[1] = listToArray(in);
        res[2] = listToArray(post);
        return res;
    }

    private int[] listToArray(ArrayList<Integer> list) {
        if (list == null) {
            return null;
        }
        int len = list.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // 递归先序遍历
    public void preOrderRecur(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrderRecur(list, root.left);
        preOrderRecur(list, root.right);
    }

    // 递归中序遍历
    public void inOrderRecur(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(list, root.left);
        list.add(root.val);
        inOrderRecur(list, root.right);
    }

    // 递归后序遍历
    public void postOrderRecur(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecur(list, root.left);
        postOrderRecur(list, root.right);
        list.add(root.val);
    }

}
