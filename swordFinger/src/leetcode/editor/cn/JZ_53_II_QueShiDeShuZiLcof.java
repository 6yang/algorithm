package leetcode.editor.cn;
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 67 👎 0


//Java：0～n-1中缺失的数字
public class JZ_53_II_QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_53_II_QueShiDeShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if(nums[mid] == mid){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}