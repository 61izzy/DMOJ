import java.io.*;
import java.util.*;

public class Main {
    static int[] id;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        id = new int[n];
        Arrays.fill(id, -1);
        boolean dag = true;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if (find(i, j)) dag = false;
                    else id[j] = i;
                }
            }
        }
        
        System.out.println(dag ? "YES" : "NO");
    }
    public static boolean find(int x, int y) {
        return x == y ? true : id[x] >= 0 ? find(id[x], y) : false;
    }
}
