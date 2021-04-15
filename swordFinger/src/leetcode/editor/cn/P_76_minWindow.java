package leetcode.editor.cn;

public class P_76_minWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        // 记录需要字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, count = t.length();
        int size = Integer.MAX_VALUE, start = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) { // 需要字符C
                count--;
            }
            need[c]--;// 右边的字符加入窗口
            if (count == 0) { // 窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) { // 删除左边不需要的字符
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l; // 记录最小值开始的位置
                }
                // l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "":s.substring(start,start+size);
    }
}
