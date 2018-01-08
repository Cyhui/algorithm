package 剑指offer.ch31_40;

import static 剑指offer.ch31_40.Test39.TreeDepth;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树
 * Created by Cyhui on 2018/1/8 0008.
 */
public class Test39_1 {

    /**
     * 需要重复遍历结点多次。
     * 思路：在遍历树的每个结点的时候，计算每个节点左右子树的深度。
     * 如果每个结点左右子树的深度相差不超过1.那么它就是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        int ldepth = TreeDepth(root);
        int rdepth = TreeDepth(root);
        int different = ldepth - rdepth;
        if (different <= 1 && different >= -1){
            return true;
        }
        return false;
    }

    /**
     * 使用后序遍历 在遍历结点之间已经遍历了它的左右子树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        int[] depth = new int[1];
        return isBalanced(root,depth);
    }

    private boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left,left) && isBalanced(root.right,right)){
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1){
                depth[0] = 1 + Math.max(left[0],right[0]);
                return true;
            }
        }
        return false;
    }

    /****************************************************/
    public boolean IsBalanced_Solution3(TreeNode root) {
        return (TreeDepth1(root) >= 0);
    }
    public static int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldepth = TreeDepth1(root.left);
        int rdepth = TreeDepth1(root.right);
        return (ldepth >= 0 && rdepth >= 0 && Math.abs(ldepth - rdepth) <= 1) ? 1+Math.max(ldepth,rdepth) : -1 ;
    }
}
