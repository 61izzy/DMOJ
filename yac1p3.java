import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            if (n%2 == 1) {
                System.out.println(1);
                System.out.printf("%d %d\n", n/2 + 1, n/2 + 1);
            }
            else System.out.println(2);
            System.out.flush();
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            while (r != 0 && c != 0) {
                System.out.printf("%d %d\n", n - r + 1, n - c + 1);
                System.out.flush();
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
            }
        }
    }
}
