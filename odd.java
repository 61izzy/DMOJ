import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()), x = 0;
        for (int i = 0; i < n; i++) {
            x ^= Integer.parseInt(br.readLine());
        }
        System.out.println(x);
    }
}
