package nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NC_126_minCoins {
    public int minMoney(int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim+1);
        dp[0] = 0;
        for (int coin : arr) {
            for (int i = coin; i <= aim; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[aim] == aim+1) {
            dp[aim] = -1;
        }
        return dp[aim];

    }

    public int minMoney_2(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        boolean[] visited = new boolean[aim + 1];
        Queue<Integer> queue = new LinkedList();
        visited[aim] = true;
        queue.offer(aim);
        Arrays.sort(arr);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer head = queue.poll();
                for (int coin : arr) {
                    int next = head - coin;
                    // 只要遇到 0，就找到了一个最短路径
                    if (next == 0) {
                        return step;
                    }
                    // coins 升序排序  所以剪枝后面的
                    if (next < 0) {
                        break;
                    }

                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }


    // 最小硬币数
    public int minMoney_1(int[] arr, int aim) {
        // 给0 占位
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int money = 1; money <= aim; money++) {
            for (int coin : arr) {
                if (money - coin >= 0 && dp[money - coin] != Integer.MAX_VALUE) {
                    dp[money] = Math.min(dp[money], 1 + dp[money - coin]);
                }
            }
        }
        if (dp[aim] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[aim];
    }
}
