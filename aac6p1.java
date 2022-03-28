import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), k = scanner.nextInt();
        for (int i = 1, j = 1000000000/k * k - 1; n > 1; i++, j--) {
            System.out.printf("%d %d", i, j);
            n -= 2;
            if (n >= 1) System.out.print(" ");
        }
        if (n == 1) System.out.print(1000000000/k * k);
        System.out.println();
    }
}
