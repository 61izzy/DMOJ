import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt(), res = 1;
        char d = '.';
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) grid[i] = scanner.next();
        int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
        Queue<Signal> q = new LinkedList<Signal>();
        char[] arr = {'U', 'R', 'D', 'L'};
        int[] dy = {0, 1, 0, -1}, dx = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m && grid[x + dx[i]].charAt(y + dy[i]) != 'C') {
                q.offer(new Signal(x + dx[i], y + dy[i], 2, i, arr[i]));
            }
        }
        while (!q.isEmpty()) {
            Signal curr = q.poll();
            if (curr.x == x && curr.y == y && arr[curr.d] == curr.s) {
                res = Integer.MAX_VALUE;
                d = curr.s;
                break;
            }
            else if (grid[curr.x].charAt(curr.y) == '\\' || grid[curr.x].charAt(curr.y) == '/') {
                if ((curr.d == 3 && grid[curr.x].charAt(curr.y) == '\\' || curr.d == 1 && grid[curr.x].charAt(curr.y) == '/') && curr.x > 0 && grid[curr.x - 1].charAt(curr.y) != 'C') {
                    q.offer(new Signal(curr.x - 1, curr.y, curr.t + 1, 0, curr.s));
                    if (curr.t + 1 > res) {
                        res = curr.t + 1;
                        d = curr.s;
                    }
                }
                else if ((curr.d == 3 && grid[curr.x].charAt(curr.y) == '/' || curr.d == 1 && grid[curr.x].charAt(curr.y) == '\\') && curr.x < n - 1 && grid[curr.x + 1].charAt(curr.y) != 'C') {
                    q.offer(new Signal(curr.x + 1, curr.y, curr.t + 1, 2, curr.s));
                    if (curr.t + 1 > res) {
                        res = curr.t + 1;
                        d = curr.s;
                    }
                }
                else if ((curr.d == 2 && grid[curr.x].charAt(curr.y) == '\\' || curr.d == 0 && grid[curr.x].charAt(curr.y) == '/') && curr.y < m - 1 && grid[curr.x].charAt(curr.y + 1) != 'C') {
                    q.offer(new Signal(curr.x, curr.y + 1, curr.t + 1, 1, curr.s));
                    if (curr.t + 1 > res) {
                        res = curr.t + 1;
                        d = curr.s;
                    }
                }
                else if ((curr.d == 2 && grid[curr.x].charAt(curr.y) == '/' || curr.d == 0 && grid[curr.x].charAt(curr.y) == '\\') && curr.y > 0 && grid[curr.x].charAt(curr.y - 1) != 'C') {
                    q.offer(new Signal(curr.x, curr.y - 1, curr.t + 1, 3, curr.s));
                    if (curr.t + 1 > res) {
                        res = curr.t + 1;
                        d = curr.s;
                    }
                }
            }
            else {
                if (curr.x + dx[curr.d] >= 0 && curr.x + dx[curr.d] < n && curr.y + dy[curr.d] >= 0 && curr.y + dy[curr.d] < m && grid[curr.x + dx[curr.d]].charAt(curr.y + dy[curr.d]) != 'C') {
                    q.offer(new Signal(curr.x + dx[curr.d], curr.y + dy[curr.d], curr.t + 1, curr.d, curr.s));
                    if (curr.t + 1 > res) {
                        res = curr.t + 1;
                        d = curr.s;
                    }
                }
            }
        }
        System.out.println(d);
        System.out.println(res == Integer.MAX_VALUE ? "Voyager" : res);
    }
}

class Signal {
    int x, y, t, d;
    char s;
    public Signal(int x, int y, int t, int d, char s) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.d = d;
        this.s = s;
    }
}

// this really took 1 hour to debug... -_-
// could've made it a lot simpler too .-.
// edit: removed the hashmap (why tf was i using a hashmap???)
