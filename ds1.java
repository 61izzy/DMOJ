import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), arr[] = new int[n + 1];
        long[] count = new long[100001], sum = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            update(sum, i, arr[i]);
            update(count, arr[i], 1);
        }
        
        for (int i = 0; i < m; i++) {
            char q = scanner.next().charAt(0);
            if (q == 'C') {
                int x = scanner.nextInt(), v = scanner.nextInt();
                update(sum, x, v - arr[x]);
                update(count, arr[x], -1);
                update(count, v, 1);
                arr[x] = v;
            }
            else if (q == 'S') {
                int l = scanner.nextInt(), r = scanner.nextInt();
                System.out.println(getSum(sum, r) - getSum(sum, l - 1));
            }
            else {
                int v = scanner.nextInt();
                System.out.println(getSum(count, v));
            }
        }
    }
    public static void update(long[] tree, int x, int v) {
        for (int i = x; i < tree.length; i += i & -i) {
            tree[i] += v;
        }
    }
    public static long getSum(long[] tree, int x) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }
}
