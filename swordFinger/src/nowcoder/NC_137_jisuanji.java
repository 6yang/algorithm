package nowcoder;

import java.util.Stack;

/**
 * @author liuyang29 <liuyang29@kuaishou.com>
 * Created on 2021-01-26
 */
public class NC_137_jisuanji {
    public int solve(String s) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int num = 0, sum = 0;
        char sign = '+'; // 默认第一个为+
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '(') {
                int j = i + 1;
                int countPar = 1;
                while (countPar > 0) {
                    if (arr[j] == '(') {
                        countPar++;
                    }
                    if (arr[j] == ')') {
                        countPar--;
                    }
                    j++;
                }
                num = solve(s.substring(i + 1, j - 1));
                i = j - 1; //for 后面还有一个i++
            }
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(c - '0');
                } else if (sign == '-') {
                    stack.push(-1 * num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
