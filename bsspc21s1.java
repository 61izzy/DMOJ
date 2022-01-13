import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt();
        char[][] arr = new char[n][m];
        boolean thing = true;
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next().toCharArray();
        }
        
        for (int i = 0; i <= n/2; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != arr[n - i - 1][j]) {
                    if (arr[i][j] == '.') {
                        arr[i][j] = arr[n - i - 1][j];
                    }
                    else if (arr[n - i - 1][j] == '.') {
                        arr[n - i - 1][j] = arr[i][j];
                    }
                    else {
                        thing = false;
                    }
                }
            }
        }
        
        for (int i = 0; i <= m/2; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] != arr[j][m - i - 1]) {
                    if (arr[j][i] == '.') {
                        arr[j][i] = arr[j][m - i - 1];
                    }
                    else if (arr[j][m - i - 1] == '.') {
                        arr[j][m - i - 1] = arr[j][i];
                    }
                    else {
                        thing = false;
                    }
                }
                else if (arr[j][i] == '.' && arr[j][m - i - 1] == '.') {
                    arr[j][i] = arr[j][m - i - 1] = 'a';
                }
            }
        }
        
        if (thing) {
            for (int i = 0; i < n; i++) {
                System.out.println(String.valueOf(arr[i]));
            }
        }
        else {
            System.out.println(-1);
        }
    }
}
