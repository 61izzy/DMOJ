import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        String vowels = "aeiou", word;
        String[] s = new String[4], line;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                line = scanner.nextLine().toLowerCase().split(" ");
                word = line[line.length - 1];
                for (int c = word.length() - 1; c >= 0; c--) {
                    if (c > 0 && vowels.indexOf(word.charAt(c)) != -1) {
                        s[j] = word.substring(c, word.length());
                        break;
                    }
                    if (c == 0) {
                        s[j] = word;
                    }
                }
            }
            if (s[0].equals(s[1]) && s[1].equals(s[2]) && s[2].equals(s[3])) {
                System.out.println("perfect");
            }
            else if (s[0].equals(s[1]) && s[2].equals(s[3])) {
                System.out.println("even");
            }
            else if (s[0].equals(s[2]) && s[1].equals(s[3])) {
                System.out.println("cross");
            }
            else if (s[0].equals(s[3]) && s[1].equals(s[2])) {
                System.out.println("shell");
            }
            else {
                System.out.println("free");
            }
        }
    }
}
