package nowcoder;

public class NC_91_LIS {
    public int[] LIS (int[] arr) {
        // write code here
        if(arr.length<=1) return arr;
        int [] cell = new int[arr.length];
        int [] idxlen = new int[arr.length];
        cell[0] = arr[0];
        int len = 1;
        idxlen[0] = len;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>cell[len-1]){
                cell[len++] = arr[i];
                idxlen[i] = len;
            }else if(arr[i] == cell[len-1]){
                idxlen[i] = len;
            }else {
                int l = 0;
                int r = len;
                while(l<r){
                    int mid = (l+r)>>1;
                    if(arr[i]>cell[mid]){
                        l = mid +1;
                    }else {
                        r = mid ;
                    }
                }
                cell[l] = arr[i];
                idxlen[i] = l+1;
            }
        }
        int [] res = new int[len];
        for (int i = arr.length-1; i >= 0; i--) {
            if(idxlen[i] == len){
                res[--len] = arr[i];
            }
        }
        return res;
    }
}
