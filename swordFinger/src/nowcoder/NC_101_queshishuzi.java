package nowcoder;

public class NC_101_queshishuzi {
    public int solve (int[] a) {
        // write code here
        int l = 0;
        int r = a.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (a[mid] == mid){
                l= mid +1;
            }else if (a[mid]>mid){
                r = mid-1;
            }
        }
        return l;
    }
}
