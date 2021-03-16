public class g463 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        new Solution463().islandPerimeter(grid);
    }
}

class Solution463 {
    int m, n;
    int[][] map;

    boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    int len(int x, int y) {
        if (!check(x, y)) return 1;
        if (map[x][y] == 0) return 1;
        if (map[x][y] == 2) return 0;
        map[x][y]=2;
        return len(x + 1, y)
                + len(x - 1, y)
                + len(x, y + 1)
                + len(x, y - 1);
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        map = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    return len(i, j);
                }
            }
        }
        return 0;
    }
}
