
package leetcode.editor.cn;
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 92 👎 0


//Java：1～n整数中1出现的次数
public class JZ_43_OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_43_OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            return dfs(n);
        }

        private int dfs(int n) {
            if(n<=0){
                return 0;
            }
            String number = String.valueOf(n);
            int high = number.charAt(0) - '0'; // 最高位n=2346,则high=2
            int belowPart = (int) Math.pow(10, number.length() - 1); // n=2346,则belowPart=2000
            int lastPart = n - high * belowPart;// n=2346则,lastPart=346
            if(high==1){
                // case 1234
                // 0-234 dfs(lastPart)
                // 0-999 dfs(belowPart-1)
                // 1000-1234 最高位1的个数,等于lastPart+1个
                return dfs(lastPart)+dfs(belowPart-1)+lastPart+1;
            }else{
                // case 3456
                // 0-456 dfs(lastPart)
                // 1000-1999 最高位1的个数，belowPart个
                // 0-999*3 3*dfs(below-1)
                return dfs(lastPart)+high*dfs(belowPart-1)+belowPart;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}