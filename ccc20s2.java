import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static ArrayList<Integer>[] adj = new ArrayList[1000001];
    static boolean[] vis = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                adj[i * j].add(x);
            }
        }
        dfs(1);
        System.out.println(vis[m * n] ? "yes" : "no");
    }
    public static void dfs(int x) {
        vis[x] = true;
        if (x == m * n) {
            return;
        }
        for (int v : adj[x]) {
            if (!vis[v]) {
                dfs(v);
            }
            if (vis[m * n]) {
                return;
            }
        }
    }
}
