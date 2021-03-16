import java.util.*;

public class g827 {
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
    }
}

class Solution827 {
    int m, n;
    int[][] map;
    int islandIndex;
    HashMap<Integer, Integer> area;

    boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    int mark(int x, int y) {
        if (!check(x, y)) return 0;
        if (map[x][y] != 1) return 0;
        //mark
        map[x][y] = islandIndex;
        int area = 1;
        return area
                + mark(x + 1, y)
                + mark(x - 1, y)
                + mark(x, y + 1)
                + mark(x, y - 1);
    }

    int maxValue(int x, int y) {
        //always have 1 block
        int ret = 1;
        int[][] walk = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };
        Set<Integer> indexs = new HashSet<>();

        for (int[] w : walk) {
            int newx = x + w[0];
            int newy = y + w[1];
            if (check(newx, newy) && map[newx][newy] > 1) {
                indexs.add(map[newx][newy]);
            }
        }
        for (int index : indexs) {
            ret += area.get(index);
        }
        return ret;
    }

    public int largestIsland(int[][] grid) {
        map = grid;
        m = grid.length;
        n = grid[0].length;
        islandIndex = 2;
        area = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int a = mark(i, j);
                    area.put(islandIndex, a);
                    islandIndex++;
                }
            }
        }
        List<Integer> areas = new ArrayList<>(area.values());
        if (areas.size() == 0) return 1;
        Collections.sort(areas);
        int ans = areas.get(areas.size() - 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    //sea grid
                    ans = Math.max(maxValue(i, j), ans);
                }
            }
        }
        return ans;
    }
}