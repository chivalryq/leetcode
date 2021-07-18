import java.util.Scanner;

public class m {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] aba = new long[10010];
        long[] abc = new long[10010];
        aba[1] = 6;
        abc[1] = 6;
        for (int i = 2; i < 10010; i++) {
            aba[i] = (3 * aba[i - 1] + 2 * abc[i - 1]) % 100000007;
            abc[i] = (2 * aba[i - 1] + 2 * abc[i - 1]) % 100000007;
        }
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int N = in.nextInt();
            System.out.println((abc[N] + aba[N]) % 100000007);
        }
    }
}
