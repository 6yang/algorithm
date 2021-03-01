package nowcoder;

// leetcode 41 缺失的第一个正数

public class NC_30_minNumberdisappered {
    public int minNumberdisappered (int[] arr) {
        // write code here
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while(arr[i] > 0 && arr[i] <= len && arr[i]!=arr[arr[i]-1]){
                swap(arr,arr[i]-1,i);
            }
        }
        for (int i = 0; i < len; i++) {
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] =temp;
    }
}
