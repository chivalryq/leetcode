import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class s40 {
}
//TODO
class Solution40 {
    HashSet<Set<Integer>> ans = new HashSet<>();

    void dfs(HashSet<Integer> com, int target, List<Integer> candis) {
        if (target == 0) {
            ans.add(new HashSet<>(com));
            return;
        }
        List<Integer> remains = new LinkedList<>(candis);
        for (int c :
                candis) {
            if (target - c >= 0) {
                remains.remove(Integer.valueOf(c));
                com.add(c);
                dfs(com, target - c, remains);
                com.remove(c);
                remains.add(c);
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candis = new LinkedList<>();
        for (int c :
                candidates) {
            candis.add(c);
        }
        dfs(new HashSet<>(), target, candis);
        List<List<Integer>> answer=new LinkedList<>();
        for(Set<Integer> set:ans){
            answer.add(new LinkedList<>(set));
        }
        return answer;

    }
}
