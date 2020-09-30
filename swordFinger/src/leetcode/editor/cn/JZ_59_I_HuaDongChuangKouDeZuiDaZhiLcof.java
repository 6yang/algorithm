package leetcode.editor.cn;
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 117 👎 0


import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口的最大值
public class JZ_59_I_HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_59_I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从 O(k) 降低至 O(1)
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length==0 || k == 0) return new int[0];
            Deque<Integer> dq = new LinkedList<>();
            int [] res = new int[nums.length-k+1];
            //0-k
            for (int i = 0; i < k; i++) {
                while(!dq.isEmpty()&&nums[i]>dq.peekLast()){
                    dq.removeLast();
                }
                dq.addLast(nums[i]);
            }
            res[0] = dq.peekFirst();
            // k-nums.length-1
            for (int i = k; i < nums.length; i++) {
                if(nums[i-k] == dq.peekFirst())
                    dq.removeFirst();
                while(!dq.isEmpty()&&nums[i]> dq.peekLast()){
                    dq.removeLast();
                }
                dq.addLast(nums[i]);
                res[i-k+1] = dq.peekFirst();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}