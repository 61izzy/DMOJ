import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int i = scanner.nextInt();
        double mark = 0;
        
        for (int n = 0; n < i; n++) {
            mark += scanner.nextDouble();
        }
        
        int s = scanner.nextInt();
        
        for (int n = 1; n <= s; n++) {
            mark += scanner.nextInt();
            System.out.println(String.format("%.3f", mark/(i + n)));
        }
    }
}
