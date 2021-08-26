import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt(), s = scanner.nextInt(), nikky, byron;
        
        nikky = s/(a + b) * a - s/(a + b) * b;
        nikky += s%(a + b) > a ? a - (s%(a + b) - a) : s%(a + b);
        byron = s/(c + d) * c - s/(c + d) * d;
        byron += s%(c + d) > c ? c - (s%(c + d) - c) : s%(c + d);
        System.out.println(nikky == byron ? "Tied" : nikky > byron ? "Nikky" : "Byron");
    }
}
