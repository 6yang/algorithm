package leetcode.editor.cn;

public class P_162_findPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid+1]){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
