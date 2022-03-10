#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    
    int t, arr[600];
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        for (int i = 0; i < n; i++) cin >> arr[i];
        sort(arr, arr + n);
        if (n%2 == 1) {
            cout << arr[0];
            for (int i = 1; i < n; i++) cout << " " << arr[i];
        }
        else {
            if (arr[0] == arr[n - 1]) cout << -1;
            else {
                cout << arr[n - 1] << " " << arr[0];
                for (int i = 1; i < n/2; i++) cout << " " << arr[n - i - 1] << " " << arr[i];
            }
        }
        cout << "\n";
    }
}
