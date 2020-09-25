
package leetcode.editor.cn;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 138 👎 0


import java.util.PriorityQueue;
import java.util.Queue;

//Java：最小的k个数
public class JZ_40_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_40_ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 堆的思路
        public int[] getLeastNumbers_heap(int[] arr, int k) {
            if (k == 0 || arr.length == 0) return new int[]{};
            // 优先队列实际上应该是堆的实现
            // 默认实现的时小根堆 ，需要改成大根堆
            Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int i = 0; i < arr.length; i++) {
                if (heap.size() < k) {
                    heap.offer(arr[i]);
                } else if (arr[i] < heap.peek()) {
                    heap.poll(); // 推出堆里面的最大值
                    heap.offer(arr[i]);
                }
            }
            // 这时候堆中应该存了最小的K个数
            int[] res = new int[heap.size()];
            int idx = 0 ;
            for (Integer num : heap) {
                res[idx++] = num;
            }
            return res;
        }

        // 快排的思路
        public int[] getLeastNumbers_quickSort(int[] arr, int k) {
            int [] res = new int[k];
            quickSort(arr,0,arr.length-1,k);
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        private void quickSort(int[] arr, int low, int high,int k) {
            if(low<high){
                int i = low;
                int j = high;
                int temp = arr[i];
                while(i<j){
                    while(i<j&&temp<arr[j]) j--;
                    if(i<j){
                        arr[i] = arr[j];
                        i++;
                    }
                    while(i<j&&arr[i]<temp) i++;
                    if(i<j){
                        arr[j] = arr[i];
                        j--;
                    }
                }
                arr[i] = temp; // 提前返回
                if(i==k) return;
                quickSort(arr,low,i-1,k);
                if(i<k){ //剪枝
                    quickSort(arr,i+1,high,k);
                }

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}