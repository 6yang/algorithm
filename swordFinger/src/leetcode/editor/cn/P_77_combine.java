package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P_77_combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
