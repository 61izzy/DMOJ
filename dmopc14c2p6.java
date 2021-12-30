import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[n];
        tree = new long[n + 1];
        HashMap<Integer, LinkedList<Integer>> idx = new HashMap<Integer, LinkedList<Integer>>();
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (idx.get(arr[i]) == null) idx.put(arr[i], new LinkedList<Integer>());
            idx.get(arr[i]).offer(i + 1);
        }
        
        Arrays.sort(arr);

        int q = scanner.nextInt();
        PriorityQueue<Query> pq = new PriorityQueue<Query>((Query a, Query b) -> a.m != b.m ? b.m - a.m : a.i - b.i);
        HashMap<Integer, Long> res = new HashMap<Integer, Long>();

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt() + 1, m = scanner.nextInt();
            pq.offer(new Query(i, a, b, m));
        }

        int i = n - 1;
        while (!pq.isEmpty()) {
            Query curr = pq.poll();
            
            for (; i >= 0 && arr[i] >= curr.m; i--) {
                update(idx.get(arr[i]).poll(), arr[i]);
            }

            res.put(curr.i, query(curr.b) - query(curr.a));
        }

        for (int k = 0; k < q; k++) {
            System.out.println(res.get(k));
        }
    }
    public static void update(int x, int v) {
        for (int i = x; i < tree.length; i += i & -i) {
            tree[i] += v;
        }
    }
    public static long query(int x) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }
}

class Query {
    int i, a, b, m;
    public Query(int i, int a, int b, int m) {
        this.i = i;
        this.a = a;
        this.b = b;
        this.m = m;
    }
}
