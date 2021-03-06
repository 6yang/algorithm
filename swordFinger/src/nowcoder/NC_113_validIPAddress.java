package nowcoder;

public class NC_113_validIPAddress {
    public static void main(String[] args) {
        NC_113_validIPAddress test = new NC_113_validIPAddress();
        test.solve("2001:0db8:85a3:0:0:8A2E:0370:7334");
    }
    // 思路：分开处理  IPV4 和 IPV6

    public String solve (String IP) {
        // write code here
        if(IP.chars().filter(c -> c=='.').count()==3) {
            return validIPv4(IP);
        }else if(IP.chars().filter(c-> c ==':').count()==7){
            return validIPv6(IP);
        }else{
            return "Neither";
        }
    }

    private String validIPv6(String ip) {
        String[] nums = ip.split("\\:", -1);
        String check = "0123456789abcdefABCDEF";
        for (String num : nums) {
            if(num.length()==0 || num.length()>4) return "Neither";
            for (int i = 0; i < num.length(); i++) {
                if(check.indexOf(num.charAt(i))==-1) return "Neither";
            }
        }
        return "IPv6";
    }

    private String validIPv4(String ip) {
        String[] nums = ip.split("\\.", -1);
        for (String num : nums) {
            //位数书否小于3
            if(num.length()==0||num.length()>3) return "Neither";
            // 以0开头
            if(num.length()!=1 && num.charAt(0)=='0') return "Neither";
            // only 数字
            for (int i = 0; i < num.length(); i++) {
                if(!Character.isDigit(num.charAt(i))) return "Neither";
            }
            // 是否在255之内
            if(Integer.parseInt(num)>255) return "Neither";
        }
        return "IPv4";
    }


}
