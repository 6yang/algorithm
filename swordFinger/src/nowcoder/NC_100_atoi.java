package nowcoder;


public class NC_100_atoi {
    public int atoi(String str) {
        // write code here
        if (str == null || str.trim().length() < 1) {
            return 0;
        }
        char[] arr = str.trim().toCharArray();
        int sign = 1;
        int index = 0;
        if (arr[0] == '+') {
            index++;
        } else if (arr[0] == '-') {
            index++;
            sign = -1;
        }
        int num = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if(num>Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && arr[i]-'7'>0){
                    if(sign > 0 ){
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                num = num * 10 + arr[i] - '0';
            } else {
                break;
            }
        }
        return num*sign;
    }
}
