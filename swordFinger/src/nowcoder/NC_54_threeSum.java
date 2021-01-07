package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2020-12-02
 */
public class NC_54_threeSum {
    /*
    * 1. 先对num数组进行排序
    * 2. 然后拿num[i]作为固定  num[i+1] 为左边L num[len-1]为右边R
    * 3. 如果num[i]> 0 最小的数字大于0  break;
    * 4. 如果 num[i] = num[i+1] 去重跳过 contine;
    * 5. 当sum == 0 ，nums[L] == nums[L+1] 结果重复跳过
    * 6. 当sum == 0 ，nums[R] == nums[R--] 结果重复跳过
    * */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num == null || num.length<3) return res;
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len; i++) {
            if(num[i]>0) break;
            if(i>0 && num[i] == num[i-1]) continue;
            int l = i+1;
            int r = len-1;
            while(l<r){
                int sum = num[i]+num[l]+num[r];
                if(sum==0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[l]);
                    temp.add(num[r]);
                    res.add(temp);
                    while(l<r && num[l] == num[l+1]) l++;
                    while(l<r && num[r] == num[r-1]) r--;
                    l++;
                    r--;
                }else if (sum<0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;


    }
}
