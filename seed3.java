import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), j = scanner.nextInt();
        int[] arr = new int[n + 2];
        
        for (int i = 0; i < j; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
            arr[l] += x;
            arr[r + 1] -= x;
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] < m) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
