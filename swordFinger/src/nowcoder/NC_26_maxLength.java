package nowcoder;

import java.util.HashMap;
import java.util.Map;

public class NC_26_maxLength {
    public int maxLength(int[] arr) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while(j<arr.length){
            if(map.containsKey(arr[j])){
                i =  Math.max(map.get(arr[j])+1,i);
            }
            map.put(arr[j],j);
            j++;
            maxLen = Math.max(maxLen,j-i);

        }
        return maxLen;
    }
}
