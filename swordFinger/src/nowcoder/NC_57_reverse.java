package nowcoder;


public class NC_57_reverse {
    public int reverse(int x) {
        // write code here
        int res = 0;
        while (x != 0) {
            int mod = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0;
            }
            x = x/10;
            res = res*10 + mod;
        }
        return res;
    }


}
