import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class q1 {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
//        q.add(3);
//        q.add(2);
//        q.add(4);
//        while (!q.isEmpty()) {
//
//            System.out.println(q.poll());
//        }
        int[] nums = {2, 5, 3, 1, 5, 6};
        for (int i : nums) {
            q.add(i);
        }
        Object[] nn = q.toArray();
        for (Object n : nn) {
            System.out.println(n);
        }
    }

}
