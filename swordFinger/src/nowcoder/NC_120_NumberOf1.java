package nowcoder;

public class NC_120_NumberOf1 {
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
