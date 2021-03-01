package nowcoder;

import java.util.ArrayList;

//leetcode 22
public class NC_26_generateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String s, int leftB, int rightB, ArrayList<String> res) {
        if(leftB==0 && rightB ==0){
            res.add(s);
            return;
        }
        if(leftB>rightB){ //右括号使用大于左括号的时候剪枝
            return;
        }
        if(leftB>0){
            dfs(s+"(",leftB-1,rightB,res);
        }
        if(rightB>0){
            dfs(s+")",leftB,rightB-1,res);
        }
    }
}
