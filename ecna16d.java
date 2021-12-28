import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt();
        HashMap<String, ArrayList<Pair>> adj = new HashMap<String, ArrayList<Pair>>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>(), thing = new HashMap<String, Integer>();
        dist.put("English", 0);
        thing.put("English", 0);
        adj.put("English", new ArrayList<Pair>());
        
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            dist.put(s, Integer.MAX_VALUE);
            thing.put(s, Integer.MAX_VALUE);
            adj.put(s, new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            String l1 = scanner.next(), l2 = scanner.next();
            int cost = scanner.nextInt();
            adj.get(l1).add(new Pair(l2, cost));
            adj.get(l2).add(new Pair(l1, cost));
        }

        Queue<String> q = new LinkedList<String>();
        q.offer("English");

        while (!q.isEmpty()) {
            String curr = q.poll();
            for (Pair p : adj.get(curr)) {
                if (thing.get(curr) + 1 <= thing.get(p.key)) {
                    thing.replace(p.key, thing.get(curr) + 1);
                    if (dist.get(p.key) > p.cost) {
                        dist.replace(p.key, p.cost);
                        q.offer(p.key);
                    }
                }
            }
        }

        int sum = 0;
        boolean bool = true;
        
        for (String s : dist.keySet()) {
            if (dist.get(s) == Integer.MAX_VALUE) bool = false;
            else sum += dist.get(s);
        }

        System.out.println(bool ? sum : "Impossible");
    }
}

class Pair {
    String key;
    int cost;
    public Pair(String key, int cost) {
        this.key = key;
        this.cost = cost;
    }
}
