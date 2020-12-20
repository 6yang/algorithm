package nowcoder;

import java.util.Stack;

public class NC_76_CQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
         stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
            return -1;
        }
        return stack2.pop();
    }
}
