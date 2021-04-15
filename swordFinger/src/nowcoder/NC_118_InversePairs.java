package nowcoder;

public class NC_118_InversePairs {
    int count = 0;

    public int InversePairs(int[] array) {
        merge(array, 0, array.length - 1);
        return count;
    }

    private void merge(int[] array, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(array, left, mid);
            merge(array, mid + 1, right);
            mergeSort(array, left, mid, right);
        }
    }

    private void mergeSort(int[] array, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        int t1 = left, t2 = mid + 1;
        while (t1 <= mid && t2 <= right) {
            if (array[t1] <= array[t2]) {
                tempArr[index++] = array[t1++];
            } else {
                count += (mid - t1 + 1);
                count %= 1000000007; //牛客这道题会溢出
                tempArr[index++] = array[t2++];
            }
        }
        // 左边的剩余都移入数组
        while (t1 <= mid) {
            tempArr[index++] = array[t1++];
        }
        // 右边的剩余都移入数组
        while (t2 <= right) {
            tempArr[index++] = array[t2++];
        }
        for (int k = 0; k < tempArr.length; k++) {
            array[k + left] = tempArr[k];
        }
    }
}
