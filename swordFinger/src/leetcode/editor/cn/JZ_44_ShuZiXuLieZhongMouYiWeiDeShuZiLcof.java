
package leetcode.editor.cn;
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 61 👎 0


import com.sun.org.apache.xpath.internal.operations.String;

//Java：数字序列中某一位的数字
public class JZ_44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            // 1确定开始和位数
            while (n > count) {
                n -= count;
                digit += 1; //位数 0-9 1 | 10-99 2 | 100-999 3 | ...
                start *= 10;//开始 0-9 0 | 10-99 10 | 100-999 100 | ...
                count = 9 * start * digit; //数字个数 0-9 9 | 10-99 180 | 100-999 2700
            }
            // 2确定n所在的数字
            long num = start + (n - 1) / digit;
            // 3确定n所在数字第几个
            return Long.toString(num).charAt((n - 1) % digit) - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}