import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.next();
        int k = scanner.nextInt();
        String[] arr = new String[s.length() - k + 1];
        
        for (int i = 0; i <= s.length() - k; i++) {
            arr[i] = s.substring(i, i + k);
        }
        
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
