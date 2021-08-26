import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int l, u, c;
        
        for (int i = 0; i < 5; i++) {
            c = 0;
            l = scanner.nextInt();
            u = scanner.nextInt();
            for (int n = l; n <= u; n++) {
                if (isPalindrome(String.valueOf(n)) && isPrime(n)) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String n) {
        String f, s = "";
        f = n.substring(0, (int)Math.ceil(n.length()/2.0));
        for (int i = n.length() - 1; i >= n.length()/2; i--) {
            s += n.charAt(i);
        }
        return f.equals(s);
    }
}
