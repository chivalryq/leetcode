import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() == 0) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        char a;
        char minCh = sb.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            a = sb.charAt(i);
            if (a < minCh) {
                minCh = a;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == minCh) continue;
            else {
                int littleChIndex = -1;
                char thisCh = sb.charAt(i);
                for (int j = i; j < sb.length(); j++) {
                    if (littleChIndex == -1 && sb.charAt(j) < thisCh) {
                        littleChIndex = j;
                        continue;
                    }
                    if(littleChIndex==-1){
                        continue;
                    }
                    if (sb.charAt(j) < sb.charAt(littleChIndex)) {
                        littleChIndex = j;
                    }
                }
                if (littleChIndex == -1) {
                    continue;
                } else {
                    //found minest char after thisCh
                    sb.setCharAt(i, sb.charAt(littleChIndex));
                    sb.setCharAt(littleChIndex, thisCh);
                    System.out.println(sb.toString());
                    return;
                }

            }
        }
    }
}
