package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-28
 */
public class NC_90_getMinStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minData = new Stack<>();

    public int[] getMinStack(int[][] op) {
        // write code here
        if (op == null || op.length == 0) {
            return new int[] {};
        }
        ArrayList<Integer> minarr = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {
                data.push(op[i][1]);
                if (minData.isEmpty() || minData.peek() >= op[i][1]) {
                    minData.push(op[i][1]);
                }
            } else if (op[i][0] == 2) {
                if (data.pop().equals(minData.peek())) {
                    minData.pop();
                }
            } else {
                minarr.add(minData.peek());
            }
        }
        int[] res = new int[minarr.size()];
        for (int i = 0; i < minarr.size(); i++) {
            res[i] = minarr.get(i);
        }
        return res;
    }
}
