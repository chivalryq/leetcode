import java.util.Stack;

public class s1047 {
}

class Solution1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.empty()) {
                stack.push(S.charAt(i));
                continue;
            }
            if (stack.peek() == S.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(S.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}