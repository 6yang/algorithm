package nowcoder;

public class NC_32_sqrt {
    public int sqrt (int x) {
        // write code here
        long left = 0;
        long right = x/2+1;
        while(left<right){
            // 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            long mid = (left+right+1) >> 1;
            long square = mid*mid;
            if(square>x){
                right = mid-1;
            }else{
                left  = mid ;
            }
        }
        return (int) left;
    }


}
