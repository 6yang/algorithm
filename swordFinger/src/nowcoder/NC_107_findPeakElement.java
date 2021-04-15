package nowcoder;

public class NC_107_findPeakElement {
    public int solve (int[] a) {
        // write code here
        int result = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                result = i;
            }
        }
        return result;
    }
}
