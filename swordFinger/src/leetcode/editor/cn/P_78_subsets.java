package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P_78_subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return res;
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
