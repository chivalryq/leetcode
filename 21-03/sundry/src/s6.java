public class s6 {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows=4;
        System.out.println(new Solution().convert(s,numRows));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int interval = 2 * numRows - 2;
        for (int i = start; i < s.length(); i += interval) {
            builder.append(s.charAt(i));
        }
        while (start < numRows - 2) {
            start++;
            int upInterval = 2 * start;
            int downInterval = 2 * numRows - 2 * start - 2;
            int i = start;
            while (i < s.length()) {
                builder.append(s.charAt(i));
                i += downInterval;
                if (i >= s.length()) break;
                builder.append(s.charAt(i));
                i += upInterval;
            }
        }
        for (int i = numRows - 1; i < s.length(); i += interval) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
