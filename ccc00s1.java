import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt(), count = 0;
        int[] s = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        
        while (q > 0) {
            for (int i = 0; i < 3; i++) {
                if (q > 0) {
                    q--;
                    s[i]++;
                    if (s[0] == 35) {
                        q += 30;
                        s[0] = 0;
                    }
                    if (s[1] == 100) {
                        q += 60;
                        s[1] = 0;
                    }
                    if (s[2] == 10) {
                        q += 9;
                        s[2] = 0;
                    }
                    count++;
                }
            }
        }
        
        System.out.println("Martha plays " + count + " times before going broke.");
    }
}
