import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt(), s = scanner.nextInt();
        tree = new int[s + 1][s + 1];
        
        q = scanner.nextInt();
        
        while (q != 3) {
            if (q == 1) {
                int x = scanner.nextInt() + 1, y = scanner.nextInt() + 1, a = scanner.nextInt();
                update(x, y, a);
            }
            else {
                int l = scanner.nextInt(), b = scanner.nextInt(), r = scanner.nextInt() + 1, t = scanner.nextInt() + 1;
                System.out.println(query(r, t) + query(l, b) - query(l, t) - query(r, b));
            }
            q = scanner.nextInt();
        }
    }
    public static void update(int x, int y, int a) {
        for (int i = x; i < tree.length; i += i & -i) {
            for (int j = y; j < tree.length; j += j & -j) {
                tree[i][j] += a;
            }
        }
    }
    public static int query(int r, int c) {
        int sum = 0;
        for (int i = r; i > 0; i -= i & -i) {
            for (int j = c; j > 0; j -= j & -j) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
