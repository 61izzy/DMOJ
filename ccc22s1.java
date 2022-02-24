import java.io.*;
import java.util.*;

public class Main {
	  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), c = 0, a = n/5, b = 0;
        while (a >= 0) {
            while (n - (a * 5 + b * 4) >= 4) b++;
            if (a * 5 + b * 4 == n) c++;
            a--;
        }
        System.out.println(c);
	  }
}
