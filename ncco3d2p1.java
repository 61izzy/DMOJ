import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
        int[] min = new int[2 * n], max = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            min[i + n] = max[i + n] = Integer.parseInt(br.readLine());
        }
        
        for (int i = n - 1; i > 0; i--) {
            min[i] = Math.min(min[2 * i], min[2 * i + 1]);
            max[i] = Math.max(max[2 * i], max[2 * i + 1]);
        }
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1 + n, r = Integer.parseInt(st.nextToken()) + n, lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
            for (; l < r; l /= 2, r /= 2) {
                if (l%2 == 1) {
                    lo = Math.min(lo, min[l]);
                    hi = Math.max(hi, max[l++]);
                }
                if (r%2 == 1) {
                    lo = Math.min(lo, min[r - 1]);
                    hi = Math.max(hi, max[--r]);
                }
            }
            System.out.println(hi - lo);
        }
    }
}
