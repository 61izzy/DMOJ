import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), dist = 0, tree[] = new int[2 * d];
        Arrays.fill(tree, Integer.MAX_VALUE);
        tree[1] = 0;

        for (int i = 0; i < n; i++) {
            dist = Integer.parseInt(br.readLine()) + tree[1];
            int idx = i%d + d;
            tree[idx] = dist;
            for (idx /= 2; idx > 0; idx /= 2) {
                tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
            }
        }

        System.out.println(dist);
    }
}
