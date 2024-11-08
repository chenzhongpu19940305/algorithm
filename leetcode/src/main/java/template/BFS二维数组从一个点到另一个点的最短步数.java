package template;

import java.util.LinkedList;
import java.util.Queue;

public class BFS二维数组从一个点到另一个点的最短步数 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int endX = grid.length - 1;
        int endY = grid[0].length - 1;
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, -1, 0, 1};
        int row = grid.length;
        int col = grid[0].length;
        if(grid[startX][startY] == 1 || grid[endX][endY] == 1){
            return -1;
        }
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == endX && y == endY) {
                    return steps;
                }
                for (int k = 0; k < 8; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
