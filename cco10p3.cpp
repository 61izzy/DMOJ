#include <bits/stdc++.h>
using namespace std;

struct query {
    char op;
    int a, b;
    query() {}
    query(char c, int x) {
        op = c;
        a = x;
    }
    query(char c, int x, int y) {
        op = c;
        a = x;
        b = y;
    }
};

const int MAXN = 1000001;
int tree[MAXN], v[MAXN], id[MAXN];

void update(int x, int v) {
    for (int i = x; i < MAXN; i += i & -i) {
        tree[i] += v;
    }
}
int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    int n, p = 0;
    cin >> n;
    query q[n];
    unordered_map<int, int> map;
    vector<int> arr;
    for (int i = 0; i < n; i++) {
        char op;
        int a, b;
        cin >> op >> a;
        if (op != 'Q') {
            cin >> b;
            arr.push_back(b);
            q[i] = query(op, a, b);
        }
        else {
            q[i] = query(op, a);
        }
    }
    sort(arr.begin(), arr.end());
    for (int i = 0, j = 1; i < arr.size(); i++) {
        while (i < arr.size() - 1 && arr[i] == arr[i + 1]) i++;
        map.insert({arr[i], j});
        j++;
    }
    for (query curr : q) {
        if (curr.op == 'N') {
            v[curr.a] = curr.b;
            update(map.at(curr.b), 1);
            id[map.at(curr.b)] = curr.a;
            p++;
        }
        else if (curr.op == 'M') {
            update(map.at(v[curr.a]), -1);
            v[curr.a] = curr.b;
            update(map.at(curr.b), 1);
            id[map.at(curr.b)] = curr.a;
        }
        else {
            int l = 1, r = n;
            while (l <= r) {
                int m = (l + r)/2, c = 0;
                for (int i = m; i > 0; i -= i & -i) c += tree[i];
                if (c > p - curr.a) r = m - 1;
                else l = m + 1;
            }
            cout << id[l] << "\n";
        }
    }
    return 0;
}
