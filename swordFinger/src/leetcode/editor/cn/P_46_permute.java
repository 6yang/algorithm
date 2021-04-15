package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P_46_permute {
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 ) return res;
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!path.contains(nums[i])){
                path.add(nums[i]);
                dfs(nums);
                path.remove(path.size()-1);
            }
        }
    }
}
