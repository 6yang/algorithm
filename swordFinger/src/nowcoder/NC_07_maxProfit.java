package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-01-27
 */
public class NC_07_maxProfit {
    public int maxProfit (int[] prices) {
        // write code here
        if(prices == null || prices.length<2){
            return 0;
        }
        int profit = 0 , minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(price,minPrice);
            profit = Math.max(profit,price-minPrice);
        }
        return profit;
    }
}
