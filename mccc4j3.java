import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[n + 1], idx = -1;
        
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt() + arr[i - 1];
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == arr[n] - arr[i]) idx = i;
        }
        
        System.out.println(idx == -1 ? "Andrew is sad." : idx);
    }
}
