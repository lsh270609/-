class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, target, 0);
    }

    public int dfs(int depth, int[] numbers, int target, int sum) {
        if(depth == numbers.length) {
            if(target == sum) return 1;
            else return 0;
        } else {
            return dfs(depth + 1, numbers, target, sum + numbers[depth]) + dfs(depth + 1, numbers, target, sum - numbers[depth]);
        }
    }
}