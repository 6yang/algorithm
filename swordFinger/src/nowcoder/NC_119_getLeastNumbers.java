package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NC_119_getLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0 || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        // 使用大根堆来实现
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int i = 0; i < input.length; i++) {
            if (heap.size() < k) {
                heap.offer(input[i]);
            } else if (input[i] < heap.peek()) {
                heap.poll();
                heap.offer(input[i]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            res.add(heap.poll());
        }
        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_kuaipai(int[] input, int k) {
        quickSort(input, 0, input.length - 1, k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quickSort(int[] input, int low, int high, int k) {
        if (low < high) {
            int i = low;
            int j = high;
            int temp = input[i];
            while (i<j) {
                while (i<j && temp < input[j]) j--;
                if (i<j) {
                    input[i] = input[j];
                    i++;
                }
                while (i<j && temp > input[i]) i++;
                if (i<j) {
                    input[j] = input[i];
                    j--;
                }
            }
            input[i] = temp;
            if (i==k) return;
            quickSort(input,low,i-1,k);
            if (i<k) {
                quickSort(input,i+1,high,k);
            }
        }
    }
}
