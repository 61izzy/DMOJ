import java.io.*;
import java.util.*;

public class Main {
    public static int[][] tree;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), n = scanner.nextInt(), q = scanner.nextInt(), arr[][] = new int[m + 1][n + 1];
        tree = new int[m + 1][n + 1];
        
        while (q != 0) {
            if (q == 1) {
                int r = scanner.nextInt(), c = scanner.nextInt(), x = scanner.nextInt();
                if (r%2 == c%2) {
                    x = -x;
                }
                update(r, c, x - arr[r][c]);
                arr[r][c] = x;
            }
            else {
                int r1 = scanner.nextInt() - 1, c1 = scanner.nextInt() - 1, r2 = scanner.nextInt(), c2 = scanner.nextInt();
                int total = getSum(r2, c2) - getSum(r2, c1) - getSum(r1, c2) + getSum(r1, c1);
                System.out.println(r1%2 == c1%2 ? -total : total);
            }
            q = scanner.nextInt();
        }
    }
    public static void update(int x, int y, int v) {
        for (int i = x; i < tree.length; i += i & -i) {
            for (int j = y; j < tree[i].length; j += j & -j) {
              tree[i][j] += v;
            }
        }
    }
    public static int getSum(int x, int y) {
        int sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
