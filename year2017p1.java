import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt(), i = -1, j = 0;
        HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>(), idx = new HashMap<Integer, Integer>();
        
        for (int k = 0; k < q; k++) {
            char op = scanner.next().charAt(0);
            int x = scanner.nextInt();
            if (op == 'F') {
                arr.put(i, x);
                idx.put(x, i--);
            }
            else if (op == 'E') {
                arr.put(j, x);
                idx.put(x, j++);
            }
            else {
                arr.remove(idx.get(x));
            }
        }
        
        for (i += 1; i < j; i++) {
            if (arr.containsKey(i)) {
                System.out.println(arr.get(i));
            }
        }
    }
}
