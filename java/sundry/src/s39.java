import java.util.LinkedList;
import java.util.List;

public class s39 {
}

class Solution39 {
    List<List<Integer>> ans=new LinkedList<>();
    int[] can;
    void dfs(List<Integer> com,int target,int index){
        if(target==0){
            ans.add(new LinkedList<>(com));
            return;
        }
        if(index==can.length){
            return;
        }
        //不用这个index的情形
        dfs(com,target,index+1);
        //用这个index
        if(target-can[index]>=0){
            com.add(can[index]);
            dfs(com,target-can[index],index);
            com.remove(Integer.valueOf(can[index]));
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        can=candidates;
        dfs(new LinkedList<Integer>(),target,0);
        return ans;
    }
}
