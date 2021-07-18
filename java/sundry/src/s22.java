import java.util.LinkedList;
import java.util.List;

public class s22 {
}

class Solution22 {
    List<String> ans = new LinkedList<>();

    void generateAns(String now, int left, int right) {
        if (right == 0) {
            ans.add(now);
            return;
        }
        if (left != 0) {
            generateAns(now + "(", left - 1, right);
        }
        if (left < right) {
            generateAns(now + ")", left, right - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generateAns("", n, n);
        return ans;
    }
}
