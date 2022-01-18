import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        if (n < 5) System.out.println(n == 1 ? 1 : -1);
        else {
            for (int i = 1; i <= n; i += 2) {
                if (i == 5) continue;
                System.out.print(i + " ");
            }
            System.out.print("5 4");
            for (int i = n/2 * 2; i > 0; i -= 2) {
                if (i == 4) continue;
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}
