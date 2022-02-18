import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()), p[] = new int[n + 1], k;
        Integer[][] arr = new Integer[n/s][s];
        
        for (int i = 0; i < n/s; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < s; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n * (s - 1)/2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'W') p[a] += 3;
            else if (c == 'L') p[b] += 3;
            else {
                p[a]++;
                p[b]++;
            }
        }
        
        k = Integer.parseInt(br.readLine()) - 1;
        
        for (int i = 0; i < n/s; i++) {
            Arrays.sort(arr[i], (a, b) -> p[b] == p[a] ? a - b : p[b] - p[a]);
            System.out.print(i == 0 ? arr[i][k] : " " + arr[i][k]);
        }
        System.out.println();
    }
}
