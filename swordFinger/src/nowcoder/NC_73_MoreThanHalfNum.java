package nowcoder;

// 剑指offer 39
public class NC_73_MoreThanHalfNum {
    // 解法   1 hash
    //       2 排序
    //       3 摩尔投票法
    public int MoreThanHalfNum_Solution(int [] array) {
        int x = 0 ,vote = 0 ,count = 0;
        for (int num : array) {
            if(vote == 0) x = num;
            vote += num == x ? 1 : -1;
        }
        for (int num : array) {
            if(num == x) count++;
        }
        return count > array.length/2 ? x : 0;
    }
}
