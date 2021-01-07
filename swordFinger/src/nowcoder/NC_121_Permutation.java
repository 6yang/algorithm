package nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-01-07
 */
// 剑指offer 38
public class NC_121_Permutation {
    char [] c ;
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
         c = str.toCharArray();
         dfs(0);
         Collections.sort(res);
         return res;
    }
    private void dfs(int k) {
        if(k == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = k; i < c.length; i++) {
            if(set.contains(c[i])) continue; // abb 这种情况就不交换了 剪枝
            set.add(c[i]);
            swap(i,k);
            dfs(k+1);
            swap(k,i);
        }
    }
    private void swap(int l ,int r){
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
    }
}
