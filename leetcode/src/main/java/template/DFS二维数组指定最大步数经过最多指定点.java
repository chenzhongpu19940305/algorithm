package template;

public class DFS二维数组指定最大步数经过最多指定点 {
    public static int max = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 0},
                {0, 2, 1, 2},
                {0, 0, 0, 2},
                {1, 0, 2, 0}
        };
        int startX = 0, startY = 0;
        int endX = 3, endY = 3;
        int k = 80;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, startX, startY, endX, endY, k, 0, 0, visited);
        System.out.println("Maximum number of 2s: " + max);
    }

    private static void dfs(int[][] grid, int x, int y, int endX, int endY, int stepsRemaining, int countTwos, int stepsTaken, boolean[][] visite) {
        if (!isValidMove(grid, x, y, visite)) {
            return;
        }
        if(grid[x][y] == 2) {
            countTwos++;
        }
        if (x == endY && y == endY) {
            if (stepsRemaining >= stepsTaken) {
                max = Math.max(countTwos, max);
            }
            return;
        }
        if (stepsRemaining < stepsTaken) {
            return;
        }

        visite[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(grid, newX, newY, endX, endY, stepsRemaining, countTwos, stepsTaken + 1, visite);
        }
        // 这里决定一条路径上不是否能经过重复的点
        visite[x][y] = false;
    }

    private static boolean isValidMove(int[][] grid, int x, int y, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 1 && !visited[x][y];
    }
}
