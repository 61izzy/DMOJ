import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        dist[1] = 1;

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        int x = scanner.nextInt(), y = scanner.nextInt();
        while (x != 0 && y != 0) {
            adj[x].add(y);
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        
        for (int i = 1; i < n; i++) {
            for (int j : adj[i]) {
                dist[j] += dist[i];
            }
        }
        
        System.out.println(dist[n]);
    }
}
