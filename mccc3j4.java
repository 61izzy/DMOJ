import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), t = scanner.nextInt();
        Queue<Integer>[] arr = new LinkedList[n + 1];
        int[] last = new int[n + 1];
        boolean[] thing = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = new LinkedList<Integer>();
            arr[i].add(scanner.nextInt());
        }
        
        for (int i = 0; i < t; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[j].isEmpty()) thing[j] = true;
                else thing[j] = false;
            }
            for (int j = 1; j <= n; j++) {
                if (!thing[j]) {
                    last[j] = arr[j].poll();
                    arr[last[j]].add(j);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(i == 1 ? last[i] : " " + last[i]);
        }
        System.out.println();
    }
}
