import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        Arrays.sort(a);
        
        for (int x = 0, y = n - 1; x <= n/2 && y >= n/2; x++, y--) {
            if (x == y) {
                System.out.print(x > 0 ? " " + a[x] : a[x]);
            }
            else {
                System.out.print(x > 0 ? " " + a[x] : a[x]);
                System.out.print(" " + a[y]);
            }
        }
        System.out.println();
        for (int i = 0; i < n/2; i++) {
            System.out.print("BS");
        }
        if (n%2 == 1) {
            System.out.print("E");
        }
        System.out.println();
    }
}
