import java.util.*;
import java.io.*;

public class Main {
    static int[] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tree = new int[2 * n];

        for (int i = 0; i < n; i++) {
            tree[n + i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'M') {
                int x = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                update(x, v);
            }
            else {
                int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()) + 1;
                System.out.println(query(l, r));
            }
        }
    }
    public static void update(int x, int v) {
        x += n;
        tree[x] = v;
        for (int i = x/2; i > 0; i /= 2) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }
    public static int query(int l, int r) {
        int min = Integer.MAX_VALUE;
        for (l += n, r += n; l < r; l /= 2, r /= 2) {
            if (l%2 == 1) min = Math.min(min, tree[l++]);
            if (r%2 == 1) min = Math.min(min, tree[--r]);
        }
        return min;
    }
}
