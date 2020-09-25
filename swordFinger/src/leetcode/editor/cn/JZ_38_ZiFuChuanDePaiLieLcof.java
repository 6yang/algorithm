
package leetcode.editor.cn;
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 107 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//Java：字符串的排列
public class JZ_38_ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_38_ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] c;
        List<String> res = new LinkedList<>();

        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }

        private void dfs(int k) {
            if(k==c.length-1){
                res.add(String.valueOf(c));
                return;
            }
            Set<Character> set = new HashSet<>();
            for (int i = k; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 这里做的是剪枝的操作 "abb"这种情况
                set.add(c[i]);
                swap(i,k);
                dfs(k+1);
                swap(k,i);
            }
        }

        private void swap(int i, int k) {
            char temp = c[i];
            c[i] = c[k];
            c[k] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}