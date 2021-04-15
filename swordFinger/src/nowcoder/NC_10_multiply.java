package nowcoder;

public class NC_10_multiply {

    // 大数相乘
    public String solve(String s, String t) {
        // write code here
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int[] res = new int[s.length() + t.length()];
        for (int i = charArray1.length - 1; i >= 0; i--) {
            for (int j = charArray2.length - 1; j >= 0; j--) {
                int mul = (charArray1[i] - '0') * (charArray2[j] - '0') + res[i + j + 1];
                res[i + j + 1] = mul % 10;
                res[i + j] += mul / 10;
            }
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx<res.length&&res[idx]==0) idx++;
        while (idx<res.length) sb.append(res[idx++]);
        return sb.length()==0 ? "0" : sb.toString();
    }
}
