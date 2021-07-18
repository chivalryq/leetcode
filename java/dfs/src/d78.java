import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class d78 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.remove(1);
    }
}

class Solution78 {
    int[] nums;
    List<Integer> list;
    List<List<Integer>> ans = new LinkedList<>();

    void dfs(int index) {
        if (index == nums.length) {
            ans.add(new LinkedList<>(list));
            return;
        }
        dfs(index + 1);
        list.add(nums[index]);
        dfs(index + 1);
        list.remove(new Integer(nums[index]));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        list = new LinkedList<>();
        dfs(0);
        return ans;
    }
}
