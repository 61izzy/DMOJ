import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long sum = 1, len = 1;
        String prev = scanner.next(), curr;
        
        for (int i = 1; i < n; i++) {
            curr = scanner.next();
            if (curr.charAt(0) == prev.charAt(0)) {
                len++;
                sum += len;
            }
            else {
                len = 1;
                sum++;
            }
            prev = curr;
        }
        
        System.out.println(sum%1000000007);
    }
}
