package leetcode.editor.cn;

public class JZ_19_isMatch {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int rows = s.length();
        int columns = p.length();
        boolean[][] dp = new boolean[rows + 1][columns + 1];
        dp[0][0] = true;
        for (int i = 1; i < columns; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2])
                dp[0][i] = true;
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                char nows = s.charAt(i - 1);
                char nowp = s.charAt(j - 1);
                if (nows == nowp || nowp == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (nowp == '*') {
                    if (j >= 2) {
                        char nowpLast = p.charAt(j - 2);
                        if (nowpLast == nows || nowpLast == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                        }
                        dp[i][j] = dp[i][j] || dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[rows][columns];
    }
}
