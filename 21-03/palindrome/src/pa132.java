import java.util.*;

public class pa132 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution132().minCut(s));
    }
}

class Solution132 {
    public int minCut(String s) {
        isPalindrome = getIsPalindrome(s);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[0][i]) dp[i] = 0;
                //s[j+1..i]是回文
                if (isPalindrome[j + 1][i] && dp[j] + 1 < dp[i]) dp[i] = dp[j] + 1;
            }
        }
        return dp[s.length() - 1];
    }

    boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (boolean[] a : isPalindrome) {
            Arrays.fill(a, false);
        }

        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (right == left) isPalindrome[left][right] = true;
                else if (right == left + 1) {
                    if (s.charAt(left) == s.charAt(right)) isPalindrome[left][right] = true;
                } else {
                    if (isPalindrome[left + 1][right - 1] && s.charAt(right) == s.charAt(left))
                        isPalindrome[left][right] = true;
                }
            }
        }
        return isPalindrome;
    }

    boolean[][] isPalindrome;


}