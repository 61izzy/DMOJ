import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), ans = 0;
        String[] p = new String[1 << m], s = new String[n];
        Arrays.fill(p, "");

        for (int i = p.length; i > 1; i /= 2) {
            for (int j = 0; j < p.length - i + 1; j += i) {
                for (int k = j; k < j + i/2; k++) {
                    p[k] += 'T';
                }
                for (int k = j + i/2; k < j + i; k++) {
                    p[k] += 'F';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        for (String bruh : p) {
            int min = m;
            for (int i = 0; i < n; i++) {
                int lm = m;
                for (int j = 0; j < m; j++) {
                    if (bruh.charAt(j) != s[i].charAt(j)) lm--;
                }
                min = Math.min(min, lm);
            }
            ans = Math.max(min, ans);
        }

        System.out.println(ans);
    }
}
