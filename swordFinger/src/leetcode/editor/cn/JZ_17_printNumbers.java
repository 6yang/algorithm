package leetcode.editor.cn;

public class JZ_17_printNumbers {
    public int[] printNumbers(int n) {
        int m = (int) Math.pow(10, n);
        int [] arr = new int[m-1];
        for (int i = 0; i < m - 1; i++) {
            arr[i] = i+1;
        }
        return arr;
    }


}
