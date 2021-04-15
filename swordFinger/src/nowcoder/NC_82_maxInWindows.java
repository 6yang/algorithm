package nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class NC_82_maxInWindows {
    //本题难点: 寻找窗口内的最大值从O(k)降低到O(1)
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || size == 0 || size > num.length) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!dq.isEmpty() && num[i]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(num[i]);
        }
        res.add(dq.peekFirst());
        for (int i = size; i < num.length; i++) {
            if (num[i-size] == dq.peekFirst()){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&& num[i]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(num[i]);
            res.add(dq.peekFirst());
        }
        return res;
    }
}
