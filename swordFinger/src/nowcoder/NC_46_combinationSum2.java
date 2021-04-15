package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class NC_46_combinationSum2 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0 || target <= 0) {
            return res;
        }
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        dfs(num, used, target, 0);
        return res;
    }

    private void dfs(int[] num, boolean[] used, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < num.length; i++) {
            if (i > 0 && num[i - 1] == num[i] && !used[i-1]) continue;
            if(num[i]>target) continue;
            used[i] = true;
            path.add(num[i]);
            dfs(num,used,target-num[i],i+1);
            path.remove(path.size()-1);
            used[i] =false;
        }
    }

}
