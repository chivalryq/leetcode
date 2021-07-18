import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class t56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Solution56().merge(intervals);
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new LinkedList<>();
        for (int[] itv : intervals) {
            if (list.size() == 0) {
                list.add(itv);
                continue;
            }
            int[] last_itv = list.get(list.size() - 1);
            if (itv[0] <= last_itv[1]) {
                last_itv[1] = Math.max(last_itv[1],itv[1]);
            } else {
                list.add(itv);
            }
        }
        int[][] ans=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
