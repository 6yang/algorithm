package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class JZ_13_movingCount {
    // bfs
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], mi = x[2], mj = x[3];
            if (i >= m || j >= n || mi + mj > k || visited[i][j]) continue;
            res += 1;
            visited[i][j] = true;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? mi + 1 : mi - 8, mj});
            queue.add(new int[]{i, j + 1, mi, (j + 1) % 10 != 0 ? mj + 1 : mj - 8});
        }
        return res;
    }

    // dfs
    int m, n, k;
    boolean[][] visited;

    public int movingCount_dfs(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int mi, int mj) {
        if (i >= this.m || j >= this.n || mi + mj > k || visited[i][j]) return 0;
        visited[i][j] = true;
        // 1.当x或者y从n9进位成(n+1)0时，数位和减小了8
        //    设进位后数的数位和为n，差值为x，得出方程n=(n-1)+9+x，即x=-8
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? mi + 1 : mi - 8, mj) +
                dfs(i, j, mi, (j + 1) % 10 != 0 ? mj + 1 : mj - 8);
    }
}
