#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> pii;
#define mp make_pair

int grid[1500][1500], dist[1500][1500];
int n, m, k;
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

int main() {
    cin >> n >> m >> k;
    queue<int> qx, qy, qc;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
            if (grid[i][j] != 0) {
                qx.push(i);
                qy.push(j);
                qc.push(grid[i][j]);
            }
        }
    }
    
    while (!qx.empty()) {
        int x = qx.front(), y = qy.front(), c = qc.front();
        qx.pop();
        qy.pop();
        qc.pop();
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m && dist[x][y] + 1 <= k) {
                if (grid[x + dx[i]][y + dy[i]] == 0 || dist[x][y] + 1 < dist[x + dx[i]][y + dy[i]]) {
                    grid[x + dx[i]][y + dy[i]] = c;
                    dist[x + dx[i]][y + dy[i]] = dist[x][y] + 1;
                    qx.push(x + dx[i]);
                    qy.push(y + dy[i]);
                    qc.push(c);
                }
                else if (dist[x][y] + 1 == dist[x + dx[i]][y + dy[i]] && c < grid[x + dx[i]][y + dy[i]]) {
                    grid[x + dx[i]][y + dy[i]] = c;
                    qx.push(x + dx[i]);
                    qy.push(y + dy[i]);
                    qc.push(c);
                }
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (j == 0) cout << grid[i][j];
            else cout << " " << grid[i][j];
        }
        cout << "\n";
    }
}
