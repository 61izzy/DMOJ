#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

bool comp(pii a, pii b) {return a.first < b.first;}

int main() {
    int n, k;
    long res = 0;
    cin >> n >> k;
    int c[k];
    pii arr[n];
    priority_queue<int> pq;
    
    for (int i = 0; i < n; i++) {
        int m, v;
        cin >> m >> v;
        arr[i] = {m, v};
    }
    sort(arr, arr + n, comp);
    
    for (int i = 0; i < k; i++) {
        cin >> c[i];
    }
    sort(c, c + k);
    
    int j = 0;
    for (int i : c) {
        while (j < n && arr[j].first <= i) {
            pq.push(arr[j++].second);
        }
        if (!pq.empty()) {
            res += pq.top();
            pq.pop();
        }
    }
    
    cout << res << "\n";
    return 0;
}
