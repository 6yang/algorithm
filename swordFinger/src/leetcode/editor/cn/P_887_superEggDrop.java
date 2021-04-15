package leetcode.editor.cn;

public class P_887_superEggDrop {
    public int superEggDrop(int K, int N) {
        return recursive(K, N);
    }

    private int recursive(int K, int N) {
        if (K == 1 || N == 0 || N == 1) {
            return N;
        }
        int minNum = N;
        for (int i = 1; i <= N; i++) {
            int tMin = Math.max(recursive(K-1,i-1),recursive(K,N-i));
            minNum = Math.min(minNum,tMin+1);
        }
        return minNum;
    }
}
