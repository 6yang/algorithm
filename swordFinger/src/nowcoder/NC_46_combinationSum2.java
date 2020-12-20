package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class NC_46_combinationSum2 {
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num==null || num.length==0||target<=0)  return out;
        Arrays.sort(num);
        ArrayList<Integer>  res = new ArrayList<>();
        dfs(num,target,0,res);
        return out;
    }

    private void dfs(int[] num, int target, int begin, ArrayList<Integer> res) {
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<>(res);
            out.add(temp);
            return;
        }
        for (int i = begin; i < num.length; i++) {
            // 横向去重，剪枝
            if(i>begin && num[i]==num[i-1])
                continue;
            // 纵向剪枝，剪去大于的
            if(num[i]>target) break;

            // 回溯
            res.add(num[i]);
            dfs(num,target-num[i],i+1,res);
            res.remove(res.size()-1);
        }
    }
}
