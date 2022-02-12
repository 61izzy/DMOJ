import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), arr[] = new int[1001], max = 0, res = 0;
        ArrayList<Integer> fq = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[x]++;
            max = Math.max(max, arr[x]);
        }
        for (int i = 1; i <= 1000; i++) {
            if (arr[i] == max) {
                fq.add(i);
                arr[i] = 0;
            }
        }
        if (fq.size() > 1) res = fq.get(fq.size() - 1) - fq.get(0);
        else {
            max = 0;
            for (int i = 1; i <= 1000; i++) max = Math.max(max, arr[i]);
            for (int i = 1; i <= 1000; i++)
                if (arr[i] == max)
                    res = Math.max(res, Math.abs(fq.get(0) - i));
        }
        System.out.println(res);
    }
}
