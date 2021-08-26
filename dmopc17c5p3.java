import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] a = new long[n];
        long gcd = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        
        Arrays.sort(a);
        
        for (int i = 1; i < n; i++) {
            gcd = i == 1 ? getGCD(a[1], a[0]) : getGCD(a[i], gcd);
        }
        
        System.out.println(gcd == 1 ? "DNE" : getLargestPrime(gcd));
    }
    public static long getGCD(long n, long d) {
        if (n%d != 0) {
           d = getGCD(d, n%d);
        }
        return d;
    }
    public static long getLargestPrime(long n) {
        long x;
        do {
            x = getPrime(n);
            if (x != n) {
                n /= x;
            }
        }
        while (x != n);
        
        return n;
    }
    public static long getPrime(long n) {
        for (long i = 2; i <= (long)Math.sqrt(n); i++) {
            if (n%i == 0 && isPrime(i)) {
                return i;
            }
        }
        return n;
    }
    public static boolean isPrime(long n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
