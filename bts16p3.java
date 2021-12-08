import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long sum = 1, len = 1;
        String[] names = new String[n];
        
        names[0] = scanner.next().toLowerCase();
        for (int i = 1; i < n; i++) {
            names[i] = scanner.next().toLowerCase();
            if (names[i].charAt(0) == names[i - 1].charAt(0)) {
                len++;
                sum = (sum + len)%1000000007;
            }
            else {
                len = 1;
                sum++;
            }
        }
        
        System.out.println(sum%1000000007);
    }
}
