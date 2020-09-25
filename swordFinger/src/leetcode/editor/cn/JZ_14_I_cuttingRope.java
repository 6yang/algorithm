package leetcode.editor.cn;

public class JZ_14_I_cuttingRope {
    // 3最优
    // 2其次
    // 1最差  应该改为1+3 =2*2
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if(b==0) return (int) Math.pow(3,a);
        if(b==1) return (int) (Math.pow(3,a-1)*4);
        return (int) (Math.pow(3,a)*2);
    }
}
