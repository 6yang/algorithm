package nowcoder;


// leetcode 9
public class NC_56_isPalindrome {
    public boolean isPalindrome(int x) {
        // write code here
        // 负数不是  如果是10的倍数一定不是
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        // 比较一半的数字  ，一定不会溢出
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 考虑奇偶情况
        return rev == x || rev/10 == x;
    }
}
