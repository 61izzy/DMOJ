import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt();
        long[] a = new long[n], b = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
        for (int i = 0; i < n; i++) b[i] = scanner.nextLong();
        Arrays.sort(a);
        Arrays.sort(b);

        if (a[n - 1] < b[n - 1]) {
            k -= b[n - 1] - a[n - 1];
            a[n - 1] += b[n - 1] - a[n - 1];
            if (k < 0) a[n - 1] += k;
        }
        else {
            k -= a[n - 1] - b[n - 1];
            b[n - 1] += a[n - 1] - b[n - 1];
            if (k < 0) b[n - 1] += k;
        }
        k = Math.max(k, 0);
        a[n - 1] += k/2;
        b[n - 1] += k/2 + k%2;

        for (int i = 0; i < n; i++) {
            sum += a[i] * b[i];
            sum %= 1000000007;
        }
        System.out.println(sum);
    }
}
