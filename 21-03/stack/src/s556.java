import java.util.*;

public class s556 {
    public static void main(String[] args) {
        int n = 1999999999;
        System.out.println(new Solution556().nextGreaterElement(n));
    }
}


class Solution556 {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new LinkedList<>();
        while (n != 0) {
            int k = n % 10;
            n = n / 10;
            nums.add(k);
        }
        Stack<Integer> ascendDigits = new Stack<>();
        int firstDescend = -1;
        int dscI = -1;
        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            if (ascendDigits.empty()) {
                ascendDigits.push(k);
                continue;
            }
            if (ascendDigits.peek() <= k) {
                ascendDigits.push(k);
                continue;
            }
            firstDescend = k;
            dscI = i;
            break;
        }
        //n is biggest in all combination
        if (firstDescend == -1) {
            return -1;
        }
        int next = Integer.MAX_VALUE;
        ArrayList<Integer> needPermutation = new ArrayList<>();
        for (int i = 0; i <= dscI; i++) {
            int k = nums.get(i);
            needPermutation.add(k);
            if (k > firstDescend && k < next) {
                next = k;
            }
        }
        needPermutation.remove(Integer.valueOf(next));
        needPermutation.sort(Integer::compareTo);
        nums.set(dscI, next);
        if (dscI > 0) {
            nums.subList(0, dscI).clear();
        }
        for (int digit : needPermutation) {
            nums.add(0, digit);
        }
        int ans = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && nums.get(i) > Integer.MAX_VALUE % 10) {
                ans = -1;
                break;
            }
            ans = ans * 10 + nums.get(i);

        }
        return ans;
    }
}