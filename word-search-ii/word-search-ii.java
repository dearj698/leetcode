class Solution {
    List<String> res = new ArrayList();
    int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        if(words.length==0) return res;
        for (String word : words) {
            if(dfs(board, word)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(char[][] boards, String word){
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                if(helper(i, j , boards, word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int x, int y ,char[][] boards, String word, int idx ){
        if(word.charAt(idx) != boards[x][y]) return false;
        if(idx == word.length()-1) return true;
        boolean found = false;
        char cur = boards[x][y];
        boards[x][y] = '#';
        for (int[] dir : dirs) {
            int new_x = dir[0]+x;
            int new_y = dir[1]+y;
            if(new_x>=0&&new_y>=0&&new_x<boards.length&&new_y<boards[0].length){
                if(boards[new_x][new_y] == word.charAt(idx+1)){
                     if(helper(new_x, new_y, boards, word, idx+1)){
                         found =  true;
                     }
                }
            }
        }
        boards[x][y] = cur;
        return found;
    }
}