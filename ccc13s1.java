import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int y = scanner.nextInt();
        boolean yearFound = false;
        
        do {
            y++;
            if (y < 10) {
                yearFound = true;
                System.out.println(y);
            }
            else if (y < 100 && y/10 != y%10) {
                yearFound = true;
                System.out.println(y);
            }
            else if (y < 1000 && y/100 != y%100/10 && y/100 != y%10 && y%100/10 != y%10) {
                yearFound = true;
                System.out.println(y);
            }
            else if (y > 10000) {
                yearFound = true;
                System.out.println(10234);
            }
            else if (y/1000 != y%1000/100 && y/1000 != y%100/10 && y%1000/100 != y%100/10 && y/1000 != y%10 && y%1000/100 != y%10 && y%100/10 != y%10) {
                yearFound = true;
                System.out.println(y);
            }
        }
        while (!yearFound);
    }
}
