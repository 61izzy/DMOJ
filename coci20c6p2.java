import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), q;
        HashMap<String, ArrayList<Pair>> adj = new HashMap<String, ArrayList<Pair>>();
        HashMap<String, Long> dist = new HashMap<String, Long>();
        
        for (int i = 0; i < m; i++) {
            String a = scanner.next(), b = scanner.next();
            long t = scanner.nextLong();
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<Pair>());
                dist.put(a, Long.MAX_VALUE);
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<Pair>());
                dist.put(b, Long.MAX_VALUE);
            }
            adj.get(a).add(new Pair(b, t));
        }
        
        q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            String a = scanner.next(), b = scanner.next();
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, (s, t) -> s.cost.compareTo(t.cost));
            for (String s : dist.keySet()) dist.replace(s, Long.MAX_VALUE);
            dist.replace(a, Long.valueOf(0));
            pq.offer(new Pair(a, 0));
            
            while (!pq.isEmpty()) {
                Pair curr = pq.poll();
                for (Pair p : adj.get(curr.key)) {
                    if (dist.get(curr.key) + p.cost < dist.get(p.key)) {
                        dist.replace(p.key, dist.get(curr.key) + p.cost);
                        pq.offer(new Pair(p.key, dist.get(p.key)));
                    }
                }
            }
            
            System.out.println(dist.get(b) == Long.MAX_VALUE ? "Roger" : dist.get(b));
        }
    }
}

class Pair {
    String key;
    Long cost;
    public Pair(String key, long cost) {
        this.key = key;
        this.cost = cost;
    }
}
