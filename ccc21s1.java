import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), sum = 0;
        int[] h = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            h[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt() * (h[i] + h[i + 1]);
        }
        
        System.out.println(sum%2 == 1 ? sum/2 + 0.5 : sum/2);
    }
}
