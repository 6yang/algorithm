package leetcode.editor.cn;

public class P_260_singleNumber {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mark = xor & -xor;
        int[] res = new int[2];
        for (int num : nums) {
            if ((mark & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(~4);
    }
}
