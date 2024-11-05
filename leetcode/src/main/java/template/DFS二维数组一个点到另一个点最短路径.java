package template;

import java.util.ArrayList;
import java.util.List;

public class DFS二维数组一个点到另一个点最短路径 {
    public static int[] dx ={1,0,-1,0};
    public static int[] dy ={0,1,0,-1};
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0}
        };
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, 0, 1, 2, 3, visited, result, current);
        System.out.println(result);
    }

    public static void dfs(int[][] grid, int x1, int y1, int x2, int y2, boolean[][] visited, List<List<Integer>> result, List<Integer> current) {
        int row = grid.length;
        int col = grid[0].length;
        if (x1 < 0 || y1 < 0 || x1 >= row || y1 >= col || grid[x1][y1] == 1 || visited[x1][y1]) {
            return;
        }
        if (x1 == x2 && y1 == y2) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        visited[x1][y1] = true;
        current.add(grid[x1][y1]);
        for (int i = 0; i < 4; i++) {
            int newX = x1 + dx[i];
            int newY = y1 + dy[i];
            dfs(grid, newX, newY, x2, y2, visited, result, current);
        }
        visited[x1][y1] = false;
        current.remove(current.size() - 1);
    }
}
