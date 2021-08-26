import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), tcount = 0, scount = 0;
        String s;
        
        scanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            for (int l = 0; l < s.length(); l++) {
                if (s.toLowerCase().charAt(l) == 't') {
                    tcount++;
                }
                if (s.toLowerCase().charAt(l) == 's') {
                    scount++;
                }
            }
        }
        
        System.out.println(scount >= tcount ? "French" : "English");
    }
}
