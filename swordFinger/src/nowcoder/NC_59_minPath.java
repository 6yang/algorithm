package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-01
 */
public class NC_59_minPath {
    public int minPathSum(int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            matrix[i][0] += matrix[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            matrix[0][i] += matrix[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += Math.min(matrix[i-1][j],matrix[i][j-1]);
            }
        }
        return matrix[m-1][n-1];
    }
}
