import java.io.*;
import java.util.*;

public class Main {
    static long[][][] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine()), arr[][][] = new int[n + 1][n + 1][n + 1];
        long sum = 0;
        tree = new long[n + 1][n + 1][n + 1];
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("C")) {
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
                update(x, y, z, l - arr[x][y][z]);
                arr[x][y][z] = l;
            }
            else {
                int x1 = Integer.parseInt(st.nextToken()) - 1, y1 = Integer.parseInt(st.nextToken()) - 1, z1 = Integer.parseInt(st.nextToken()) - 1, x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()), z2 = Integer.parseInt(st.nextToken());
                sum += query(x2, y2, z2) - query(x1, y2, z2) - query(x2, y1, z2) - query(x2, y2, z1) - query(x1, y1, z1) + query(x2, y1, z1) + query(x1, y2, z1) + query(x1, y1, z2);
            }
        }
        
        System.out.println(sum);
    }
    public static void update(int x, int y, int z, int v) {
        for (int i = x; i <= n; i += i & -i) {
            for (int j = y; j <= n; j += j & -j) {
                for (int k = z; k <= n; k += k & -k) {
                    tree[i][j][k] += v;
                }
            }
        }
    }
    public static long query(int x, int y, int z) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                for (int k = z; k > 0; k -= k & -k) {
                    sum += tree[i][j][k];
                }
            }
        }
        return sum;
    }
}
