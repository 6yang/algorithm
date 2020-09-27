package leetcode.editor.cn;
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 99 👎 0


import java.util.Arrays;

//Java：把数组排成最小的数
public class JZ_45_BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_45_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 官方排序
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strs,(o1,o2)->(o1+o2).compareTo(o2+o1));
            StringBuilder res = new StringBuilder();
            for (String str : strs) {
                res.append(str);
            }
            return res.toString();
        }

        // 自定义排序
        public String minNumber_quickSort(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            quickSort(strs, 0, strs.length - 1);
            StringBuilder res = new StringBuilder();
            for (String str : strs) {
                res.append(str);
            }
            return res.toString();
        }

        // 排序规则  例子 3 32 68
        // 如果332>323，那么32就是较小的一方 32 3 68
        private void quickSort(String[] strs, int l, int r) {
            if (l < r) {
                int i = l;
                int j = r;
                String temp = strs[i];
                while (i < j) {
                    while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
                    while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
                    temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
                strs[i] = strs[l];
                strs[l] = temp;
                quickSort(strs,l,i-1);
                quickSort(strs,i+1,r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}