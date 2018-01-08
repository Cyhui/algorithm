package 剑指offer.ch21_30;

/**
 * 面试题27 ：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test27 {
    TreeNode list = null;

    /**
     * 直接使用中序遍历，需要返回头结点 所以遍历顺序：右中左
     * @param root
     * @return
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null){
            return root;
        }
        Convert(root.right);
        if (list == null){
            list = root;
        }else{
            //建立联系
            list = root.right;
            root.right = list;
            list = root;
        }
        Convert(root.left);
        return list;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(14);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(8);
        TreeNode right11 = new TreeNode(12);
        TreeNode right12 = new TreeNode(16);

        root.left = left1;
        root.right = right1;

        left1.left = left11;
        left1.right = left12;

        right1.left = right11;
        right1.right = right12;

        Test27 test27 = new Test27();
        test27.Convert(root);
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
