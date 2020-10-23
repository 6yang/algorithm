package leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4477 👎 0


import java.util.HashSet;
import java.util.Set;

//Java：无重复字符的最长子串
public class P_3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0,j= 0 ,res = 0;
        while (i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = j-i>res ? j-i :res;
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}