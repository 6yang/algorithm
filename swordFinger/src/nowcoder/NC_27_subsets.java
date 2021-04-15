package nowcoder;

import java.util.ArrayList;

public class NC_27_subsets {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S.length == 0) {
            return res;
        }
        dfs(S, 0);
        return res;
    }

    private void dfs(int[] nums, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.add(i);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
