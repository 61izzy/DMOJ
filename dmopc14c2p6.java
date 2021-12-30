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
        TreeMap<Query, Pair> queries = new TreeMap<Query, Pair>((Query a, Query b) -> a.m != b.m ? a.m - b.m : b.i - a.i);
        HashMap<Integer, Long> res = new HashMap<Integer, Long>();

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt() + 1, m = scanner.nextInt();
            queries.put(new Query(i, m), new Pair(a, b));
        }

        int i = n - 1;
        while (!queries.isEmpty()) {
            Query curr = queries.lastKey();
            Pair p = queries.pollLastEntry().getValue();
            
            for (; i >= 0 && arr[i] >= curr.m; i--) {
                update(idx.get(arr[i]).poll(), arr[i]);
            }

            res.put(curr.i, query(p.b) - query(p.a));
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

class Pair {
    int a, b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Query {
    int i, m;
    public Query(int i, int m) {
        this.i = i;
        this.m = m;
    }
}
