public class s59 {
    public static void main(String[] args) {
        new Solution59().generateMatrix(3);
    }
}

class Solution59 {
    boolean[][] vis;
    int col_max;
    int row_max;

    boolean valid(int r, int c) {
        return r >= 0 && r < row_max && c >= 0 && c < col_max;
    }

    int[] getNext(int r, int c, int lastStepR, int lastStepC) {
        int[][] walk = new int[][]{
                {lastStepR, lastStepC}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int[] w : walk) {
            if (valid(r + w[0], c + w[1]) && !vis[r + w[0]][c + w[1]]) {
                return w;
            }
        }
        return new int[]{-1, -1};
    }

    public int[][] generateMatrix(int n) {
        vis=new boolean[n][n];
        col_max = n;
        row_max = n;
        int row = 0;
        int col = -1;
        int[][] ans = new int[n][n];
        int lastStepR = 1;
        int lastStepC = 0;
        for (int i = 1; i <= n * n; i++) {
            int[] next = getNext(row, col, lastStepR, lastStepC);
            row = row + next[0];
            col = col + next[1];
            lastStepR = next[0];
            lastStepC = next[1];
            ans[row][col] = i;
            vis[row][col]=true;
        }
        return ans;
    }
}
