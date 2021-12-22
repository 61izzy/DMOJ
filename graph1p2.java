import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] dist = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (scanner.nextInt() == 1) {
                    adj[i].add(j);
                }
            }
        }
        
        q.offer(0);
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : adj[c]) {
                if (dist[i] == 0) {
                    dist[i] = dist[c] + 1;
                    q.offer(i);
                }
            }
            if (dist[n - 1] != 0) break;
        }
        
        System.out.println(dist[n - 1]);
    }
}
