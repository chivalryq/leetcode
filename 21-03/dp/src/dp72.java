public class dp72 {
    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("a", "b"));
    }
}

class Solution72 {
    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}