import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] arr = {n, n};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                arr[j] -= scanner.nextInt() * scanner.nextInt();
            }
            if (arr[0] <= 0 && arr[1] <= 0) {
                System.out.println("It's a tie at round " + (i + 1) + "!");
                break;
            }
            else if (arr[0] <= 0) {
                System.out.println("Team 1 wins at round " + (i + 1) + "!");
                break;
            }
            else if (arr[1] <= 0) {
                System.out.println("Team 2 wins at round " + (i + 1) + "!");
                break;
            }
        }
        if (arr[0] > 0 && arr[1] > 0) {
            System.out.println("Oh no!");
        }
    }
}
