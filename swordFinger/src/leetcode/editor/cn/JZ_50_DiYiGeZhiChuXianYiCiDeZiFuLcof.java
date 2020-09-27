package leetcode.editor.cn;
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 49 👎 0


//Java：第一个只出现一次的字符
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 只要正序找的字符和反序找的字符位置一样，就说明是只有一次出现的字符
        // 然后再找到最小的index 就是
        public char firstUniqChar(String s) {
            if (s == null || s.length() == 0) return ' ';
            int index = -1;
            for (char c = 'a'; c <= 'z'; c++) {
                int cur = s.indexOf(c);
                if (cur != -1 && cur == s.lastIndexOf(c)) {
                    index = (index == -1 ? cur : Math.min(index, cur));
                }
            }
            // 判断是否存在
            return index == -1 ? ' ' : s.charAt(index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}