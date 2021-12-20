import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[50];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char q = scanner.next().charAt(0);
        
        for (int i = 0; i < 50; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        adj[1].add(6);
        adj[2].add(6);
        adj[3].add(4);
        adj[3].add(5);
        adj[3].add(6);
        adj[3].add(15);
        adj[4].add(3);
        adj[4].add(5);
        adj[4].add(6);
        adj[5].add(3);
        adj[5].add(4);
        adj[5].add(6);
        adj[6].add(1);
        adj[6].add(2);
        adj[6].add(3);
        adj[6].add(4);
        adj[6].add(5);
        adj[6].add(7);
        adj[7].add(6);
        adj[7].add(8);
        adj[8].add(7);
        adj[8].add(9);
        adj[9].add(8);
        adj[9].add(10);
        adj[9].add(12);
        adj[10].add(9);
        adj[10].add(11);
        adj[11].add(10);
        adj[11].add(12);
        adj[12].add(9);
        adj[12].add(11);
        adj[12].add(13);
        adj[13].add(12);
        adj[13].add(14);
        adj[13].add(15);
        adj[14].add(13);
        adj[15].add(3);
        adj[15].add(13);
        adj[16].add(17);
        adj[16].add(18);
        adj[17].add(16);
        adj[17].add(18);
        adj[18].add(16);
        adj[18].add(17);
        
        while (q != 'q') {
            if (q == 'i') {
                int x = scanner.nextInt(), y = scanner.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }
            else if (q == 'd') {
                int x = scanner.nextInt(), y = scanner.nextInt();
                adj[x].remove(adj[x].indexOf(y));
                adj[y].remove(adj[y].indexOf(x));
            }
            else if (q == 'n') {
                int x = scanner.nextInt();
                System.out.println(adj[x].size());
            }
            else if (q == 'f') {
                int x = scanner.nextInt();
                System.out.println(getFriends(x));
            }
            else {
                int x = scanner.nextInt(), y = scanner.nextInt(), res = bfs(x, y);
                System.out.println(res == 0 ? "Not connected" : res);
            }
            q = scanner.next().charAt(0);   
        }
    }
    public static int bfs(int x, int y) {
        int[] dist = new int[50];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : adj[c]) {
                if (dist[i] == 0) {
                    dist[i] = dist[c] + 1;
                    q.offer(i);
                }
            }
            if (dist[y] != 0) break;
        }
        return dist[y];
    }
    public static int getFriends(int x) {
        int sum = 0;
        boolean[] vis = new boolean[50];
        vis[x] = true;

        for (int i : adj[x]) {
            vis[i] = true;
        }

        for (int i : adj[x]) {
            for (int j : adj[i]) {
                if (!vis[j]) {
                    vis[j] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}
