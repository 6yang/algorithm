package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_40_combinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || target == 0){
            return res;
        }
        Arrays.sort(candidates);
        boolean [] used = new boolean[candidates.length];
        dfs(candidates,target,used,0);
        return res;
    }

    private void dfs(int[] candidates, int target,boolean [] used,int begin) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(candidates[i] > target) continue;
            if(!used[i]){
                if(i>0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
                path.add(candidates[i]);
                used[i] = true;
                dfs(candidates,target-candidates[i],used,i+1);
                used[i] = false;
                path.remove(path.size()-1);
            }

        }
    }
}
