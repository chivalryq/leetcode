import java.util.*;

public class lc354 {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        System.out.println(new Solution().maxEnvelopes(envelopes));
    }
}

class Solution {
    boolean canPut(int[] a, int[] b) {
        return a[0] < b[0] && a[1] < b[1];
    }

    public int maxEnvelopes(int[][] envelopes) {
        ArrayList<int[]> envs = new ArrayList<>(Arrays.asList(envelopes));
        envs.sort((o1, o2) -> {
            if (o1[0] == o2[0] && o1[1] == o2[1]) {
                return 0;
            }
            if (o1[0] != o2[0]) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                return 1;
            }
            if (o1[1] < o2[1]) {
                return -1;
            }
            return 1;

        });
        System.out.println(envs);
        TreeMap<Integer, ArrayList<Integer>> dp = new TreeMap<>(Comparator.reverseOrder());// how many env, index
        dp.put(1, new ArrayList<>());
        dp.get(1).add(0);
        for (int i = 1; i < envs.size(); i++) {
            boolean set = false;

            for (Map.Entry<Integer, ArrayList<Integer>> entry : dp.entrySet()) {
                ArrayList<Integer> list = entry.getValue();
                for (Integer index : list) {
                    if (this.canPut(envs.get(index), envs.get(i))) {
                        if (!dp.containsKey(entry.getKey() + 1)) {
                            dp.put(entry.getKey() + 1, new ArrayList<>());
                        }
                        dp.get(entry.getKey() + 1).add(i);
                        set = true;
                        break;
                    }
                }
                if (set) break;
            }
            if(!set){
                dp.get(1).add(i);
            }
        }
        return dp.firstKey();
    }
}