import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine()), arr[] = new int[n + 1], len = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > arr[len]) arr[++len] = x;
            else if (x < arr[1]) arr[1] = x;
            else {
                int l = 2, r = len;
                while (l < r) {
                    int m = (l + r)/2;
                    if (x > arr[m]) l = m + 1;
                    else r = m;
                }
                arr[l] = x;
            }
        }
        
        System.out.println(len);
    }
}
