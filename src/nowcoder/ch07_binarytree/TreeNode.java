package nowcoder.ch07_binarytree;

/**
 * Created by Cyhui on 2017/8/10 0010.
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(132);
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(375);
        TreeNode node3 = new TreeNode(625);
        TreeNode node4 = new TreeNode(225);
        TreeNode node5 = new TreeNode(416);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        System.out.println("递归遍历");
        Problem_7_2_TreeToSequence tree = new Problem_7_2_TreeToSequence();
        int[][] arr = tree.convert(root);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("非递归遍历：");
        Problem_7_3_TreeToSequence tree1 = new Problem_7_3_TreeToSequence();
        int[][] res = tree.convert(root);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("树的先序序列化：");
        Problem_7_6_TreeToString tree2 = new Problem_7_6_TreeToString();
        String t = tree2.toStringPre(root);
        System.out.println(t);
        System.out.println("树的中序序列化：");
        String t1 = tree2.toStringIn(root);
        System.out.println(t1);
        System.out.println("树的后序序列化：");
        String t2 = tree2.toStringPost(root);
        System.out.println(t2);
    }
}
/*
 * 测试用例:
 {132,11,375,625,225,416}
   对应输出应该为:
 [[132,11,625,225,375,416],
 [625,11,225,132,416,375],
 [625,225,11,416,375,132]]
 */

