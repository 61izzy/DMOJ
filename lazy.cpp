#include <bits/stdc++.h>
using namespace std;

long long tree[400001], lazy[400001], asn[400001];

void build(int* arr, int l, int r, int idx) {
    if (l == r) {
        tree[idx] = arr[l];
        return;
    }
    int m = (l + r)/2;
    build(arr, l, m, 2 * idx);
    build(arr, m + 1, r, 2 * idx + 1);
    tree[idx] = min(tree[2 * idx], tree[2 * idx + 1]);
}
void update(int ql, int qr, int l, int r, int v, int idx) {
    if (asn[idx] != 0) {
        tree[idx] = asn[idx];
        if (l != r) {
            asn[2 * idx] = asn[idx];
            asn[2 * idx + 1] = asn[idx];
            lazy[2 * idx] = lazy[2 * idx + 1] = 0;
        }
        asn[idx] = 0;
    }
    if (lazy[idx] != 0) {
        tree[idx] += lazy[idx];
        if (l != r) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }
    if (ql > r || qr < l) {
        return;
    }
    if (l >= ql && r <= qr) {
        tree[idx] += v;
        if (l != r) {
            lazy[2 * idx] += v;
            lazy[2 * idx + 1] += v;
        }
        return;
    }
    int m = (l + r)/2;
    update(ql, qr, l, m, v, 2 * idx);
    update(ql, qr, m + 1, r, v, 2 * idx + 1);
    tree[idx] = min(tree[2 * idx], tree[2 * idx + 1]);
}
void assign(int ql, int qr, int l, int r, int v, int idx) {
    if (asn[idx] != 0) {
        tree[idx] = asn[idx];
        if (l != r) {
            asn[2 * idx] = asn[idx];
            asn[2 * idx + 1] = asn[idx];
            lazy[2 * idx] = lazy[2 * idx + 1] = 0;
        }
        asn[idx] = 0;
    }
    if (lazy[idx] != 0) {
        tree[idx] += lazy[idx];
        if (l != r) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }
    if (ql > r || qr < l) {
        return;
    }
    if (l >= ql && r <= qr) {
        lazy[idx] = 0;
        tree[idx] = v;
        if (l != r) {
            asn[2 * idx] = v;
            asn[2 * idx + 1] = v;
            lazy[2 * idx] = lazy[2 * idx + 1] = 0;
        }
        return;
    }
    int m = (l + r)/2;
    assign(ql, qr, l, m, v, 2 * idx);
    assign(ql, qr, m + 1, r, v, 2 * idx + 1);
    tree[idx] = min(tree[2 * idx], tree[2 * idx + 1]);
}
long long query(int ql, int qr, int l, int r, int idx) {
    if (asn[idx] != 0) {
        tree[idx] = asn[idx];
        if (l != r) {
            asn[2 * idx] = asn[idx];
            asn[2 * idx + 1] = asn[idx];
            lazy[2 * idx] = lazy[2 * idx + 1] = 0;
        }
        asn[idx] = 0;
    }
    if (lazy[idx] != 0) {
        tree[idx] += lazy[idx];
        if (l != r) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }
    if (l >= ql && r <= qr) {
        return tree[idx];
    }
    if (ql > r || qr < l) {
        return 0x3f3f3f3f3f3f3f3f;
    }
    int m = (l + r)/2;
    return min(query(ql, qr, l, m, 2 * idx), query(ql, qr, m + 1, r, 2 * idx + 1));
}
int main() {
    int n, q, arr[100001];
    cin >> n >> q;
    for (int i = 1; i <= n; i++) cin >> arr[i];
    build(arr, 1, n, 1);
    while (q--) {
        int op;
        cin >> op;
        if (op == 1) {
            int l, r, v;
            cin >> l >> r >> v;
            update(l, r, 1, n, v, 1);
        }
        else if (op == 2) {
            int l, r, v;
            cin >> l >> r >> v;
            assign(l, r, 1, n, v, 1);
        }
        else {
            int l, r;
            cin >> l >> r;
            cout << query(l, r, 1, n, 1) << "\n";
        }
    }
}
