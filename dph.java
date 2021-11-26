import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int h = scanner.nextInt(), w = scanner.nextInt();
        String[] grid = new String[h];
        int[][] arr = new int[h + 1][w + 1];
        arr[1][0] = 1;
        
        for (int i = 0; i < h; i++) {
            grid[i] = scanner.next();
        }
        
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (grid[i - 1].charAt(j - 1) != '#') {
                    arr[i][j] = arr[i - 1][j]%1000000007 + arr[i][j - 1]%1000000007;
                }
            }
        }
        
        System.out.println(arr[h][w]%1000000007);
    }
}
