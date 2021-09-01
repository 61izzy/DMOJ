import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int k = scanner.nextInt(), max = 0;
        String s = scanner.next();
        int[] arr = new int[26];
        char most = ' ';

        for (int j = 0; j < k; j++) {
            arr[s.charAt(j) - 'a']++;
            if (arr[s.charAt(j) - 'a'] > max || arr[s.charAt(j) - 'a'] == max && s.charAt(j) < most) {
                max = arr[s.charAt(j) - 'a'];
                most = s.charAt(j);
            }
        }
        
        System.out.print(s.substring(0, k));

        for (int i = k; i < s.length(); i++) {
            if (i > k) {
                if (s.charAt(i - k - 1) != s.charAt(i - 1)) {
                    arr[s.charAt(i - k - 1) - 'a']--;
                    arr[s.charAt(i - 1) - 'a']++;
                    most = getChar(arr);
                }
            }

            System.out.print((char)(s.charAt(i) + (most - 'a') + 1 <= 'z' ? s.charAt(i) + (most - 'a' + 1) : s.charAt(i) + (most - 'a' + 1) - 26));
        }
    }
    public static char getChar(int[] arr) {
        int max = 0;
        char most = ' ';

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0 && arr[i] > max) {
                max = arr[i];
                most = (char)(i + 'a');
            }
        }

        return most;
    }
}
