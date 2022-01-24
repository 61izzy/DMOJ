import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 10001;
    static int[] tree = new int[MAXN];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int c = Integer.parseInt(br.readLine());
        HashMap<String, Pair> arr = new HashMap<String, Pair>();
        
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'A') {
                String s = st.nextToken();
                if (arr.containsKey(s)) {
                    System.out.println("Can't add " + s);
                }
                else {
                    arr.put(s, new Pair(arr.size() + 1, s));
                    update(arr.size(), arr.get(s).v);
                }
            }
            else if (op == 'S') {
                String s = st.nextToken(), t = st.nextToken();
                update(arr.get(s).idx, arr.get(t).v - arr.get(s).v);
                update(arr.get(t).idx, arr.get(s).v - arr.get(t).v);
                int temp = arr.get(s).idx;
                arr.get(s).idx = arr.get(t).idx;
                arr.get(t).idx = temp;
            }
            else if (op == 'M') {
                String s = st.nextToken(), t = st.nextToken();
                int l = Math.min(arr.get(s).idx, arr.get(t).idx) - 1, r = Math.max(arr.get(s).idx, arr.get(t).idx);
                System.out.println(query(r) - query(l));
            }
            else if (op == 'R') {
                String s = st.nextToken(), t = st.nextToken();
                int idx = arr.get(s).idx;
                arr.put(t, new Pair(idx, t));
                update(idx, arr.get(t).v - arr.get(s).v);
                arr.remove(s);
            }
            else {
                System.out.println(arr.size());
            }
        }
    }
    public static void update(int x, int v) {
        for (int i = x; i < MAXN; i += i & -i) {
            tree[i] += v;
        }
    }
    public static int query(int x) {
        int sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }
}

class Pair {
    int idx, v = 0;
    public Pair(int idx, String s) {
        this.idx = idx;
        for (int i = 0; i < s.length(); i++) {
            v += s.charAt(i) - 'a' + 1;
        }
    }
}
