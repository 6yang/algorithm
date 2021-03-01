package nowcoder;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-26
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

// 合并区间
public class NC_37_merge {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval resEnd = res.get(res.size() - 1);
            if (res.size() == 0 || curr.start > resEnd.end) {
                res.add(intervals.get(i));
            } else if (curr.end > resEnd.end) {
                resEnd.end = curr.end;
            }
        }
        return res;
    }
}
