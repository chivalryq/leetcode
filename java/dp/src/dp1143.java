public class dp1143 {
    public static void main(String[] args) {
        String s="abcde";
        String t="ace";
        System.out.println(new Solution1143().longestCommonSubsequence(s, t));
    }
}

class Solution1143 {
    int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = maxOfThree(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = maxOfThree(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}