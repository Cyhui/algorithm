package nowcoder.ch07_binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后序遍历(二维数组的形式)。
 * <p>
 * Created by Cyhui on 2017/8/10 0010.
 */
public class Problem_7_3_TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] res = new int[3][];

        res[0] = listToArray(preOrder(root));
        res[1] = listToArray(inOrder(root));
        res[2] = listToArray(postOrder(root));

        return res;
    }

    /**
     * 非递归方式实现先序遍历
     * <p>
     * 具体过程：
     * 1、首先申请一个新的栈，记为stack
     * 2、然后将头节点head压入stack中
     * 3、每次从stack中弹出栈顶节点，记为cur，然后打印cur节点的值。
     * 如果cur右孩子不为空的话，将cur的右孩子先压入stack中。
     * 最后如果cur的左孩子不为空的话，将cur的左孩子压入stack中。
     *
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return null;
        }

        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    /**
     * 非递归方法实现中序遍历
     * <p>
     * 具体过程：
     * 1、申请一个新的栈，记为stack，申请一个变量cur，初始时令cur等于头节点。
     * 2、先把cur节点压入栈中，对以cur节点为头的整颗子树来说，依次把整颗树的
     * 左边界压入栈中，即不断令cur=cur.left,然后重复步骤2
     * 3、不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点，记为node。
     * 打印node的值，并让cur=node.right,然后重复步骤2.
     * 4、当stack为空并且cur为空时，整个过程结束。
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty() || cur != null) {
            if (cur == null || cur.left == null) {
                cur = stack.pop();
                list.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.right;
            } else {
                stack.push(cur.left);
                cur = cur.left;
            }
        }
        return list;
    }

    /**
     * 非递归方法实现后序遍历
     * <p>
     * 方法一：使用两个栈实现
     * 具体过程：
     * 1、申请一个栈，记为s1，然后将头节点压入s1
     * 2、从s1中弹出的节点记为cur，然后先把cur的左孩子压入s1中，然后把cur的右孩子压入s1中。
     * 3、在整个过程中，每个从s1中弹出的节点都放进第二个栈s2中。
     * 4、不断重复步骤2和步骤3，直到s1为空，过程结束
     * 5、从s2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序
     * <p>
     * 方法二：使用一个栈实现：
     * 具体过程：
     * 1、申请一个栈，记为stack，将头节点压入stack中，同时设置两个变量h和c。
     * 在整个流程中，h代表最近一次弹出并打印的节点，c代表当前stack的栈顶节
     * 点，初始时令h为头节点，c为null。
     * 2、每次令c等于当前stack的栈顶节点，但是不从stack中弹出节点，此时分一下三种情况：
     * (1)如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子压入stack中。
     * (2)如果情况1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入stack中。
     * (3)如果情况1和情况2都不成立，那么从stack中弹出c并打印，然后令h等于c。
     * 3、一直重复步骤2，直到stack为空，过程结束。
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        /* 方法一：*/
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        /*  方法二：
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return null;
        }

        TreeNode last = root;
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && last != cur.left && last != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && last != cur.right) {
                stack.push(cur.right);
            } else {
                last = stack.pop();
                list.add(last.val);
            }
        }*/

        return list;
    }

    private int[] listToArray(List<Integer> list) {
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
}
