import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), start, end, count;
        boolean[] sieve = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) {
            sieve[i] = true;
        }
        for (int i = 2; i * i < 1000001; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < 1000001; j += i) {
                    sieve[j] = false;
                }
            }
        }
        
        for (int t = 0; t < n; t++) {
            count = 0;
            start = scanner.nextInt();
            end = scanner.nextInt();
            for (int i = start; i < end; i++) {
                if (sieve[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
