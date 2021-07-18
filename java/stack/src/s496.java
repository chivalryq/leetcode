import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class s496 {
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] greaterNums = nextGreaterElements(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greaterNums[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
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
