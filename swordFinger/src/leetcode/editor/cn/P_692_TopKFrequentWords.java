//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 176 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：前K个高频单词
public class P_692_TopKFrequentWords{
    public static void main(String[] args) {
        Solution solution = new P_692_TopKFrequentWords().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i],1);
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<>((w1,w2)->
                map.get(w1).equals(map.get(w2))?w2.compareTo(w1):map.get(w1)-map.get(w2));
        for (String key : map.keySet()) {
            heap.offer(key);
            if(heap.size()>k) heap.poll();
        }
        while(!heap.isEmpty()) res.add(heap.poll());
        Collections.reverse(res);
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}