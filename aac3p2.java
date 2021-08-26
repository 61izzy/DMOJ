import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int k = scanner.nextInt(), c = scanner.nextInt(), min;
        ArrayList<Integer> d = new ArrayList<Integer>();
        String n = "";
        
        for (int i = 0; i < c; i++) {
            d.add(scanner.nextInt());
        }
        
        if (onlyZeroes(d)) {
            n = "-1";
        }
        else {
            Collections.sort(d);
            min = getMin(d);
            if (d.get(0) == 0) {
                n += String.valueOf(min);
                for (int i = 0; i < k - 2; i++) {
                    n += String.valueOf(d.get(0));
                }
                if (k > 1) {
                    n += String.valueOf(min);
                }
            }
            else {
                for (int i = 0; i < k; i++) {
                    n += String.valueOf(d.get(0));
                }
            }
        }
        System.out.println(n);
    }
    public static boolean onlyZeroes(ArrayList<Integer> d) {
        for (int n : d) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
    public static int getMin(ArrayList<Integer> d) {
        for (int n : d) {
            if (n != 0) {
                return n;
            }
        }
        return d.get(d.size() - 1);
    }
}
