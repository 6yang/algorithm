package leetcode.editor.cn;

import java.util.Stack;

public class JZ_08_CQueue {
}

class CQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if(out.empty()){
            if (in.empty()){
                return -1;
            }else{
                while (!in.empty()){
                    out.push(in.pop());
                }
                return out.pop();
            }
        }else{
            return out.pop();
        }
    }
}
