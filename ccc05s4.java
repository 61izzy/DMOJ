import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, ArrayList<String>> adj;
    static HashSet<String> vis;
    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        
        for (int k = 0; k < l; k++) {
            max = 0;
            int n = scanner.nextInt();
            adj = new HashMap<String, ArrayList<String>>();
            vis = new HashSet<String>();
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
                if (i > 0) {
                    if (adj.get(names[i]) == null) adj.put(names[i], new ArrayList<String>());
                    adj.get(names[i]).add(names[i - 1]);
                }
            }
            System.out.println((dfs(names[n - 1], 0) - max) * 20);
        }
    }
    public static int dfs(String s, int dist) {
        vis.add(s);
        if (dist + 1 > max) max = dist + 1;
        if (adj.get(s) == null) return 1;

        int sz = 1;
        
        for (String name : adj.get(s)) {
            if (!vis.contains(name)) sz += dfs(name, dist + 1);
        }
        
        return sz;
    }
}
