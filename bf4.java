import java.io.*;
import java.util.*;

public class Main {
    static int[] lcp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        String s = scanner.nextLine(), t = scanner.nextLine();
        lcp = buildLCP(t);
        System.out.println(find(s, t));
    }
    public static int find(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
              while (j > 0 && s.charAt(i) != t.charAt(j)) j = lcp[j - 1];
              if (s.charAt(i) == t.charAt(j)) j++;
              if (j == t.length()) return i - j + 1;
        }
        return -1;
    }
    public static int[] buildLCP(String s) {
        int[] lcp = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = lcp[j - 1];
            if (s.charAt(i) == s.charAt(j)) lcp[i] = ++j;
        }
        return lcp;
    }
}
