import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        String[] arr = new String[n];
        HashMap<String, String> partner = new HashMap<String, String>();
        boolean match = true;
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next().toLowerCase();
        }
        for (int i = 0; i < n; i++) {
            partner.put(arr[i], scanner.next().toLowerCase());
        }
        for (int i = 0; i < n; i++) {
            if (!partner.get(partner.get(arr[i])).equals(arr[i]) || partner.get(arr[i]).equals(arr[i])) {
                match = false;
            }
        }
        System.out.println(match ? "good" : "bad");
    }
}
