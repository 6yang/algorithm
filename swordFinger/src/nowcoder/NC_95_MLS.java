package nowcoder;

import java.util.HashMap;
import java.util.Map;

// leetcode 128
public class NC_95_MLS {

    public int MLS (int[] arr) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            if(!map.containsKey(num)){
                int left = map.get(num-1) == null ? 0: map.get(num-1);
                int right = map.get(num+1) == null ? 0: map.get(num+1);
                int cur = left + 1 + right;
                if (cur > res) {
                    res = cur;
                }
                map.put(num,1); // put的值可以为任何数 ，仅仅代表这个值在map中而已
                map.put(num-left,cur);
                map.put(num+right,cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String ps = "[ 1号 流水线 运行 开始]\n\n"
                + "> 流水线编号\t: 112233\n"
                + "> 发起人 \t: 刘洋\n"
                + "> 开始时间\t: 2020-10-11\n\n"
                + "点击-[链接](www.kuaioshou.com/kflow/detail/1111222?breadname=333&productName=%csdadas)-查看流水线运行详情";
        System.out.println(ps);
    }
}
