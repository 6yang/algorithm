package leetcode.editor.cn;

public class P_60_getPermutation {
    private int[] factorial;
    boolean[] used;
    public String getPermutation(int n, int k) {
        used = new boolean[n + 1];
        calculateFactorial(n);
        StringBuilder path = new StringBuilder();

        dfs(n, k, path, 0);
        return path.toString();
    }

    private void dfs(int n, int k, StringBuilder path, int index) {
        if(index == n) return ;
        int ctn = factorial[n-1-index];
        for (int i = 1; i <= n; i++) {
            if(used[i]) continue;
            if(ctn<k){
                k-=ctn;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(n,k,path,index+1);
            return;
        }
    }

    //计算阶乘
    private void calculateFactorial(int n ){
        factorial = new int[n+1];
        factorial[0] =1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1]*i;
        }
    }
}
