import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();
            Stack<Integer> m = new Stack<Integer>(), b = new Stack<Integer>();
            boolean thing = true;
            for (int i = 0; i < n; i++) {
                m.push(scanner.nextInt());
            }
            for (int i = 1; i <= n; i++) {
                if (!m.isEmpty() && m.peek() == i) {
                    m.pop();
                }
                else if (!b.isEmpty() && b.peek() == i) {
                    b.pop();
                }
                else {
                    while (!m.isEmpty() && m.peek() != i) {
                        b.push(m.pop());
                    }
                    if (m.isEmpty()) {
                        thing = false;
                    }
                    else {
                        m.pop();
                    }
                }
            }
            System.out.println(thing ? "Y" : "N");
        }
    }
}
