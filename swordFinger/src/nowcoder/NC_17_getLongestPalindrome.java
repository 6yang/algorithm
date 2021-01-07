package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-04
 */
public class NC_17_getLongestPalindrome {

    // 中心扩散法
    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (n < 2) {
            return n;
        }
        int left, right;
        int max= 0 ;
        for (int i = 1; i < n; i++) {
            left = i - 1;
            right = i;
            //偶数回文
            while (left >= 0 && right < n && A.charAt(left) == A.charAt(right)){
                max = Math.max(right-left+1,max);
                left--;
                right++;
            }

            left = i-1;
            right = i+1;
            // 判断奇数回文
            while(left>=0 && right<n && A.charAt(left) == A.charAt(right)){
                max = Math.max(right-left+1,max);
                left--;
                right++;
            }
        }
        return max;
    }

}
