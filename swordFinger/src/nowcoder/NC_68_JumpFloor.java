package nowcoder;

public class NC_68_JumpFloor {
    public int JumpFloor(int target) {
        if(target<=1) return  target;
        int [] dp = new int[]{1,1};
        for (int i = 2; i <= target; i++) {
            int temp = dp[0]+dp[1];
            dp[0]  = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
