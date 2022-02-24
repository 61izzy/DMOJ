import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();
        long k = scanner.nextLong();
        long max = ((long)m * (m + 1))/2 + m * ((long)n - m);

        if (k < n || k > max) System.out.println(-1);
        else {
            k--;
            int len = 1, arr[] = new int[n];
            arr[0] = 1;
            System.out.print(1);
            for (int i = 1; i < n; i++) {
                if (k - len + 1 > n - i && arr[i - 1] + 1 <= m) {
                    arr[i] = arr[i - 1] + 1;
                    if (len < m) len++;
                    k -= len;
                }
                else {
                    while (k - len + 2 <= n - i) len--;
                    arr[i] = arr[i - len];
                    k -= len;
                }
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}
