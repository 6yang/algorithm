package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-01
 */
public class NC_141_juageHuiWeng {
    public boolean judge(String str) {
        // write code here
        if (str == null || str.length() < 2) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if(str.charAt(left++)!=str.charAt(right--)) return false;
        }
        return true;
    }
}
