import java.util.*;

public class Main {
    static int[] fa;

    static int find(int x) {
        if (fa[x] == x) {
            return x;
        } else {
            fa[x]=find(fa[x]);
            return fa[x];
        }
    }

    static void union(int x, int y) {
        int xfa = find(x);
        int yfa = find(y);
        fa[xfa] = yfa;
    }


    static boolean check(Set<int[]> path, int n) {
        for (int[] p : path) {
            union(p[0], p[1]);
        }
        int home = find(0);
        for (int i = 0; i < n; i++) {
            if (find(i) != home) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        for (int i = 0; i < times; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            fa = new int[n];
            for (int j = 0; j < n; j++) {
                fa[j] = j;
            }
            List<int[]> path = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                int pt1 = in.nextInt()-1;
                int pt2 = in.nextInt()-1;
                path.add(new int[]{pt1, pt2});
            }
            boolean allTrue = true;
            Set<int[]> pathAfterCut = new HashSet<>(path);
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    fa[k] = k;
                }
                int[] cutPath = path.get(j);
                pathAfterCut.remove(cutPath);
                if (!check(pathAfterCut,n)) {
                    System.out.println("No");
                    allTrue = false;
                    break;
                }
                pathAfterCut.add(cutPath);
            }
            if (allTrue) {
                System.out.println("Yes");
            }
        }

    }
}
