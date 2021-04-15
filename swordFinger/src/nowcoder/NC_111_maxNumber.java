package nowcoder;

import sort.QuickSort;

public class NC_111_maxNumber {

    public String solve(int[] nums) {
        // write code here
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        if("0".equals(strs[strs.length-1])) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            String temp = strs[i];
            while (i < j) {
                while((strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0 && i<j) j--;
                while((strs[i]+strs[l]).compareTo(strs[l]+strs[i])<=0 && i<j) i++;
                temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
            }
            strs[i] = strs[l];
            strs[l] = temp;
            quickSort(strs,l,i-1);
            quickSort(strs,i+1,r);
        }
    }

}
