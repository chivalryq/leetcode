import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class k215 {
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        int ans=0;
        for (int i = 0; i < k; i++) {
            ans=queue.poll();
        }
        return ans;
    }
}