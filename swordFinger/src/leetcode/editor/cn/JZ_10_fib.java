package leetcode.editor.cn;

public class JZ_10_fib {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        int temp ;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp = (dp[0]+dp[1])%1000000007;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }


}
