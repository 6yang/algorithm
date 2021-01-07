package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-02
 */
public class NC_65_Fibonacci {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = {0, 1};
        int i = 2;
        while (i++ <= n) {
            int temp = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
