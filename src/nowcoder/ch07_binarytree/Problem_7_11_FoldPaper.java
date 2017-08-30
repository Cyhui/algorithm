package nowcoder.ch07_binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。
 * 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * <p>
 * 测试样例：
 * 1
 * 返回：["down"]
 * Created by Cyhui on 2017/8/11 0011.
 */
public class Problem_7_11_FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        String[] s = new String[((1 << n) - 1)];//2ⁿ-1
        Queue<String> queue = new LinkedList<>();
        printProcess(1, n, true, queue);
        for (int i = 0; i < (1 << n) - 1; i++) {
            s[i] = queue.poll();
        }
        return s;
    }

    public void printProcess(int i, int N, boolean down, Queue<String> queue) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true, queue);
        String s = down ? "down" : "up";
        queue.add(s);
        printProcess(i + 1, N, false, queue);
    }
}
