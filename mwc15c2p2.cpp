#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    int n;
    cin >> n;
    deque<pair<int, int>> dq;
    dq.push_back({0x3f3f3f3f, 0});
    for (int i = 0; i < n; i++) {
        int h;
        cin >> h;
        while (dq.back().first <= h) dq.pop_back();
        if (i > 0) cout << " ";
        cout << i - dq.back().second;
        dq.push_back({h, i});
    }
    return 0;
}
