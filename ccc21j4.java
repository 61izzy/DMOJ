import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int n = s.length(), l = 0, m = 0, c = 0;
        int[] lc = new int[2], mc = new int[2], sc = new int[2];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') l++;
            else if (s.charAt(i) == 'M') m++;
        }
        m += l;
        
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'L') lc[0]++;
            else if (s.charAt(i) == 'M') mc[0]++;
        }
        for (int i = l; i < m; i++) {
            if (s.charAt(i) == 'L') lc[1]++;
            else if (s.charAt(i) == 'S') sc[1]++;
        }
        c = l - lc[0] + lc[1] + sc[1] - Math.min(mc[0], lc[1]);

        System.out.println(c);
    }
}
