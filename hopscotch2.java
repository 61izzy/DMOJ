import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), ida[] = new int[n + 1], idtree[] = new int[2 * k];
        long dist = 0, tree[] = new long[2 * k];
        Arrays.fill(tree, Long.MAX_VALUE);
        
        for (int i = k; i > 0; i /= 2) {
            tree[i] = 0;
            idtree[i] = -1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dist = Long.parseLong(st.nextToken()) + tree[1];
            ida[i] = idtree[1];
            int j = (i + 1)%k + k;
            tree[j] = dist;
            idtree[j] = i;
            for (j /= 2; j > 0; j /= 2) {
                if (tree[2 * j] < tree[2 * j + 1]) {
                    tree[j] = tree[2 * j];
                    idtree[j] = idtree[2 * j];
                }
                else if (tree[2 * j] >= tree[2 * j + 1]) {
                    tree[j] = tree[2 * j + 1];
                    idtree[j] = idtree[2 * j + 1];
                }
            }
        }
        dist = tree[1];
        int idx = ida[n] = idtree[1];

        System.out.println(dist);
        Stack<Integer> out = new Stack<Integer>();
        while (idx > -1) {
            out.push(idx);
            idx = ida[idx];
        }
        while (!out.isEmpty()) System.out.print(out.pop() + 1 + " ");
    }
}
