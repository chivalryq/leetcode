import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s46 {
    public static void main(String[] args) {

    }
}

class Solution46 {
    List<List<Integer>> ans = new LinkedList<>();

    void dfs(ArrayList<Integer> per, ArrayList<Integer> num) {
        if (num.size() == 0) {
            ans.add(new LinkedList<>(per));
            return;
        }
        ArrayList<Integer> remain = new ArrayList<>(num);
        for (int x : num) {
            remain.remove(Integer.valueOf(x));
            per.add(x);

            dfs(per, remain);

            per.remove(Integer.valueOf(x));
            remain.add(x);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int n : nums) {
            num.add(n);
        }
        dfs(new ArrayList<Integer>(), num);
        return ans;
    }
}
