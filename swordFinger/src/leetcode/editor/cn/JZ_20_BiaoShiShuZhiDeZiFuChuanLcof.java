package leetcode.editor.cn;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 112 👎 0


//Java：表示数值的字符串
public class JZ_20_BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new JZ_20_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        // TO TEST
        solution.isNumber("0");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int index = 0;
        public boolean isNumber(String s) {
            if(s==null || s.length() == 0) return false;
            s += '|';
            while(s.charAt(index)==' ') index++;
            boolean isNumeric = scanInteger(s);
            //如果出现’.‘ 接下来就是小数部分
            if(s.charAt(index)=='.'){
                index++;
                // 下面一行代码用||的原因：
                // 1. 小数可以没有整数部分，例如.123等于0.123；
                // 2. 小数点后面可以没有数字，例如233.等于233.0；
                // 3. 当然小数点前面和后面可以有数字，例如233.666
                isNumeric = scanUnsignInteger(s)||isNumeric;
            }
            // 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
            if(s.charAt(index)=='e'||s.charAt(index)=='E'){
                index++;
                // 下面一行代码用&&的原因：
                // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
                // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
                isNumeric = isNumeric && scanInteger(s);
            }
            while(s.charAt(index)==' '){
                index++;
            }
            return isNumeric && s.charAt(index)=='|';
        }

        private boolean scanInteger(String s) {
            if(s.charAt(index)=='-' || s.charAt(index)=='+'){
                index++;
            }
            return scanUnsignInteger(s);
        }

        private boolean scanUnsignInteger(String s) {
            int befor = index;
            while(s.charAt(index)>='0'&&s.charAt(index)<='9'){
                index++;
            }
            return index>befor;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}