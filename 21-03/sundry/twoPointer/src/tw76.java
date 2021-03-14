import java.util.Arrays;

public class tw76 {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(new Solution76().minWindow(s, t));
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] have = new int[128];
        int[] need = new int[128];
        Arrays.fill(have, 0);
        Arrays.fill(need, 0);
        int needNum = t.length();
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) ;
            need[index] += 1;
        }
        //one
        int sPtr = 0;
        while (needNum > 0) {
            int sIndex = s.charAt(sPtr) ;
            if (have[sIndex] < need[sIndex]) {
                needNum--;
            }
            have[sIndex]++;
            sPtr++;
            //not found
            if (sPtr == s.length()&&needNum>0) {
                return "";
            }
        }
        int left = 0;
        int right = sPtr;
        String ans = s.substring(0, right);
        while (right <= s.length()) {
            //extract!
            while (needNum == 0) {
                int lIndex = s.charAt(left) ;
                have[lIndex]--;
                if (have[lIndex] < need[lIndex]) {
                    needNum++;
                }
                left++;
            }
            if (ans.length() > right - left + 1) {
                ans = s.substring(left-1, right);
            }
            if(right==s.length())break;
            while (right < s.length() && needNum > 0) {
                int rIndex = s.charAt(right) ;
                have[rIndex]++;
                if (have[rIndex] == need[rIndex]) {
                    needNum--;
                }
                right++;
            }

        }
        return ans;
    }
}
