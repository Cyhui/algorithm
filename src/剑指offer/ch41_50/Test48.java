package 剑指offer.ch41_50;

import java.util.LinkedList;

/**面试题48： 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test48 {
     public int StrToInt(String str) {
          if (str == null){
               return 0;
          }
          // 结果
          int result = 0;
          // 正负标记   true 为负数
          boolean negative = false;
          // 字符串index
          int i = 0;
          // 字符串长度
          int len = str.length();
          int limit = -Integer.MAX_VALUE;
          // 数字
          int digit;

          int multMin;
          // 字符串长度大于0
          if (len > 0){
               // 判断数字正负
               char firstChar = str.charAt(0);
               // ASCLL 中0: 48  9: 57  a: 97  A: 65  *:42  + :43  -: 45  /:47
               if (firstChar < '0'){
                    // may be + or -
                    if (firstChar == '-'){
                         negative = true;
                         limit = Integer.MIN_VALUE;
                    }else if (firstChar != '+'){
                         return 0;
                    }
                    // 字符串中不能只有 + or -
                    if(len == 1){
                         return 0;
                    }
                    i++;
               }
               multMin = limit / 10;
               // 遍历字符串
               while(i < len){
                    digit = Character.digit(str.charAt(i++),10);
                    if (digit < 0){
                         return 0;
                    }
                    if (result < multMin){
                         return 0;
                    }
                    result *= 10;
                    //digit必须放在不等式右侧防止左侧溢出，判断防止最终溢出
                    if (result < limit + digit){
                         return 0;
                    }
                    result -= digit;
               }
          }else{
               return 0;
          }
          return negative ? result : -result;
     }
}
