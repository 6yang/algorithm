//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1159 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长上升子序列
public class P_300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P_300_LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] cell = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            if(len==0 || cell[len-1]<num){
                cell[len++] = num;
            }else {
                int i = 0;
                int j = len;
                while(i<j){
                    int mid = (i+j)>>1;
                    if(num>cell[mid]){
                        i = mid +1;
                    }else {
                        j = mid;
                    }
                }
                cell[i] = num;
            }
        }
        return len;

    }
        public int lengthOfLIS_dp(int[] nums) {
            int [] dp = new int[nums.length];
            int res =0;
            Arrays.fill(dp,1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i]>nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
                }
                res = Math.max(dp[i],res);
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}