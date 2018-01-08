package 剑指offer.ch41_50;

/**
 * 面试题42：翻转单词顺序vs左旋转字符串
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test42 {

    public String ReverseSentence(String str) {
        if (str == null|| "".equals(str.trim())){
            return str;
        }
        String[] words = str.split(" ");

        StringBuilder sb = new StringBuilder();
        // 翻转整个句子
        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0){
                sb.append(words[i]);
            }else{
                sb.append(words[i]+" ");
            }
        }
        return sb.toString();
    }

    /**
     * 先将整个句子反转  .tneduts a ma I
     * 再翻转每个字符的顺序
     * @param str
     * @return
     */
    public String ReverseSentence1(String str) {
        if (str == null || "".equals(str.trim())){
            return str;
        }
        char[] st = str.toCharArray();
        // 翻转整个句子
        reverse(st,0,str.length() - 1);
        // 翻转每个句子的顺序
        int begin = 0;
        int end = 0;
        while(begin != st.length) {
            if (st[begin] == ' ') {
                begin++;
                end++;
            } else if (st[end] == ' ') {
                reverse(st, begin, --end);
                begin = ++end;
            } else if(end == st.length - 1){
                reverse(st, begin, end);
                begin = ++end;
            } else{
                end++;
            }

        }
        return String.valueOf(st);
    }

    public void  reverse(char[] c,int begin,int end){
        while(begin < end){
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;

            begin++;
            end--;
        }
    }

    public static void main(String[] args){
        Test42 test42 = new Test42();
        String str = "I am a student.";
        System.out.println(test42.ReverseSentence1(str));
    }
}
