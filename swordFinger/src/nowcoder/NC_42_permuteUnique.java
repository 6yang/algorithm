package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class NC_42_permuteUnique {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if(num.length == 0) return res;
        boolean [] used = new boolean[num.length];
        Arrays.sort(num);
        dfs(num,used);
        return res;
    }

    private void dfs(int[] num, boolean[] used) {
        if(path.size() == num.length){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < num.length; i++) {
            if(!used[i]){
                if(i>0 && num[i-1] == num[i] && !used[i-1]) continue;
                path.add(num[i]);
                used[i] = true;
                dfs(num,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
