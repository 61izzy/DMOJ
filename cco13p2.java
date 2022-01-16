import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = 1 << Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] tree = new int[2 * n], arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            tree[i + n] = i;
        }
        
        for (int i = n - 1; i > 0; i--) tree[i] = arr[tree[2 * i]] > arr[tree[2 * i + 1]] ? tree[2 * i] : tree[2 * i + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'R') {
                int x = Integer.parseInt(st.nextToken()) - 1, s = Integer.parseInt(st.nextToken());
                arr[x] = s;
                tree[x + n] = x;
                for (int j = (x + n)/2; j > 0; j /= 2) tree[j] = arr[tree[2 * j]] > arr[tree[2 * j + 1]] ? tree[2 * j] : tree[2 * j + 1];
            }
            else if (op == 'W') {
                System.out.println(tree[1] + 1);
            }
            else {
                int x = Integer.parseInt(st.nextToken()) - 1, r = 0;
                for (int j = (x + n)/2; j > 0 && tree[j] == x; j /= 2) r++;
                System.out.println(r);
            }
        }
    }
}
