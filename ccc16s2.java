import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt(), n = scanner.nextInt(), sum = 0;
        int[] dmoj = new int[n], peg = new int[n];
        
        for (int i = 0; i < n; i++) {
            dmoj[i] = scanner.nextInt();
        }
        Arrays.sort(dmoj);
        
        for (int i = 0; i < n; i++) {
            peg[i] = scanner.nextInt();
        }
        Arrays.sort(peg);
        
        if (q == 1) {
            for (int i = 0; i < n; i++) {
                sum += Math.max(dmoj[i], peg[i]);
            }
        }
        else {
            for (int i = n - 1; i >= Math.ceil(n/2.0); i--) {
                sum += Math.max(dmoj[i], peg[n - i - 1]) + Math.max(peg[i], dmoj[n - i - 1]);
            }
            if (n%2 == 1) {
                sum += Math.max(dmoj[n/2], peg[n/2]);
            }
        }
        
        System.out.println(sum);
    }
}
