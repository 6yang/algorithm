package leetcode.editor.cn;
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 74 👎 0


//Java：不用加减乘除做加法
public class JZ_65_BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_65_BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //思路：利用异或运算和与运算
        //与运算得出的是两数相加需要进位的数字c
        //异或得出的是两数相加不需要进位的数字a
        //然后a+b 再次循环直到需要进位的数字为0结束循环
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1; //进位的数字
                a ^= b; //未进位的数字
                b = c; //直到进位的数为0
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}