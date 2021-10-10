import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        long p;
        boolean win = false;
        
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(a);
        p = Long.parseLong(br.readLine());
        
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < p) {
                win = true;
                break;
            }
            while (a[i] >= p && k > 0) {
                a[i] = a[i] * (100 - x)/100;
                k--;
            }
            if (a[i] < p && i == 0) {
                win = true;
                break;
            }
            else if (a[i] >= p) {
                break;
            }
        }
        System.out.println(win ? "YES" : "NO");
    }
}
