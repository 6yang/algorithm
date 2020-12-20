package nowcoder;

public class NC_127_LCS {
    public String LCS (String str1, String str2) {
        // write code here
        if(str1==null || str2 ==null || "".equals(str1)|| "".equals(str2)) return "";
        int m = str1.length();
        int n = str2.length();
        int maxLen = 0;
        int maxIndex = 0;
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }
                if (dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    maxIndex = i;
                }
            }
        }
        if(maxLen == 0) return "-1";
        return str1.substring(maxIndex-maxLen+1,maxIndex+1);
    }
}
