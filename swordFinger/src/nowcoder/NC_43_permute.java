package nowcoder;

import java.util.ArrayList;

public class NC_43_permute {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num.length == 0) {
            return res;
        }
        dfs(num);
        return res;
    }

    private void dfs(int[] num) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!path.contains(num[i])) {
                path.add(num[i]);
                dfs(num);
                path.remove(path.size()-1);
            }
        }
    }
}
