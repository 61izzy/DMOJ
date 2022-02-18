import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), k = scanner.nextInt(), c = 0;
        String s = scanner.next();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') len++;
            else {
                if (len > 0) arr.add(len);
                len = 0;
            }
        }
        if (len > 0) arr.add(len);
        Collections.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < k && i < arr.size(); i++) {
            c += arr.get(i);
        }
        System.out.println(c);
    }
}
