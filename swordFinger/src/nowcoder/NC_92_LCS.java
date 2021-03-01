package nowcoder;


// leetcode 1143
public class NC_92_LCS {
    public String LCS (String s1, String s2) {
        // write code here
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int [][] dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if(char1[i-1] == char2[j-1]){
                   dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if(dp[len1][len2] == 0) return "-1";
        int i = len1;
        int j = len2;
        StringBuilder res = new StringBuilder();
        while(dp[i][j]>0){
            while (dp[i-1][j] == dp[i][j]){
                i--;
            }
            while (dp[i][j-1] == dp[i][j]){
                j--;
            }
            res.append(char1[--i]);
            j--;
        }
        return res.reverse().toString();
    }
}
