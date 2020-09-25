package leetcode.editor.cn;

import java.util.Stack;

public class JZ_30_MinStack {

}

class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> data ;
    Stack<Integer> minData;
    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if(minData.isEmpty()||minData.peek()>=x){
            minData.add(x);
        }
    }

    public void pop() {
        if(data.pop().equals(minData.peek())){
            minData.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }
}
