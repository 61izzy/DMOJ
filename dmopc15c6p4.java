import java.io.*;
import java.util.*;

public class Main {
    static int[] id;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), k = scanner.nextInt(), c = 0;
        id = new int[n];
        Arrays.fill(id, -1);
        Edge[] edges = new Edge[n - 1];
        
        for (int i = 0; i < n - k; i++) union(i, i + k);
        
        for (int i = 0; i < n - 1; i++) {
            edges[i] = new Edge(i, i + 1, scanner.nextInt());
        }
        Arrays.sort(edges, (a, b) -> a.w - b.w);
        
        for (Edge e : edges) {
            if (id[e.u] == -1 || find(e.u) != find(e.v)) {
                c += e.w;
                union(e.u, e.v);
            }
        }
        
        System.out.println(c);
    }
    public static int find(int x) {
        return id[x] < 0 ? x : (id[x] = find(id[x]));
    }
    public static void union(int x, int y) {
        if (id[x = find(x)] < id[y = find(y)]) {
            id[x] += id[y];
            id[y] = x;
        }
        else {
            id[y] += id[x];
            id[x] = y;
        }
    }
}

class Edge {
    int u, v, w;
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
