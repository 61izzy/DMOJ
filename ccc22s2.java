import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt(), c = 0;
        HashMap<String, HashSet<String>> same = new HashMap<String, HashSet<String>>(), diff = new HashMap<String, HashSet<String>>();
        for (int i = 0; i < x; i++) {
            String s = scanner.next(), t = scanner.next();
            if (!same.containsKey(s)) same.put(s, new HashSet<String>());
            same.get(s).add(t);
        }
        int y = scanner.nextInt();
        for (int i = 0; i < y; i++) {
            String s = scanner.next(), t = scanner.next();
            if (!diff.containsKey(s)) diff.put(s, new HashSet<String>());
            diff.get(s).add(t);
        }
        int g = scanner.nextInt();
        String[][] arr = new String[g][3];
        for (int k = 0; k < g; k++) {
            for (int i = 0; i < 3; i++) {
                arr[k][i] = scanner.next();
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < i + 3; j++) {
                    if (diff.containsKey(arr[k][i]) && diff.get(arr[k][i]).contains(arr[k][j%3])) c++;
                }
                if (same.containsKey(arr[k][i])) {
                    for (String j : same.get(arr[k][i])) {
                        if (!arr[k][(i + 1)%3].equals(j) && !arr[k][(i + 2)%3].equals(j)) c++;
                    }
                }
            }
        }

        System.out.println(c);
    }
}
