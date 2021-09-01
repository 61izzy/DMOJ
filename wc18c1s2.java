import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int w = scanner.nextInt();
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        for (int i = 0; i < w; i++) {
            if (i == 0) {
                System.out.print(c[i]);
            }
            else if (i < 26) {
                System.out.print(" " + c[i]);
            }
            else if (i < 702) {
                System.out.print(" " + c[(i - 26)/26] + c[i%26]);
            }
            else {
                System.out.print(" " + c[(i - 702)/676] + c[(i - 702)/26%26] + c[i%26]);
            }
        }
    }
}
