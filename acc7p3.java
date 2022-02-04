import java.io.*;
import java.util.*;

public class Main {
    public static int[] id;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), arr[] = new int[n + 1];
        long c = 0;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        id = new int[n + 1];
        Arrays.fill(id, -1);
        
        for (int i = 1; i <= n; i++) arr[i] = scanner.nextInt();
        
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (find(x) != find(y)) union(x, y);
        }
        
        for (int i = 1; i < n; i++) {
            if (find(i) != find(i + 1)) edges.add(new Edge(i, i + 1, arr[i + 1] - arr[i]));
        }
        
        Collections.sort(edges, (a, b) -> a.c - b.c);
        
        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                c += e.c;
                union(e.a, e.b);
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
    int a, b, c;
    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
