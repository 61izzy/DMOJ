import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Edge[] edges;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        n = scanner.nextInt();
        m = scanner.nextInt();
        edges = new Edge[m];
        
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), w = scanner.nextInt();
            edges[i] = new Edge(x, y, w);
        }
        
        System.out.println(getDist(1, n));
    }
    public static int getDist(int from, int to) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[from] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.dist) {
                    dist[e.to] = dist[e.from] + e.dist;
                }
            }
        }
    
        return dist[to];
    }
}

class Edge {
    int from, to, dist;
    public Edge(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}
