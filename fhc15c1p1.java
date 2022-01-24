import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int MAXN = 10000001;
        int t = scanner.nextInt(), sieve[] = new int[MAXN];
        
        for (int i = 2; i < MAXN; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j < MAXN; j += i) {
                    sieve[j]++;
                }
            }
        }
        
        for (int i = 1; i <= t; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), k = scanner.nextInt(), c = 0;
            for (int j = a; j <= b; j++) {
                if (sieve[j] == k) {
                    c++;
                }
            }
            System.out.printf("Case #%d: %d\n", i, c);
        }
    }
}
