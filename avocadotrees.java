import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken()), arr[] = new int[n + 1], max = 0;
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if (a > h) {
                b = 0;
            }
            arr[i] = arr[i - 1] + b;
        }
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[r] - arr[l]);
        }
        
        System.out.println(max);
    }
}
