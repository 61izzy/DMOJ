import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(), k, min;
        String n;
        ArrayList<Integer> number = new ArrayList<Integer>(), highest = new ArrayList<Integer>();
        
        for (int i = 0; i < t; i++) {
            min = 10;
            n = scanner.next();
            k = scanner.nextInt();
            for (int c = 0; c < n.length(); c++) {
                while (k > 0 && number.size() > 0 && number.get(number.size() - 1) > n.charAt(c) - '0') {
                    highest.add(number.get(number.size() - 1));
                    min = Math.min(min, number.get(number.size() - 1));
                    number.remove(number.size() - 1);
                    k--;
                }
                number.add(n.charAt(c) - '0');
            }
            while (k > 0 && number.size() > 0 && number.get(number.size() - 1) > min) {
                highest.add(number.get(number.size() - 1));
                number.remove(number.size() - 1);
                k--;
            }
            Collections.sort(highest);
            number.forEach((c) -> System.out.print(c));
            highest.forEach((c) -> System.out.print(c));
            System.out.println();
            number.clear();
            highest.clear();
        }
    }
}
