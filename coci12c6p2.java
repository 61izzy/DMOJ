import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[n + 1];
        
        for (int i = 1; i <= n; i++) arr[i] = scanner.nextInt();
        if (n == 2) System.out.printf("%d %d\n", arr[2]/2, arr[2]/2 + arr[2]%2);
        else {
            int x = 0;
            for (int i = 1; i <= 3; i++) x = scanner.nextInt();
            arr[1] = (arr[2] + arr[3] + x)/2 - x;
            arr[2] -= arr[1];
            System.out.printf("%d %d", arr[1], arr[2]);
            for (int i = 3; i <= n; i++) System.out.print(" " + (arr[i] - arr[1]));
            System.out.println();
        }
    }
}
