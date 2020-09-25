package leetcode.editor.cn;

import java.util.Stack;

public class JZ_31_validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int item : pushed) {
            pushed[i] = item;
            while(i>=0 && pushed[i] == popped[j]){
                j++;
                i--;
            }
            i++;
        }
        return i==0;
    }

    public boolean validateStackSequences_case1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int item : pushed) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
