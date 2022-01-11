class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return false;
        
        for(int i = 0; i< board.length;i++){
            for(int j =0;j< board[0].length;j++){
                if(findWord(i, j ,board,word, 0)){
                    return true;
                }
            }
        }
            
       return false;     
    }
    
    private boolean findWord(int col, int row, char[][] board, String word, int idx){
        if(idx > word.length()-1){
            return true;
        }
        else if(col<0||row<0||col>board.length-1||row>board[0].length-1||board[col][row]!=word.charAt(idx)){
            return false;
        }
        
        char curChar = board[col][row];
        board[col][row] = '#';
        for(int[] dir : dirs){
            int newCol = col+dir[0];
            int newRow = row+dir[1];
            if(findWord(newCol, newRow, board, word, idx+1)){
                return true;
            }
        }
        board[col][row] = curChar;
        return false;
    }
}