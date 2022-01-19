import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(), n = scanner.nextInt(), m = scanner.nextInt(), g = scanner.nextInt(), c = 0;
        ArrayList<Edge>[] adj = new ArrayList[n + 1];
        int[] arr = new int[g];
        
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < g; i++) {
            arr[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), l = scanner.nextInt();
            adj[a].add(new Edge(b, l));
        }

        int[] dist = new int[n + 1];
        boolean[] inq = new boolean[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, (a, b) -> dist[a] - dist[b]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        inq[0] = true;
        pq.offer(0);
        
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            inq[curr] = false;
            for (Edge e : adj[curr]) {
                if (dist[curr] + e.dist < dist[e.to]) {
                    dist[e.to] = dist[curr] + e.dist;
                    if (!inq[e.to]) {
                        pq.offer(e.to);
                        inq[e.to] = true;
                    }
                }
            }
        }
        
        for (int i : arr) {
            if (dist[i] <= t) c++;
        }
        
        System.out.println(c);
    }
}

class Edge {
    int to, dist;
    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}
