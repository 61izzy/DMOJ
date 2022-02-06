import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[n];
        long c = 0;
        
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        
        for (int i = 1; i < n; i++) c += arr[0] + arr[i];
        
        System.out.println(c);
    }
}
