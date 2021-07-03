import java.util.*;

public class h451 {
}
class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue() - o1.getValue()));

        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character, Integer> t:list){
            for (int i = 0; i < t.getValue(); i++) {
                sb.append(t.getKey());
            }
        }
        return sb.toString();
    }
}