import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        System.out.println((5 + Math.sqrt(25 - 48 * (-m + 1 - 0.000001)))/24.0);
    }
}
