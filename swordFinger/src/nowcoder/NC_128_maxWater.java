package nowcoder;

import java.util.logging.Level;

/*
* 双指针解法，按照列来
* */
public class NC_128_maxWater {
    public long maxWater(int[] arr) {
        // write code here
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int max_left = 0;
        int max_right = 0;
        int l = 1;
        int r = arr.length - 2;
        long sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            //从左到右
            if (arr[l - 1] < arr[r + 1]) {
                max_left = Math.max(max_left,arr[l-1]);
                if(max_left>arr[l]){
                    sum += max_left-arr[l];
                }
                l++;
            }else {
                max_right = Math.max(max_right,arr[r+1]);
                if(max_right>arr[r]){
                    sum += max_right - arr[r];
                }
                r--;
            }
        }
        return sum;
    }
}
