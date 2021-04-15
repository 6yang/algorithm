package nowcoder;

public class NC_105_search {
    public int search(int[] nums, int target) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (nums[middle] == target) {
                while (middle-1>=0 && nums[middle - 1] == target) {
                    middle--;
                }
                return middle;
            } else if (target > nums[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }
}
