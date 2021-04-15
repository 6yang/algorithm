package leetcode.editor.cn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Stack;

public class P_84_largestRectangleArea {


    // 单调栈解法
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] left = new int[n];
        int [] right = new int[n];
        Arrays.fill(right,n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] -1) * heights[i]);
        }
        return ans;
    }

    // 暴力解法
    public int largestRectangleArea_1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            // 向左边找
            int left = i;
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            //向右边找
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= curHeight) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, curHeight * width);
        }
        return res;
    }

    public static void main(String[] args) {
        LocalDateTime now =  LocalDateTime.now();

        System.out.println(now.plusHours(23).plusMinutes(59));
    }
}
