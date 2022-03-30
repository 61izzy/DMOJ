import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[n], c = 0, m = 0;
        
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] + n >= m) c++;
            m = Math.max(m, arr[i] + n - i);
        }
        
        System.out.println(c);
    }
}
