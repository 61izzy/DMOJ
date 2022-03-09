import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), x = scanner.nextInt();
        if (n%2 != x%2) System.out.println(-1);
        else {
            for (int i = n; i > 0; i--) {
                if (i == n || x > 0) {
                    System.out.print(i == n ? 0 : " " + 0);
                    x--;
                }
                else System.out.print(" " + i%2);
            }
            System.out.println();
        }
    }
}
