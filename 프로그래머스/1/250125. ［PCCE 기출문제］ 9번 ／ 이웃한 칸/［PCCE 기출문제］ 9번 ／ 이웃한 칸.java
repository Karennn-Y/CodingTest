class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        int[] xDir = {0, 1, -1, 0}; 
        int[] yDir = {1, 0, 0, -1};
        
        for(int i = 0; i < 4; i++) {
            int x = h + xDir[i];
            int y = w + yDir[i];
            
            if(x >= 0 && x < n && y >= 0 && y < n) {
                if(board[h][w].equals(board[x][y])) {
                    count ++;
                }
            }
        }
        return count;
    }
}