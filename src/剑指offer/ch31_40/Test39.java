package 剑指offer.ch31_40;

/**
 * 面试题39 ： 二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * Created by Cyhui on 2018/1/8 0008.
 */
public class Test39 {

    /**
     * 使用递归进行树深度的计算
     * 思路：
     * 当只有根节点时，树的深度为1。
     * 如果左子树的深度大于右子树的深度则树的深度为左子树的深度。
     * @param root
     * @return
     */
    public static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldepth = TreeDepth(root.left);
        int rdepth = TreeDepth(root.right);
        return (ldepth > rdepth) ? (ldepth + 1) : (rdepth + 1) ;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l11 = new TreeNode(4);
        TreeNode l12 = new TreeNode(5);
        TreeNode r12 = new TreeNode(6);
        TreeNode l23 = new TreeNode(7);

        root.left = l1;
        root.right = r1;

        l1.left = l11;
        l1.right = l12;

        r1.right = r12;

        l12.left = l23;

        int depth = TreeDepth(root);
        System.out.println(depth);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}