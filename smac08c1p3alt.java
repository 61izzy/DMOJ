import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), dist = 0;
        Deque<Pair> dq = new LinkedList<Pair>();
        
        dq.add(new Pair(0, -d));
        for (int i = 0; i < n; i++) {
            if (i - dq.peek().i > d) dq.poll();
            dist = Integer.parseInt(br.readLine()) + dq.peek().v;
            while (!dq.isEmpty() && dq.peekLast().v >= dist) dq.pollLast();
            dq.add(new Pair(dist, i));
        }

        System.out.println(dist);
    }
}

class Pair {
    int v;
    int i;
    public Pair(int v, int i) {
        this.v = v;
        this.i = i;
    }
}
