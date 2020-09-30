package sort;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int [] arr = new int[]{99,22,45,88,44,11,4,66};
        sort.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mSort(nums, 0, nums.length - 1, temp);
    }

    private void mSort(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            int mid = (l + r) / 2;
            mSort(arr, l, mid, temp);
            mSort(arr, mid + 1, r, temp);
            merge(arr, l, mid, r, temp);
        }

    }

    private void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= r) {
            if(arr[i]<=arr[j]){
                temp[idx++] = arr[i++];
            }else{
                temp[idx++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[idx++] = arr[i++];
        }
        while(j<=r){
            temp[idx++] = arr[j++];
        }
        idx = 0;
        while(l<=r){
            arr[l++] = temp[idx++];
        }
    }

}
