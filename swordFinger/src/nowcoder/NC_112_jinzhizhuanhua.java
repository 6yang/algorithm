package nowcoder;


public class NC_112_jinzhizhuanhua {
    public String solve(int M, int N) {
        // write code here
        if (M == 0) {
            return "0";
        }
        boolean sign = false;
        if (M < 0) {
            sign = true;
            M = -M;
        }
        StringBuilder sb = new StringBuilder();
        while (M > 0) {
            int k = M % N;
            if (k >= 10) {
                sb.append((char) (k - 10 + 'A'));
            } else {
                sb.append(k);
            }
            M /= N;
        }
        if (sign) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
