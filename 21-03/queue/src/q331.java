import java.util.LinkedList;
import java.util.Queue;

public class q331 {
    public static void main(String[] args) {
        System.out.println(new Solution331().isValidSerialization("1,#,#"));
    }
}

class Solution331 {
    int index = 0;
    boolean isRight = true;

    void verify(String[] symbols) {
        if (!isRight) {
            return;
        }
        if (index == symbols.length) {
            isRight = false;
            return;
        }
        if (!symbols[index].equals("#")) {
            index++;
            verify(symbols);
            verify(symbols);
        } else {
            index++;
        }
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) return false;
        if (preorder.charAt(0) == '#' && preorder.length() > 1) {
            return false;
        }
        String[] symbols = preorder.split(",");
        verify(symbols);
        if (!isRight) return false;
        return index == symbols.length;
    }
}