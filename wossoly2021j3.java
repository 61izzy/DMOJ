import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long d = scanner.nextLong();
        long[] arr = new long[7];
        
        arr[6] = d/1000;
        arr[5] = d%1000/500;
        arr[4] = d%1000%500/100;
        arr[3] = d%1000%500%100/50;
        arr[2] = d%1000%500%100%50/10;
        arr[1] = d%1000%500%100%50%10/5;
        arr[0] = d%1000%500%100%50%10%5;
        
        for (long i : arr) {
            System.out.print(i + " ");
        }
    }
}
