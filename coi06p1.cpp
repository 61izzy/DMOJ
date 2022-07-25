#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    int n;
    cin >> n;
    long c = 0;
    stack<pair<int, int>> s;
    for (int i = 0; i < n; i++) {
        int h, temp = 1;
        cin >> h;
        while (!s.empty() && s.top().first <= h) {
            pair<int, int> p = s.top();
            s.pop();
            c += p.second;
            if (h == p.first) temp += p.second;
        }
        if (!s.empty()) c++;
        s.push({h, temp});
    }
    cout << c << "\n";
    return 0;
}
