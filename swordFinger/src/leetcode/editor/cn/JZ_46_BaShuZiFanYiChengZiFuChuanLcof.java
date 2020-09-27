package leetcode.editor.cn;
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 135 👎 0


//Java：把数字翻译成字符串
public class JZ_46_BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_46_BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 动态规划，跳台阶 优化
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int a = 1;
            int b = 1;
            for (int i = 2; i <= str.length(); i++) {
                String number = str.substring(i - 2, i);
                int c = number.compareTo("10") >= 0 && number.compareTo("25") <= 0 ? a + b : a;
                b = a;
                a = c;

            }
            return a;
        }

        // 动态规划，跳台阶
        public int translateNum_dp(int num) {
            String str = String.valueOf(num);
            int[] dp = new int[str.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= str.length(); i++) {
                String number = str.substring(i - 2, i);
                if (number.compareTo("10") >= 0 && number.compareTo("25") <= 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[str.length()];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}