import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), ida[] = new int[n + 1];
        long dist = 0;
        Deque<Pair> dq = new LinkedList<Pair>();
        
        dq.add(new Pair(0, -1));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i - dq.peek().i > k) dq.poll();
            dist = Long.parseLong(st.nextToken()) + dq.peek().v;
            ida[i] = dq.peek().i;
            while (!dq.isEmpty() && dq.peekLast().v >= dist) dq.pollLast();
            dq.add(new Pair(dist, i));
        }
        if (n - dq.peek().i > k) dq.poll();
        dist = dq.peek().v;
        int idx = ida[n] = dq.peek().i;

        System.out.println(dist);
        Stack<Integer> out = new Stack<Integer>();
        while (idx > -1) {
            out.push(idx);
            idx = ida[idx];
        }
        while (!out.isEmpty()) System.out.print(out.pop() + 1 + " ");
    }
}

class Pair {
    long v;
    int i;
    public Pair(long v, int i) {
        this.v = v;
        this.i = i;
    }
}
