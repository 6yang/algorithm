package nowcoder;

public class NC_103_reserveString {
    public String solve (String str) {
        // write code here
        char[] chars = str.toCharArray();
        int i = 0 ,j =str.length()-1;
        while(i<j){
            char c  = chars[i];
            chars[i++] = chars[j];
            chars[j--] = c;
        }
        return String.valueOf(chars);
    }
}
