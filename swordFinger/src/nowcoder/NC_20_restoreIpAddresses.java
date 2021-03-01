package nowcoder;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NC_20_restoreIpAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int layer, Deque<String> path, ArrayList<String> res) {
        if (begin == len) {
            if (layer == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) { // 超出位数
                break;
            }
            if (layer * 3 < len - i) { //留下的位数超出IP段每段最多三位的限制
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                String curSegment = s.substring(begin, i + 1);
                path.addLast(curSegment);
                dfs(s, len, i + 1, layer - 1, path, res);
                path.removeLast();
            }

        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') { //排除012这种可能
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
