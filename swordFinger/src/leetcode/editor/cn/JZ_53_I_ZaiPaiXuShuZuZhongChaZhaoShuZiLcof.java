package leetcode.editor.cn;
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 65 👎 0


//Java：在排序数组中查找数字 I
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length-1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    l = mid-1;
                    r = mid+1;
                    while(l>=0&&nums[l] == target) l--;
                    while(r<=nums.length-1&&nums[r] == target) r++;
                    return r-l-1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}