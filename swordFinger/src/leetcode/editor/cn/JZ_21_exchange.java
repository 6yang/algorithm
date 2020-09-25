package leetcode.editor.cn;

public class JZ_21_exchange {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j&&nums[i]%2==1) i++;
            while(i<j&&nums[j]%2==0) j--;
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] =temp;
        }
        return nums;
    }
}
