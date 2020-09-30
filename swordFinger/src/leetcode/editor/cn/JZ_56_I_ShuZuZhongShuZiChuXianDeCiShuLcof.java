package leetcode.editor.cn;
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 228 👎 0


//Java：数组中数字出现的次数
public class JZ_56_I_ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_56_I_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
        int div = 1;
        System.out.println(div << 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        //
        //在异或结果中找到任意为 1 的位。
        //
        //根据这一位对所有的数字进行分组。
        //
        //在每个组内进行异或操作，得到两个数字。
        public int[] singleNumbers(int[] nums) {
            int twoXor = 0;  // 两个只出现一次的数的异或
            for (int num : nums) {
                twoXor ^= num;
            }
            //找出两个数只出现一次数的分组点
            int div = 1;
            while ((div & twoXor) == 0) {
                div <<= 1;
            }
            int[] res = new int[2];
            for (int num : nums) {
                if ((num & div) == 0) {
                    res[0] ^= num;
                } else {
                    res[1] ^= num;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}