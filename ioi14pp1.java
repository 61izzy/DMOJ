import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = 0, c = 0, arr[][] = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 1) {
                    arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                    if (arr[i][j] > m) {
                        m = arr[i][j];
                        c = 1;
                    }
                    else if (arr[i][j] == m) c++;
                }
            }
        }
        System.out.println(m * c);
    }
}
