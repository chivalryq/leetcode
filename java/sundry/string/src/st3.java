import java.util.HashSet;


public class st3 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        set.add(s.charAt(left));
        do {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, set.size());
            right++;
        }
        while (right < s.length());
        return ans;
    }
}
