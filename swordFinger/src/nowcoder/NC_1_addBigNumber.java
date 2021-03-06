package nowcoder;

public class NC_1_addBigNumber {
    public String solve (String s, String t) {
        // write code here
        StringBuilder res = new StringBuilder();
        int i = s.length()-1;
        int j = t.length()-1;
        int count = 0;
        while(i>=0 || j>= 0 || count>0){
            int a = i>=0 ? s.charAt(i--)-'0':0;
            int b = j>=0 ? t.charAt(j--)-'0':0;
            int temp = a+b+count;
            if(temp>=10){
                temp = temp-10;
                count = 1;
            }else {
                count = 0;
            }
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
