package 剑指offer.ch1_10;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**面试题4：替换空格
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test4 {
    /**
     * 替换空格  假设字符串空间无限大
     *
     * 解题思路：O（n）
     * 1.找出空格的个数
     * 2.计算替换后字符数组的长度
     * 3.从字符串后面开始复制和替换
     * 4. P1 P2 2个指针 P1指向原始字符数组的末尾 p2指向替换后字符数组的末尾
     * 5. p1向前拷贝
     *
     * @param string 需要替换的字符数组
     * @param length  字符数组的总容量
     * @return 转换后字符数组的长度
     */
    public char[] replaceBlank(char[] string, int length) {
        //判断输入
        if (string == null || length <= 0){
            return null;
        }
        //统计字符数组中的空格个数
        int numberOfBlank = 0;
        // 字符数组实际长度
        int usedLength = 0;
        int i = 0;
        while(string[i] != '\0'){
            usedLength++;
            if (string[i] == ' '){
                numberOfBlank++;
            }
            ++i;
        }
        // 如果没有空格,不处理
        if (numberOfBlank == 0){
            return null;
        }
        // 计算转换后的字符数组大小
        int targetLength = numberOfBlank * 2 + usedLength;
        int p1 = usedLength - 1;
        int p2 = targetLength - 1;
        while (length >= 0 && p1 < p2){
            if (string[p1] == ' '){
                string[p2--] = '0';
                string[p2--] = '2';
                string[p2--] = '%';
            }else{
                string[p2--] = string[p1];
            }
            p1--;
        }
        return string;
    }

    public static void main(String[] args){
        Test4 test4 = new Test4();
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';
        System.out.println(test4.replaceBlank(string,50).toString());
    }
}
