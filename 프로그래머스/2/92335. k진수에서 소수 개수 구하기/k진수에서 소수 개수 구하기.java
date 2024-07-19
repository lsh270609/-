import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.add(n % k);
            n /= k;
        }
        long prime = 0;
        while(!stack.empty()) {
            int tmp = stack.pop();
            if(tmp == 0) {
                answer += primeCheck(prime / 10);
                prime = 0;
            } else {
                prime = (prime + tmp) * 10;
            }
        }
        answer += primeCheck(prime / 10);
        
        return answer;
    }


    public int primeCheck(long n) {
        if(n < 2) return 0;
        else {
            for(int i = 2; i <= (int) Math.sqrt(n); i++) {
                if(n % i == 0) return 0;
            }    
        }
        return 1;
    }
}