class Solution {
    public int answer = 0;
    
    public int solution(int storey) {
        int num1 = 0, num2 = 0;

        while (storey > 0) {
            int pos = (int) Math.log10(storey);
            if (pos > 1) {
                int pow = (int) Math.pow(10, pos);
                if (storey % pow == 0) {
                    num1 = storey / pow;
                    storey = round(storey, num1, 0, pow);
                    continue;
                }
            }
            
            num1 = storey % 10;
            num2 = (storey / 10) % 10;
            storey = round(storey, num1, num2, 10);
        }

        return answer;
    }
    
    public int round(int storey, int num1, int num2, int pow) {
        if (num1 == 5) {
            if (num2 < 5) {
                answer += num1;    
            } else {
                answer += num1;
                storey += pow;
            }
        } else if (num1 < 5) {
            answer += num1;    
        } else {
            answer += 10 - num1;
            storey += pow;
        }
        storey /= pow;
        return storey;
    }
}