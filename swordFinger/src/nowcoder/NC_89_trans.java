package nowcoder;

public class NC_89_trans {
    public String trans(String s, int n) {
        StringBuilder res = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                tempStr.append(Character.toUpperCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                tempStr.append(Character.toLowerCase(c));
            } else {
                res.insert(0, c + tempStr.toString());
                tempStr = new StringBuilder();
            }
        }
        res.insert(0, tempStr.toString());
        return res.toString();
    }
}
