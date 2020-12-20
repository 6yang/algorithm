//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1059 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和
public class P_39_CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P_39_CombinationSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> out = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates== null || candidates.length==0|| target==0) return out;
            Arrays.sort(candidates);
            ArrayList<Integer> res = new ArrayList<>();
            dfs(candidates,target,0,res);
            return out;
        }

        private void dfs(int[] candidates, int target, int begin, ArrayList<Integer> res) {
            if(target<0){
                return ;

            }
            if(target==0){
                out.add(new ArrayList<>(res));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if(candidates[i]>target) continue; // 剪枝
                res.add(candidates[i]);
                dfs(candidates,target-candidates[i],i,res);
                res.remove(res.size()-1);
            }
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}