import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Edge>[] adj;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new ArrayList[n + 1];
    
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Edge>();
        }
        
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), w = scanner.nextInt();
            adj[x].add(new Edge(y, w));
            adj[y].add(new Edge(x, w));
        }
        
        for (int i = 1; i <= n; i++) {
            int dist = getDist(1, i);
            System.out.println(dist == Integer.MAX_VALUE ? -1 : dist);
        }
    }
    public static int getDist(int from, int to) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(n,(a,b) -> a.value - b.value);
        q.offer(new Pair(from, 0));
        while (!q.isEmpty()) {
            int curr = q.poll().key;
            for (Edge v : adj[curr]) {
                if (dist[v.to] > dist[curr] + v.dist) {
                    dist[v.to] = dist[curr] + v.dist;
                    q.offer(new Pair(v.to, dist[v.to]));
                }
            }
        }
    
        return dist[to];
    }
}

class Edge {
    int to, dist;
    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

class Pair {
    int key, value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
