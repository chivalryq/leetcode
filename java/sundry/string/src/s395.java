import java.util.HashMap;
import java.util.HashSet;

public class s395 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("a", 1));
    }
}

class Solution {
    class Counter {
        private boolean valid;
        HashMap<Character, Integer> cnt;
        HashSet<Character> notEnough;
        int k;

        Counter(int k) {
            cnt = new HashMap<>();
            valid = false;
            notEnough = new HashSet<>();
            this.k = k;
        }

        void append(char ch) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
            if (cnt.get(ch) < k) {
                notEnough.add(ch);
                valid = false;
            }
            if (cnt.get(ch) >= k ) {
                notEnough.remove(ch);
                if (notEnough.isEmpty()) valid = true;
            }
        }

    }

    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int left = 0; left < s.length(); left++) {
            Counter counter = new Counter(k);
            for (int right = left; right < s.length(); right++) {
                counter.append(s.charAt(right));
                if (right - left + 1 < ans) continue;
                if (counter.valid) {
                    ans = right - left + 1;
                }
            }
        }
        return ans;
    }
}
