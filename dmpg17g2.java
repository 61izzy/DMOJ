import java.io.*;
import java.util.*;

public class Main {
    static Node[] tree;
    static final long INF = 0x3f3f3f3f3f3f3fL;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), q = scanner.nextInt();
        tree = new Node[4 * n];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = scanner.nextInt();
        build(arr, 1, n, 1);
        tree[0] = new Node(-INF);
        tree[0].l = tree[0].r = tree[0].t = -INF;
        while (q-- > 0) {
            char op = scanner.next().charAt(0);
            if (op == 'S') {
            	int i = scanner.nextInt(), x = scanner.nextInt();
            	update(x, i, 1, n, 1);
            }
            else {
            	int l = scanner.nextInt(), r = scanner.nextInt();
            	System.out.println(query(l, r, 1, n, 1).v);
            }
        }
    }
    public static void build(int[] arr, int l, int r, int idx) {
      	if (l == r) {
        	tree[idx] = new Node(arr[l]);
            tree[idx].l = tree[idx].r = tree[idx].t = arr[l];
            return;
      	}
      	tree[idx] = new Node(-1);
      	int m = (l + r)/2;
      	build(arr, l, m, 2 * idx);
        build(arr, m + 1, r, 2 * idx + 1);
        tree[idx].l = Math.max(Math.max(tree[2 * idx].l, tree[2 * idx].t), tree[2 * idx].t + tree[2 * idx + 1].l);
        tree[idx].r = Math.max(Math.max(tree[2 * idx + 1].r, tree[2 * idx + 1].t), tree[2 * idx].r + tree[2 * idx + 1].t);
        tree[idx].t = tree[2 * idx].t + tree[2 * idx + 1].t;
        tree[idx].v = Math.max(Math.max(Math.max(tree[2 * idx].v, tree[2 * idx + 1].v), Math.max(tree[2 * idx].r, tree[2 * idx + 1].l)), Math.max(Math.max(tree[idx].t, tree[2 * idx].r + tree[2 * idx + 1].l), Math.max(tree[idx].l, tree[idx].r)));
    }
    public static void update(int v, int i, int l, int r, int idx) {
      	if (l == r) {
            tree[idx].v = tree[idx].l = tree[idx].r = tree[idx].t = v;
            return;
      	}
      	int m = (l + r)/2;
      	if (i <= m) update(v, i, l, m, 2 * idx);
      	else update(v, i, m + 1, r, 2 * idx + 1);
      	tree[idx].l = Math.max(Math.max(tree[2 * idx].l, tree[2 * idx].t), tree[2 * idx].t + tree[2 * idx + 1].l);
        tree[idx].r = Math.max(Math.max(tree[2 * idx + 1].r, tree[2 * idx + 1].t), tree[2 * idx].r + tree[2 * idx + 1].t);
        tree[idx].t = tree[2 * idx].t + tree[2 * idx + 1].t;
        tree[idx].v = Math.max(Math.max(Math.max(tree[2 * idx].v, tree[2 * idx + 1].v), Math.max(tree[2 * idx].r, tree[2 * idx + 1].l)), Math.max(Math.max(tree[idx].t, tree[2 * idx].r + tree[2 * idx + 1].l), Math.max(tree[idx].l, tree[idx].r)));
    }
    public static Node query(int ql, int qr, int l, int r, int idx) {
      	if (l >= ql && r <= qr) return tree[idx];
      	if (r < ql || l > qr) return tree[0];
      	int m = (l + r)/2;
      	Node res = new Node(-1), left = query(ql, qr, l, m, 2 * idx), right = query(ql, qr, m + 1, r, 2 * idx + 1);
      	res.l = Math.max(Math.max(left.l, left.t), left.t + right.l);
        res.r = Math.max(Math.max(right.r, right.t), left.r + right.t);
        res.t = right.t + left.t;
        res.v = Math.max(Math.max(Math.max(left.v, right.v), Math.max(left.r, right.l)), Math.max(Math.max(res.t, left.r + right.l), Math.max(res.l, res.r)));
      	return res;
    }
}

class Node {
    long v, l, r, t;
    public Node(long v) {
  	this.v = v;
    }
}
