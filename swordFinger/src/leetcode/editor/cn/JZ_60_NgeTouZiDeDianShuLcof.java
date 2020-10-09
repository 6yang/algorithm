package leetcode.editor.cn;
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 117 👎 0


//Java：n个骰子的点数
public class JZ_60_NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_60_NgeTouZiDeDianShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] twoSum(int n) {
        double [] pre = {1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}; // 初始化一个骰子出现的几率
        for (int i = 2; i <= n; i++) {
            double [] temp = new double[i*5+1];   // 每组筛子点数的长度
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j+k] += pre[j]*(1/6d); // 更新每增加一个筛子当前点数出现的几率
                }
            }
            pre = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}