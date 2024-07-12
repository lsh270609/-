class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        int gcd = 0;
        for(int i = 1; i < arr.length; i++) {
            gcd = gcd(lcm, arr[i]);
            lcm *= arr[i] / gcd;
        }

        return lcm;
    }

    public int gcd(int a, int b) {
        if(a > b) return (a % b == 0) ? b : gcd(b, a % b);
        else return (b % a == 0) ? a : gcd(a, b % a);
    }
}