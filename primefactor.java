import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m, x, count;
        
        for (int i = 0; i < n; i++) {
            count = 0;
            m = scanner.nextInt();
            
            do {
                x = getPrime(m);
                if (x != 1) {
                    System.out.print(count == 0 ? x : " " + x);
                    m /= x;
                    count++;
                }
            }
            while (x != 1);
            
            System.out.println();
        }
    }
    public static int getPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i == 0 && isPrime(i)) {
                return i;
            }
        }
        return n;
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
