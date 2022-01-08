import java.io.*;
import java.util.*;

public class Main {
    static Node[] tree;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        n = scanner.nextInt();
        int m = scanner.nextInt();
        tree = new Node[2 * n];
        
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            tree[i + n] = new Node(x, x, 1);
        }
        
        for (int i = n - 1; i > 0; i--) {
            tree[i] = new Node(Math.min(tree[2 * i].min, tree[2 * i + 1].min), gcd(tree[2 * i].gcd, tree[2 * i + 1].gcd), 0);
            if (tree[i].gcd == tree[2 * i].gcd) tree[i].cnt += tree[2 * i].cnt;
            if (tree[i].gcd == tree[2 * i + 1].gcd) tree[i].cnt += tree[2 * i + 1].cnt;
        }
        
        for (int k = 0; k < m; k++) {
            char op = scanner.next().charAt(0);
            if (op == 'C') {
                int x = scanner.nextInt(), v = scanner.nextInt();
                update(x, v);
            }
            else if (op == 'M') {
                int l = scanner.nextInt() - 1, r = scanner.nextInt();
                System.out.println(mQuery(l, r));
            }
            else if (op == 'G') {
                int l = scanner.nextInt() - 1, r = scanner.nextInt();
                System.out.println(gQuery(l, r));
            }
            else {
                int l = scanner.nextInt() - 1, r = scanner.nextInt();
                System.out.println(qQuery(l, r));
            }
        }
    }
    public static int gcd(int a, int b) {
        return a%b == 0 ? b : gcd(b, a%b);
    }
    public static void update(int x, int v) {
        x += n - 1;
        tree[x].min = tree[x].gcd = v;
        for (int i = x/2; i > 0; i /= 2) {
            tree[i].min = Math.min(tree[2 * i].min, tree[2 * i + 1].min);
            tree[i].gcd = gcd(tree[2 * i].gcd, tree[2 * i + 1].gcd);
            tree[i].cnt = 0;
            if (tree[i].gcd == tree[2 * i].gcd) tree[i].cnt += tree[2 * i].cnt;
            if (tree[i].gcd == tree[2 * i + 1].gcd) tree[i].cnt += tree[2 * i + 1].cnt;
        }
    }
    public static int mQuery(int l, int r) {
        int min = Integer.MAX_VALUE;
        for (l += n, r += n; l < r; l /= 2, r /= 2) {
            if (l%2 == 1) min = Math.min(min, tree[l++].min);
            if (r%2 == 1) min = Math.min(min, tree[--r].min);
        }
        return min;
    }
    public static int gQuery(int l, int r) {
        int res = tree[l + n].min;
        for (l += n, r += n; l < r; l /= 2, r /= 2) {
            if (l%2 == 1) res = gcd(res, tree[l++].gcd);
            if (r%2 == 1) res = gcd(res, tree[--r].gcd);
        }
        return res;
    }
    public static int qQuery(int l, int r) {
        int res = gQuery(l, r), cnt = 0;
        for (l += n, r += n; l < r; l /= 2, r /= 2) {
            if (l%2 == 1 && res == tree[l++].gcd) cnt += tree[l - 1].cnt;
            if (r%2 == 1 && res == tree[--r].gcd) cnt += tree[r].cnt;
        }
        return cnt;
    }
}

class Node {
    int min, gcd, cnt;
    public Node(int min, int gcd, int cnt) {
        this.min = min;
        this.gcd = gcd;
        this.cnt = cnt;
    }
}
