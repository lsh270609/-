import java.util.*;

class Solution {
    public String solution(String p) {
        return Conv(p);
    }
    
    public String Conv(String p) {
        if (p.equals("")) return p;
        int b1 = 0, b2 = 0;
        Character startChar = p.charAt(0);
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == startChar) {
                b1++;
            } else {
                b2++;
                if (b1 == b2) break;
            }
        }
        int idx = b1 + b2;
        if (startChar == '(') {
            String U = p.substring(0, idx);
            String V = Conv(p.substring(idx));
            return new StringBuilder().append(U).append(V).toString();
        } else {
            // String U = p.substring(0, idx + 1);
            StringBuilder sb = new StringBuilder();
            String V = Conv(p.substring(idx));
            sb.append("(").append(V).append(")");
            for (int i = 1; i <= idx - 2; i++) {
                sb.append(p.charAt(i) == '(' ? ")" : "(");
            }
            return sb.toString();
        }
    }
}