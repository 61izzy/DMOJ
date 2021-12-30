import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), v = scanner.nextInt(), arr[] = new int[n], dp[] = new int[10001];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        PriorityQueue<Query> pq = new PriorityQueue<Query>(v, (Query a, Query b) -> a.l != b.l ? a.l - b.l : b.j - a.j);
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < v; i++) {
            pq.offer(new Query(i, scanner.nextInt(), scanner.nextInt()));
        }
        
        int i = 0;
        while (!pq.isEmpty()) {
            Query curr = pq.poll();
            
            for (; i < curr.l; i++) {
                for (int j = arr[i]; j <= 10000; j++) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - arr[i]]);
                }
            }
            
            res.put(curr.j, dp[curr.c] == 10001 ? -1 : dp[curr.c]);
        }
        
        for (int k = 0; k < v; k++) {
            System.out.println(res.get(k));
        }
    }
}

class Query {
    int j, c, l;
    public Query(int j, int c, int l) {
        this.j = j;
        this.c = c;
        this.l = l;
    }
}
