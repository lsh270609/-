class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x, y;
        int a = 2;
        int b = 4 - brown;
        int c = 2 * yellow;
        
        int sqrt = (int) Math.sqrt((Math.pow(b, 2) - 4 * a * c));
        if (-b > sqrt) {
            y = (-b - sqrt) / (2 * a);
        } else {
            y = (-b + sqrt) / (2 * a);
        }
        x = (int) (yellow / y);
        
        answer[0] = x + 2;
        answer[1] = y + 2;
        return answer;
    }
}