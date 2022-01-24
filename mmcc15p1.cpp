#include <bits/stdc++.h>
using namespace std;

#define mp make_pair
typedef pair<int, int> pii;
typedef pair<pii, bool> ppb;
stack<ppb> last;

int id[500001], sz[500001];

void Init(int N) {
    for (int i = 1; i <= N; i++) {
        id[i] = i;
        sz[i] = 1;
    }
}
int find(int x) {
    return x == id[x] ? x : find(id[x]);
}
void AddEdge(int U, int V) {
    int x = find(U), y = find(V);
    if (x == y) {
        last.push(mp(mp(x, y), false));
        return;
    }
    if (sz[x] > sz[y]) {
        sz[x] += sz[y];
        id[y] = x;
    }
    else {
        sz[y] += sz[x];
        id[x] = y;
    }
    last.push(mp(mp(x, y), true));
}
void RemoveLastEdge() {
    if (last.top().second) {
        pii p = last.top().first;
        if (sz[p.first] > sz[p.second]) {
            id[p.second] = p.second;
            sz[p.first] -= sz[p.second];
        }
        else {
            id[p.first] = p.first;
            sz[p.second] -= sz[p.first];
        }
    }
    last.pop();
}
int GetSize(int U) {
    return sz[find(U)];
}
