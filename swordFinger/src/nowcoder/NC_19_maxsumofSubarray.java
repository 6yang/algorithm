package nowcoder;

public class NC_19_maxsumofSubarray {
    public int maxsumofSubarray (int[] arr) {
        // write code here
        if(arr.length == 0 ) return 0;
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cur<0){
                cur = arr[i];
            }else{
                cur += arr[i];
            }
            if(cur > res){
                res = cur;
            }
        }
        return res;
    }
}
