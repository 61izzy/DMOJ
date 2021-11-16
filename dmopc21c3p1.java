import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long w, x, y, z = 0;
        long[] a = new long[n];
        
        for (int i = 0; i < n/2; i++) {
            System.out.println("? " + (i + 1) + " " + (n - i));
            System.out.flush();
            x = scanner.nextLong();

            System.out.println("? " + (i + 1) + " " + (n - i));
            System.out.flush();
            z = scanner.nextLong();

            w = x + z;
            y = w + x;
            a[n - i - 1] = z/2;
            a[i] = y/2;
        }

        if (n%2 != 0) {
            System.out.println("? " + (n/2 + 1) + " " + (n/2 + 2));
            System.out.flush();
            w = scanner.nextLong();
            a[n/2] = z + w;
        }
        
        System.out.print("!");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }
}
