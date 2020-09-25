package leetcode.editor.cn;

public class JZ_11_minArray {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[j] > numbers[mid]) {
                j = mid;
            } else if (numbers[j] < numbers[mid]) {
                i = mid+1;
            }else{
                j--;
            }
        }
        return numbers[j];
    }
}
