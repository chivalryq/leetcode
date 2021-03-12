import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class s55 {
}

class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> indexs = new LinkedList<>();
        boolean[] can = new boolean[nums.length];
        Arrays.fill(can, false);
        can[0]=true;
        indexs.add(0);
        while (!indexs.isEmpty()) {
            int now = indexs.poll();
            int max = nums[now];

            for (int i = 1; i <= max; i++) {
                if (now + i < can.length && !can[now + i]) {
                    can[now + i] = true;
                    indexs.add(now + i);
                }
            }
        }
        return can[nums.length - 1];
    }
}
