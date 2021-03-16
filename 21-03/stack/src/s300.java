import java.util.Arrays;

public class s300 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        new Solution300().lengthOfLIS(nums);
    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        Arrays.sort(dp);
        return dp[n-1];
    }

}
