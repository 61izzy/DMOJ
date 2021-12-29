import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[8];
    static boolean[] vis = new boolean[8];
    static boolean cycle = false;
    static HashSet<Integer> currNodes = new HashSet<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 1; i <= 7; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        adj[1].add(7);
        adj[1].add(4);
        adj[2].add(1);
        adj[3].add(4);
        adj[3].add(5);
        
        int a = scanner.nextInt(), b = scanner.nextInt();
        while (a != 0 && b != 0) {
            adj[a].add(b);
            a = scanner.nextInt();
            b = scanner.nextInt();
        }
        
        for (int i = 7; i >= 1; i--) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        
        if (cycle) System.out.println("Cannot complete these tasks. Going to bed.");
        else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(i == 0 ? list.get(i) : list.get(i) + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int x) {
        for (int i : adj[x]) {
            if (!vis[i]) {
                if (currNodes.contains(i)) {
                    cycle = true;
                    return;
                }
                currNodes.add(i);
                dfs(i);
                if (cycle) return;
                currNodes.remove(i);
            }
        }
    
        vis[x] = true;
        list.add(x);
    }
}
