package 剑指offer.ch1_10;

/**
 * 面试题6：重建二叉树
 * <p>
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test6 {

    /**
     * 思路：
     * 1.在前序序列中根节点的位置在第一位，扫描中序序列可以确定根节点的值的位置
     * 2.根据中序遍历的特点，找到左右子数的序列
     * 3.
     *
     * @param pre 前序序列
     * @param in  中序序列
     * @return 树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length
                || pre.length < 0 || in.length < 0) {
            return null;
        }
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 递归构建
     *
     * @param pre 先序序列
     * @param ps  先序序列的开始位置
     * @param pe  先序序列的结束位置
     * @param in  中序序列
     * @param is  中序序列的开始位置
     * @param ie  中序序列的结束位置
     * @return 树
     */
    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        // 没有需要处理的元素
        if (ps > pe) {
            return null;
        }
        // 从先序序列中取当前根节点
        int value = pre[ps];
        // 记录中序序列的根的下标
        int index = is;
        // 在中序序列中找根节点的位置
        while (index <= ie && in[index] != value) {
            index++;
        }
        // 在中序遍历中没有找到,说明输入有错误
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        //创建当前根节点,并赋值
        TreeNode node = new TreeNode(value);

        //递归构建当前根节点的左子树，左子树的个数为index-is+1
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(pre, ps + 1, ps + index - is, in, is, index - 1);

        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(pre, ps + index - is + 1, pe, in, index + 1, ie);

        //返回创建的根节点
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}