import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDay = scanner.nextInt(), totalDays = scanner.nextInt(), days = 0;

        System.out.println("Sun Mon Tue Wed Thr Fri Sat");
    
        for (int i = 1; i <= totalDays; i++) {
            if (days == 7) {
                System.out.println();
                days = 0;
            }
        
            if (days != 0) {
                System.out.print(" ");
            }
        
            if (i == 1) {
                for (int n = 1; n < firstDay; n++) {
                    System.out.print("    ");
                    days++;
                }
            }
        
            System.out.printf("%3s", i);
        
            days++;
        }
        System.out.println();
    }
}
