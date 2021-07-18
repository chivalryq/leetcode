import java.util.Arrays;
import java.util.HashSet;

public class g200 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution200().numIslands(grid));

    }
}

class Solution200 {
    int[][][] fa;
    int m, n;

    int[] find(int x, int y) {
        int[] f = fa[x][y];
        if (f[0] == x && f[1] == y) return new int[]{x, y};
        else {
            return find(f[0], f[1]);
        }
    }

    void union(int px, int py, int qx, int qy) {
        int[] pf = find(px, py);
        int[] qf = find(qx, qy);
        fa[pf[0]][pf[1]] = new int[]{qf[0], qf[1]};
    }

    boolean check(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        fa = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fa[i][j] = new int[]{i, j};
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (check(i - 1, j) && grid[i - 1][j] == '1') {
                        union(i, j, i - 1, j);
                    }
                    if (check(i + 1, j) && grid[i + 1][j] == '1') {
                        union(i, j, i + 1, j);
                    }
                    if (check(i, j - 1) && grid[i][j - 1] == '1') {
                        union(i, j, i, j - 1);
                    }
                    if (check(i, j + 1) && grid[i][j + 1] == '1') {
                        union(i, j, i, j + 1);
                    }
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int[] f=find(i,j);
                    String s = Arrays.toString(f);
                    set.add(s);
                }

            }
        }
        return set.size();
    }
}