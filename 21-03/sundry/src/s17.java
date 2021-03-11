import java.util.*;

public class s17 {
    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        LinkedList<String> ans = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            char[] chars = map.get(ch);
            if (ans.isEmpty()) {
                for (char value : chars) {
                    ans.add(String.valueOf(value));
                }
            } else {
                int qLen = ans.size();
                for (int j = 0; j < qLen; j++) {
                    String s = ans.poll();
                    for (char aChar : chars) {
                        String nextS = s + aChar;
                        ans.add(nextS);
                    }
                }
            }

        }
        return ans;
    }
}