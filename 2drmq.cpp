#include <bits/stdc++.h>
using namespace std;

int st[10][1001][10][1001];

void init(vector<vector<int>> arr) {
    int n = arr.size(), sz = (int)log2(n) + 1;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            st[0][i][0][j] = arr[i][j];
        for (int j = 1; j < sz; j++)
            for (int k = 0; k + (1 << (j - 1)) < n; k++)
                st[0][i][j][k] = min(st[0][i][j - 1][k], st[0][i][j - 1][k + (1 << (j - 1))]);
    }
            
    for (int i = 1; i < sz; i++)
        for (int j = 0; j + (1 << (i - 1)) < n; j++)
            for (int k = 0; k < sz; k++)
                for (int l = 0; l + (1 << k) <= n; l++)
                    st[i][j][k][l] = min(st[i - 1][j][k][l], st[i - 1][j + (1 << (i - 1))][k][l]);
}

int query(int a, int b, int c, int d) {
    b++;
    d++;
    int i = (int)log2(b - a), j = (int)log2(d - c);
    return min(min(st[i][a][j][c], st[i][b - (1 << i)][j][c]), min(st[i][a][j][d - (1 << j)], st[i][b - (1 << i)][j][d - (1 << j)]));
}
