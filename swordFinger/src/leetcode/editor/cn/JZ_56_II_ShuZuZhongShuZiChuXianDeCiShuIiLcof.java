package leetcode.editor.cn;
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 82 👎 0


//Java：数组中数字出现的次数 II
public class JZ_56_II_ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_56_II_ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            //统计每一位的数字的个数
            int[] count = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    count[i] += num & 1;
                    num >>>= 1;
                }
            }
            //然后把count数组对3取余，留下来的位数就是只出现一次的数出现的位置
            int res =0;
            for (int i = 0; i < 32; i++) {
                res <<=1;
                res |= count[31-i]%3;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}