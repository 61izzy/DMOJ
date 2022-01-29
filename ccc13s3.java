import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(), g = scanner.nextInt(), p[] = new int[5], c = 0;
        boolean[][] ap = new boolean[5][5];
        
        for (int i = 1; i < 5; i++) ap[i][i] = true;
        
        for (int i = 0; i < g; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), sa = scanner.nextInt(), sb = scanner.nextInt();
            ap[a][b] = true;
            if (sa > sb) p[a] += 3;
            else if (sa < sb) p[b] += 3;
            else {
                p[a]++;
                p[b]++;
            }
        }
        
        for (int i = 0; i < (int)Math.pow(3, 6 - g); i++) {
            int gp = 0;
            boolean w = true;
            int[] temp = new int[5];
            for (int j = 1; j < 5; j++) temp[j] = p[j];

            for (int n = 1; n < 5; n++) {
                for (int m = n + 1; m < 5; m++) {
                    if (!ap[n][m]) {
                        int res = i/((int)Math.pow(3, gp))%3;
                        gp++;
                        if (res == 0) temp[n] += 3;
                        else if (res == 1) temp[m] += 3;
                        else {
                            temp[n]++;
                            temp[m]++;
                        }
                    }
                }
            }
            for (int j = 1; j < 5; j++) {
                if (temp[j] >= temp[t] && j != t) w = false;
            }
            if (w) c++;
        }
        
        System.out.println(c);
    }
}
