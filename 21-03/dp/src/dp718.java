public class dp718 {
    public static void main(String[] args) {
        int[] A=new int[]{1,0,3};
        int[] B=new int[]{1,2,3,0,1,0,3};
        System.out.println(new Solution718().findLength(A,B));
    }
}

class Solution718 {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        //dp[i][j]为A[i-1]和B[j-1]为结尾的最长重复子串长度
        int[][] dp = new int[A.length + 1][B.length + 1];
        //其中一个是空，那只能是0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                //dp[i][j]
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans= Math.max(dp[i][j],ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
