#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, prev, up = 1, down = 1;
    cin >> n;
    cin >> prev;
    for (int i = 1; i < n; i++) {
        int curr;
        cin >> curr;
        if (curr > prev) up = down + 1;
        else if (prev > curr) down = up + 1;
        prev = curr;
    }
    cout << max(up, down) << "\n";
    return 0;
}
