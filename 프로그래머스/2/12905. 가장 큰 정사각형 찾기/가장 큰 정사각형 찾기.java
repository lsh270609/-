class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) board[i][j] = 1;
                    else board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }
}