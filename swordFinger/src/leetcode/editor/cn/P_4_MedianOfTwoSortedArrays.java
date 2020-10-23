package leetcode.editor.cn;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3318 👎 0


//Java：寻找两个正序数组的中位数
public class P_4_MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P_4_MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [] arr = new int[n1+n2];
        if(n1 ==0){
            if(n2%2 == 0){//偶数个
                return (nums2[n2/2-1]+nums2[n2/2])/2.0;
            }else{
                return nums2[n2/2];
            }
        }
        if(n2==0){
            if(n1%2 == 0){//偶数个
                return (nums1[n1/2-1]+nums1[n1/2])/2.0;
            }else{
                return nums1[n1/2];
            }
        }
        int i = 0,j = 0,count = 0;
        while(count!=arr.length){   //数组进行归并
            if(i == n1){
                while(j!=n2){
                    arr[count++] = nums2[j++];
                }
                break;
            }
            if(j == n2){
                while(i!=n1){
                    arr[count++] = nums1[i++];
                }
                break;
            }
            if(nums1[i]<nums2[j]){
                arr[count++] = nums1[i++];
            }else{
                arr[count++] = nums2[j++];
            }
        }
        if(arr.length%2==0){
            return (arr[arr.length/2-1]+arr[arr.length/2])/2.0;
        }else{
            return arr[arr.length/2];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}