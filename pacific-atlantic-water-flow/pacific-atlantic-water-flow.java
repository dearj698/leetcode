import java.util.ArrayList;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;//[n][m]

        boolean[][] pVisited = new boolean[n][m];
        boolean[][] aVisited = new boolean[n][m];

        for (int x = 0; x < m; ++x) {
            dfs(heights, x, 0, 0, pVisited);
            dfs(heights, x, n-1, 0, aVisited);
        }

        for(int y =0;y<n;++y){
            dfs(heights, 0, y, 0, pVisited);
            dfs(heights, m-1, y,0,aVisited);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if(pVisited[i][j]&&aVisited[i][j]){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int x, int y, int h, boolean[][] visited){
        if(x==heights[0].length||y==heights.length||x<0||y<0){
            return;
        }
        if(visited[y][x]||heights[y][x]<h) return;
        visited[y][x] = true;

        dfs(heights, x+1,y, heights[y][x],visited);
        dfs(heights, x-1,y, heights[y][x],visited);
        dfs(heights, x,y+1, heights[y][x],visited);
        dfs(heights, x,y-1, heights[y][x],visited);
    }
}
// @lc code=end

