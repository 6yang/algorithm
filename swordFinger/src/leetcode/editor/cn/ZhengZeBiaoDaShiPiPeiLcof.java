package leetcode.editor.cn;
//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划 
// 👍 112 👎 0


//Java：正则表达式匹配
public class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int a = s.length();
        int b = p.length();
        boolean [][] dp = new boolean[a+1][b+1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                // 1这里if主要做了两个判断
                // 空串和空正则匹配
                // 非空串和空正则一定不匹配
                // 2在else中
                // 空串和非空正则不一定
                // 非空串和非空正则也不一定
                if(j==0){
                    dp[i][j] = i==0;
                }else {
                    // 在非空正则中分为 * 和 非*两种情况
                    if(p.charAt(j-1)!='*'){
                        // 碰到非*
                        if(i>0&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else {
                        // 如果 p 的最后一个字符是*它代表 p[m-2]=c 可以重复0次或多次，它们是一个整体 c*
                        // 情况一：A[n-1] 是 0 个 c，B 最后两个字符废了，能否匹配取决于 A_{0..n-1}和 B_{0..m-3}是否匹配
                        // 情况二：A[n-1]是多个 c 中的最后一个（这种情况必须 s[n-1]=c或者 c='.'，所以s匹配完往前挪一个，
                        // p继续匹配，因为可以匹配多个，继续看 s{0..n-2}和 B{0..m-1} 是否匹配。
                        // 碰到*了，分为看和不看两种情况
                        // 不看
                        if(j>=2){
                            dp[i][j] |= dp[i][j-2];
                        }
                        // 看
                        if(i>=1&&j>=2 && (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[a][b];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}