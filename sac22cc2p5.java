import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()), arr[] = new int[n + 1];
        long[] tree1 = new long[n + 1], tree2 = new long[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if (i%2 == 1) update(i, x, tree1);
            else update(i, x, tree2);
        }
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (idx%2 == 1) update(idx, x - arr[idx], tree1);
                else update(idx, x - arr[idx], tree2);
                arr[idx] = x;
            }
            else {
                int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken());
                if (l%2 == 1) System.out.println(query(r, tree2) - query(l, tree2));
                else System.out.println(query(r, tree1) - query(l, tree1));
            }
        }
    }
    public static void update(int x, int v, long[] tree) {
        for (int i = x; i < tree.length; i += i & -i) {
            tree[i] += v;
        }
    }
    public static long query(int x, long[] tree) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }
}
