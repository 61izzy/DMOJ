import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int v = scanner.nextInt(), e = scanner.nextInt(), arr[] = new int[v + 1];
        double[] dist = new double[v + 1];
        ArrayList<Pair>[] adj = new ArrayList[v + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<Pair>();
        }
        
        for (int i = 0; i < e; i++) {
            int m = scanner.nextInt(), n = scanner.nextInt();
            double d = scanner.nextDouble()/scanner.nextDouble() * 60;
            adj[m].add(new Pair(n, d));
            adj[n].add(new Pair(m, d));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v, (a, b) -> (int)(a.dist - b.dist));
        pq.offer(new Pair(1, 0));
        arr[1] = 0;
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            int curr = pq.poll().to;
            for (Pair p : adj[curr]) {
                if (dist[p.to] > dist[curr] + p.dist) {
                    dist[p.to] = dist[curr] + p.dist;
                    arr[p.to] = arr[curr] + 1;
                    pq.offer(new Pair(p.to, dist[p.to]));
                }
                else if (dist[p.to] == dist[curr] + p.dist && arr[p.to] > arr[curr] + 1) {
                    arr[p.to] = arr[curr] + 1;
                    pq.offer(new Pair(p.to, dist[p.to]));
                }
            }
        }
        
        System.out.println(arr[v]);
        System.out.println(Math.round(dist[v]/3));
    }
}

class Pair {
    int to;
    double dist;
    public Pair(int to, double dist) {
        this.to = to;
        this.dist = dist;
    }
}
