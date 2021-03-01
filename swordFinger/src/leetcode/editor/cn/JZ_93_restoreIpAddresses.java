package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-25
 */
public class JZ_93_restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s,len,0,4,path,res);
        return res;

    }

    private void dfs(String s, int len, int begin, int layer, Deque<String> path, List<String> res) {
        if(begin == len){
            if(layer == 0){
                res.add(String.join(".",path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if(i >= len) {
                break;
            }
            if(3*layer <len-i){
                continue;
            }
            if(judgeIpSegment(s,begin,i)){
                String curSegment = s.substring(begin, i + 1);
                path.addLast(curSegment);
                dfs(s,len,i+1,layer-1,path,res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right -left +1;
        if(len>1 && s.charAt(left) == '0'){  //012
            return false;
        }
        int num = 0 ;
        while(left<=right){
            num = num*10 + s.charAt(left) -'0';
            left++;
        }
        return num<=255 && num>=0;
    }
}
