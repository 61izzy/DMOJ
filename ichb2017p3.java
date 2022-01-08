import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        int q = scanner.nextInt();
        tree = new long[2 * n];
        
        for (int i = 0; i < n; i++) {
            tree[n + i] = scanner.nextLong();
        }
        
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] & tree[2 * i + 1];
        }
        
        for (int i = 0; i < q; i++) {
            char op = scanner.next().charAt(0);
            if (op == 'U') {
                int x = scanner.nextInt() - 1;
                long v = scanner.nextLong();
                update(x, v);
            }
            else {
                int x = scanner.nextInt() - 1, y = scanner.nextInt();
                long v = scanner.nextLong();
                System.out.println(query(x, y, v));
            }
        }
    }
    public static void update(int x, long v) {
        x += n;
        tree[x] = v;
        for (int i = x/2; i > 0; i /= 2) {
            tree[i] = tree[2 * i] & tree[2 * i + 1];
        }
    }
    public static long query(int x, int y, long v) {
        long res = v;
        for (x += n, y += n; x < y; x /= 2, y /= 2) {
            if (x%2 == 1) res &= tree[x++];
            if (y%2 == 1) res &= tree[--y];
        }
        return res;
    }
}
