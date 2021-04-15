package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P_137_singleNumber {

    public static void main(String[] args) {
        P_137_singleNumber singleNumber = new P_137_singleNumber();
        singleNumber.singleNumber(new int[]{2,2,3,2});

    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> 1 & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }

    public int singleNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long singleSum = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(num)) {
                continue;
            }
            singleSum += num;
            set.add(num);
        }
        return (int) ((singleSum * 3 - sum) / 2);
    }
}
