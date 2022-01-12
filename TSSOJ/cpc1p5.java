import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int q = Integer.parseInt(br.readLine());
        long[] count = new long[1000001], sum = new long[1000001];
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
            if (op == 1) {
                update(count, t, 1);
                update(sum, t, t);
            }
            else if (op == 2) {
                System.out.println(query(count, t));
            }
            else {
                System.out.println(query(sum, t));
            }
        }
    }
    public static void update(long[] tree, int x, int v) {
        for (int i = x; i < tree.length; i += i & -i) {
            tree[i] += v;
        }
    }
    public static long query(long[] tree, int x) {
        long res = 0;
        for (int i = x; i > 0; i -= i & -i) {
            res += tree[i];
        }
        return res;
    }
}
