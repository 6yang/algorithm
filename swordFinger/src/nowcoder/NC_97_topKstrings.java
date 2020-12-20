package nowcoder;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class NC_97_topKstrings {
    public static String[][] topKstrings (String[] strings, int k) {
        // write code here
        HashMap<String,Integer> count = new HashMap<>();
        for (String word : strings) {
            count.put(word,count.getOrDefault(word,0)+1);
        }
        Queue<String> heap = new PriorityQueue<>((w1,w2)->
                count.get(w1).equals(count.get(w2))?w2.compareTo(w1):count.get(w1)-count.get(w2));
        for (String word : count.keySet()) {
            heap.offer(word);
            if(heap.size()>k) heap.poll();
        }
        String [][] res =new String[k][2];
        for (int i = k-1; i >= 0; i--) {
            res[i][0] = heap.poll();
            res[i][1] = String.valueOf(count.get(res[i][0]));
        }
        return res;
    }
}
