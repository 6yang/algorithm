package leetcode.editor.cn;
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 158 👎 0


import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
public class JZ_57_II_HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_57_II_HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口
        public int[][] findContinuousSequence(int target) {
            int l = 1;
            int r = 1;
            int sum = 0;
            List<int[]> res = new ArrayList<>();
            while (l <= target / 2) {
                if (sum < target) sum += r++;
                else if (sum >target) sum -=l++;
                else {
                    int [] arr = new int[r-l];
                    for (int i = l; i < r; i++) {
                        arr[i-l] = i;
                    }
                    res.add(arr);
                    sum-=l++;

                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}