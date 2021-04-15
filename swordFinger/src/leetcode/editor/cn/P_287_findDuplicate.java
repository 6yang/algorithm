package leetcode.editor.cn;

public class P_287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;
            int ctn = 0;
            for (int num : nums) {
                if (num <= mid) {
                    ctn++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (ctn > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }
}
