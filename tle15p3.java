import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), charCount = 0, line = 0;
        int[] c = new int[n];
        ArrayList<Character> arr = new ArrayList<Character>();
        
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        scanner.nextLine();

        String[] l = scanner.nextLine().split(" ");

        for (String s : l) {
            if (charCount > 0) {
                if (charCount + s.length() + 1 <= c[line%n]) {
                    arr.add(' ');
                    for (int i = 0; i < s.length(); i++) {
                        arr.add(s.charAt(i));
                    }
                    charCount += s.length() + 1;
                }
                else {
                    arr.add('\n');
                    line++;
                    charCount = 0;
                }
            }
            if (charCount == 0) {
                for (int i = 0; i < s.length(); i++) {
                    arr.add(s.charAt(i));
                    charCount++;
                    if (charCount == c[line%n]) {
                        arr.add('\n');
                        line++;
                        charCount = 0;
                    }
                }
            }
        }
        
        arr.forEach((e) -> System.out.print(e));
    }
}
