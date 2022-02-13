import java.io.*;
import java.util.*;

public class Main {
	  static int[][] adj;
	  static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        adj = new int[n + 1][n + 1];
        ArrayList<Edge>[] arr  = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Edge>();
            int e = scanner.nextInt();
            int[] temp = new int[e];
            for (int j = 0; j < e; j++) {
                temp[j] = scanner.nextInt();
            }
            for (int j = 0; j < e; j++) {
                int w = scanner.nextInt();
                arr[i].add(new Edge(temp[j], temp[(j + 1)%e], w));
            }
        }
        
        Arrays.fill(adj[0], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            for (Edge e : arr[i]) {
                boolean out = true;
                for (int j = 1; j <= n; j++) {
                    if (j == i) continue;
                    for (Edge f : arr[j]) {
                        if (f.i == e.i && f.j == e.j || f.i == e.j && f.j == e.i) {
                            out = false;
                            adj[i][j] = adj[j][i] = Math.min(adj[i][j], e.w);
                        }
                    }
                }
                if (out) {
                    adj[0][i] = Math.min(adj[0][i], e.w);
                }
            }
        }
        
        System.out.println(Math.min(prim(1, n), prim(0, n + 1)));
    }
    public static int prim(int s, int sz) {
        int res = 0;
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(n, (a, b) -> a.w - b.w);
        pq.offer(new Edge(-1, s, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (!vis[curr.j]) {
                vis[curr.j] = true; 
                sz--;
                res += curr.w;
                for (int i = 1; i <= n; i++) {
                    if (!vis[i] && adj[curr.j][i] != Integer.MAX_VALUE) {
                        pq.offer(new Edge(-1, i, adj[curr.j][i]));
                    }
                }
            }
        }
        return sz == 0 ? res : Integer.MAX_VALUE;
    }
}

class Edge {
    int i, j, w;
    public Edge(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }
}
