import java.io.*;
import java.util.*;

public class Main {
    static int[] id;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt();
        id = new int[n];
        Arrays.fill(id, -1);
        boolean[] used = new boolean[m + 1];
        boolean mst = true;
        
        for (int i = 1; i <= m; i++) {
            int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
            if (id[u] == -1 || find(u) != find(v)) {
                used[i] = true;
                union(u, v);
            }
        }
        
        for (int i : id) if (i == -1) mst = false;
        if (!mst) System.out.println("Disconnected Graph");
        else {
            for (int i = 1; i <= m; i++) {
                if (used[i]) System.out.println(i);
            }
        }
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
