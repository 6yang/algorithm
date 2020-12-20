package nowcoder;

import java.util.Stack;

public class NC_52_isValid {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c =='(' || c== '[' || c=='{'){
                stack.push(c);
            }else {
                char get = stack.isEmpty()?'#':stack.pop();
                if(c==')'){
                    if(get!='(') return false;
                }
                if(c==']'){
                    if(get!='[') return false;
                }
                if(c=='}'){
                    if(get!='{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
