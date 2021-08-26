import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), temp;
        int[] t = new int[n];
        boolean sorted = false;
        
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i == 0 ? t[i] : " " + t[i]);
        }
        System.out.println();
        
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (t[i] > t[i + 1]) {
                    temp = t[i];
                    t[i] = t[i + 1];
                    t[i + 1] = temp;
                    for (int x = 0; x < n; x++) {
                        System.out.print(x == 0 ? t[x] : " " + t[x]);
                    }
                    System.out.println();
                    sorted = false;
                }
            }
        }
    }
}
