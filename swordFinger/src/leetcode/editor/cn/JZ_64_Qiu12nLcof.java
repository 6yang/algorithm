package leetcode.editor.cn;
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 214 👎 0


//Java：求1+2+…+n
public class JZ_64_Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_64_Qiu12nLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路 ：逻辑运算符的短路效应
        // if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
        // if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
        int res = 0;
        public int sumNums(int n) {
            boolean x = n>1 && sumNums(n-1)>0;
            res +=n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}