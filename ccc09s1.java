import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int min = scanner.nextInt(), max = scanner.nextInt(), count = 0;
        
        for (int i = 1; i <= 500; i++)
            if (Math.pow(i, 3) <= max && Math.pow(i, 3) >= min && Math.sqrt(Math.pow(i, 3))%1 == 0)
                count++;
                
        System.out.println(count);
    }
}
