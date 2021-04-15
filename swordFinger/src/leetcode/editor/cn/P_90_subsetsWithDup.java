package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_90_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0) return res;
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums); //重复需要排序
        dfs(nums,used,0);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,used,i+1);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
