package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-01-07
 */

// 二分查找
public class NC_48_search {
    public int search(int[] A, int target) {
        // write code here
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < A[r]) {   // 右边
                if (target > A[mid] && target <= A[r]) {
                    l = l + 1;
                } else {
                    r = mid-1;
                }
            } else {   //左边
                if (A[mid] > target && target >= A[l]) {
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
