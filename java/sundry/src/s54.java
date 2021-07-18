import java.util.LinkedList;
import java.util.List;

public class s54 {
    public static void main(String[] args) {
        int[][] arg = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(new Solution54().spiralOrder(arg));
    }
}

class Solution54 {
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
            if (valid(r + w[0], c + w[1])&&!vis[r+w[0]][c+w[1]]) {
                return w;
            }
        }
        return new int[]{-1, -1};
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        vis = new boolean[matrix.length][matrix[0].length];
        row_max = matrix.length;
        col_max = matrix[0].length;
        int row = 0;
        int col = 0;
        List<Integer> list = new LinkedList<>();
        list.add(matrix[row][col]);
        vis[0][0] = true;
        int[] next = getNext(row, col, 0, 1);
        while (next[0] != -1||next[1]!=-1) {
            row = row + next[0];
            col = col + next[1];
            list.add(matrix[row][col]);
            vis[row][col] = true;
            next = getNext(row, col, next[0], next[1]);
        }
        return list;
    }
}
