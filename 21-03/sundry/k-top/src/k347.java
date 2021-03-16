import java.util.*;

public class k347 {
    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1,2},2);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            int times = entry.getValue();
            int num = entry.getKey();
            if (queue.size() < k) queue.offer(new int[]{times, num});
            else {
                if (queue.peek()[0] < times) {
                    queue.poll();
                    queue.offer(new int[]{times, num});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll()[1];
        }
        return ans;
    }
}