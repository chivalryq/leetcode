public class d115 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new Solution115().numDistinct(s, t));
    }
}

class Solution115 {
    int slen, tlen;
    String s, t;


    public int numDistinct(String s, String t) {
        slen = s.length();
        tlen = t.length();
        this.s = s;
        this.t = t;
        int[][] dp = new int[slen + 1][tlen + 1];
//        dp[i][j] 表示s的前i个匹配t的前j个有多少方法
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= tlen; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[slen][tlen];
    }
}