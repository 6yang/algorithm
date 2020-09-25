package leetcode.editor.cn;

public class JZ_16_myPow {
    //int32 变量 n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647]
    public double myPow(double x, int n) {
        if (x == 0 || x == 1.0) return x;
        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b&1) == 1) res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }


}
