import java.util.*;

class Solution {
    public static String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        boolean flag = true;
        int number = 0;
        int orderCnt = 0;
        p -= 1;
        
        while (flag) {
            Stack<String> stack = conv(n, number);
            while(!stack.isEmpty()) {
                String tmp = stack.pop();
                if(orderCnt % m == p) {
                    answer += tmp;
                }
                if (answer.length() == t) {
                    flag = false;
                    break;
                }
                orderCnt++;
            }
            number++;
        }
        return answer;
    }

    public Stack<String> conv(int n, int number) {
        Stack<String> stack = new Stack<>();
        do {
            stack.push(num[number % n]);
            number /= n;
        } while (number > 0);
        
        return stack;
    }
}