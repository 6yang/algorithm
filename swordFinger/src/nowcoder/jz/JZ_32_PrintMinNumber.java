package nowcoder.jz;

import java.util.Arrays;

public class JZ_32_PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length ==0 ) return "";
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs,(o1,o2)->(o1+o2).compareTo(o2+o1));
        if ("0".equals(strs[0])) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(strs[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        try {
            String s = "https://kim-robot.kwaitalk.com/api/robot/send?keyb22aa251-2d98-44c2-acc6-98c5e27b7192";
            String substring = s.substring(s.lastIndexOf('=')+1);
            System.out.println(substring);
            String[] split = s.split("=");
            System.out.println(split[1]);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
