import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), max = 0;
        int[][] tri = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tri[i][j] = scanner.nextInt() + Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
                max = Math.max(max, tri[i][j]);
            }
        }
        
        System.out.println(max);
    }
}
