package nowcoder;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-02-23
 */
public class NC_86_findElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if(mat[i][j]<x){
                i++;
            }else if(mat[i][j]>x){
                j--;
            }else {
                break;
            }
        }
        return new int[]{i,j};
    }
}
