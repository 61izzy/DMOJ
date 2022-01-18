import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        if (n < 3) System.out.println(n == 1 ? 1 : -1);
        else {
            System.out.print("1 3 2");
            for (int i = 4; i <= n; i++) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}
