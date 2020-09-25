package leetcode.editor.cn;

public class JZ_14_II_cuttingRope {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        long mod = 1000000007;
        long res = 1;
        while(n>4){
            res*=3;
            res%=mod;
            n-=3;
        }
        return (int) ((res*n)%mod);
    }
}
