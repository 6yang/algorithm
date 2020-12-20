package test;

public class quickSort {

    public static void main(String[] args) {
        int [] arr = new int[]{33,22,1,3,22,44,6};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int[] quickSort(int []arr,int l,int r){
        if(l<r){
            int i  = l;
            int j = r ;
            int temp = arr[i];
            while(i<j){
                while(i<j&&temp<arr[j]) j--;
                if(i<j){
                    arr[i] =arr[j];
                    i++;
                }

                while(i<j&&temp>arr[i]) i++;
                if(i<j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = temp;
            quickSort(arr,l,i-1);
            quickSort(arr,i+1,r);
        }
        return arr;
    }
}
