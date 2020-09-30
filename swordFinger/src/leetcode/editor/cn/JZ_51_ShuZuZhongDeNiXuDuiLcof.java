package leetcode.editor.cn;
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 241 👎 0


//Java：数组中的逆序对
public class JZ_51_ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_51_ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = 0;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            mSort(nums, 0, nums.length - 1);
            return result;
        }

        private void mSort(int[] nums, int l, int r) {
            if (l < r) {
                int mid = l + (r - l) / 2;
                mSort(nums, l, mid);
                mSort(nums, mid + 1, r);
                mergeSort(nums, l, mid, r);
            }

        }

        private void mergeSort(int[] nums, int l, int mid, int r) {
            int[] help = new int[r - l + 1];
            int p = help.length - 1;
            int temp = mid + 1;
            while (mid >= l && r >= temp) {
                result += nums[mid] > nums[r] ? r - temp + 1 : 0;
                help[p--] = nums[mid] > nums[r] ? nums[mid--] : nums[r--];
            }
            while (r >= temp) help[p--] = nums[r--];
            while (mid >= l) help[p--] = nums[mid--];
            for (int i = 0; i < help.length; i++) {
                nums[l + i] = help[i];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}