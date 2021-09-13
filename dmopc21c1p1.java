import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), x;
        long duke = 0, alice = 0;
        
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            if (x%2 == 0) {
                duke += x/2;
            }
            else {
                alice += x/2 + 1;
            }
        }
        
        System.out.println(duke > alice ? "Duke" : "Alice");
    }
}
