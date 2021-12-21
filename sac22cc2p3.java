import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Pair>[] adj;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), r = scanner.nextInt();
        adj = new ArrayList[(int)Math.pow(2, n + 1) + 1];
        
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<Pair>();
        }
        
        for (int i = 0; i < (int)Math.pow(2, n) - 1; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt(), d = scanner.nextInt();
            adj[u].add(new Pair(v, d));
            adj[u].add(new Pair(w, 0));
        }
        
        System.out.println(r + dfs(1));
    }
    public static int dfs(int x) {
        if (x >= adj.length || adj[x].size() == 0) return 0;
        return Math.max(dfs(adj[x].get(1).to), adj[x].get(0).dist + dfs(adj[x].get(0).to));
    }
}

class Pair {
    int to, dist;
    public Pair(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}
