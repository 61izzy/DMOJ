import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt(), n = scanner.nextInt(), count = 2;
        
        while (m >= n) {
            int temp = m - n;
            m = n;
            n = temp;
            count++;
        }
        
        System.out.println(count);
    }
}
