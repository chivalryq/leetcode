import java.util.*;

public class s32 {
    public static void main(String[] args) {
        String s="(()";
        System.out.println(new Solution32().longestValidParentheses(s));
    }
}

class Solution32 {
    public int longestValidParentheses(String s) {

        Stack<Integer> index=new Stack<>();
        Stack<Character> characterStack=new Stack<>();
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(index.empty()){
                index.push(i);
                characterStack.push(ch);
                continue;
            }
            if(ch==')'&&characterStack.peek()=='('){
                list.add(index.pop());
                list.add(i);
                characterStack.pop();
                continue;
            }
            index.push(i);
            characterStack.push(ch);
        }
        list.sort(Integer::compareTo);
        int ans=0;
        List<Integer> interval=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(list.size()<=i){
                list.add(i,i);
                interval.add(i);
                continue;
            }
            if(list.get(i)!=i){
                list.add(i,i);
                interval.add(i);
            }
        }
        if(interval.isEmpty()){
            return s.length();
        }
        ans=interval.get(0);
        int i=1;
        while(i<interval.size()){
            int val=interval.get(i)-interval.get(i-1)-1;
            ans=Math.max(val,ans);
            i++;
        }
        int val=s.length()-1-interval.get(interval.size()-1);
        ans=Math.max(val,ans);
        return ans;
    }
}