import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int n = s.length(), arr[][] = new int[26][n + 1], q = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') arr[s.charAt(i) - 'a'][i + 1]++;
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1, r = scanner.nextInt(), c = scanner.next().charAt(0) - 'a';
            System.out.println(arr[c][r] - arr[c][l]);
        }
    }
}
