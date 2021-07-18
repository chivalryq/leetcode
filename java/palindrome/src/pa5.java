import java.util.Arrays;

public class pa5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution5().longestPalindrome(s));

    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = getIsPalindrome(s);
        String ans = "";
        for (int i = 0; i < isPalindrome.length; i++) {
            for (int j = i; j < isPalindrome[0].length; j++) {
                //s[i..j]
                int len = j - i + 1;
                if (isPalindrome[i][j] && len > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (boolean[] a : isPalindrome) {
            Arrays.fill(a, false);
        }
        //注意先循环右边界
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
}
