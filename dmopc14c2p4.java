import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), q;
        int[] arr = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt() + arr[i - 1];
        }
        
        q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt() + 1;
            System.out.println(arr[r] - arr[l]);
        }
    }
}
