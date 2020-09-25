package leetcode.editor.cn;

public class JZ_10_numWays {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = (dp[0]+dp[1])%1000000007;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
