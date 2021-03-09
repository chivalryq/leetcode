import java.util.Arrays;
import java.util.Stack;

public class s503 {
}

//单调栈
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for (int i = 0; i < 2 * nums.length; i++) {
            if (s.empty()) {
                s.push(i % nums.length);
                continue;
            }
            while (!s.empty() && nums[i % nums.length] > nums[s.peek()]) {
                ans[s.pop()] = nums[i % nums.length];
            }
            s.push(i % nums.length);
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MIN_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}