import java.util.*;

public class pa131 {
    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }
}


class Solution131 {
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

    Stack<String> path;

    List<List<String>> partis;
    boolean[][] isPalindrome;

    void dfs(int pos, String s) {
        if (pos == s.length()) {
            partis.add(new ArrayList<>(path));
        }
        for (int end = pos; end < s.length(); end++) {
            if (isPalindrome[pos][end]) {
                path.push(s.substring(pos, end + 1));
                dfs(end + 1, s);
                path.pop();
            }
        }

    }

    public List<List<String>> partition(String s) {
        path = new Stack<>();
        isPalindrome = getIsPalindrome(s);
        partis = new LinkedList<>();
        dfs(0, s);
        return partis;
    }
}