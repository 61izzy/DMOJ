import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s1 = scanner.next().toLowerCase(), s2 = scanner.next().toLowerCase();
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            sum1 += Math.pow((s1.charAt(i) - 'a' + 1)%10, i%4 + 1);
        }
        sum1 %= 10;
        if (sum1 == 0) sum1 = 10;
        
        for (int i = 0; i < s2.length(); i++) {
            sum2 += Math.pow((s2.charAt(i) - 'a' + 1)%10, i%4 + 1);
        }
        sum2 %= 10;
        if (sum2 == 0) sum2 = 10;
        
        System.out.println(sum1 + sum2);
    }
}
