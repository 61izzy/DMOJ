import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n, t;
        
        for (int i = 0; i < 10; i++) {
            n = scanner.nextInt();
            t = scanner.nextInt();
            System.out.println(n * 2 - 1);
        }
    }
}
