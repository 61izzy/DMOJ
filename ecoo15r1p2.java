import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int w, c;
        String[] s;
        ArrayList<Character> t = new ArrayList<Character>();
        
        for (int i = 0; i < 10; i++) {
            c = 0;
            w = Integer.parseInt(scanner.nextLine());
            s = scanner.nextLine().split(" ");
            
            for (String word : s) {
                if (c != 0) {
                    if (c + word.length() + 1 > w) {
                        t.add('\n');
                        c = 0;
                    }
                    else {
                        t.add(' ');
                        for (int j = 0; j < word.length(); j++) {
                            t.add(word.charAt(j));
                        }
                        c += word.length() + 1;
                    }
                }
                if (c == 0) {
                    for (int j = 0; j < word.length(); j++) {
                        t.add(word.charAt(j));
                        c++;
                        if (c == w) {
                            t.add('\n');
                            c = 0;
                        }
                    }
                }
            }
            
            t.forEach((e) -> System.out.print(e));
            
            if (c != 0) {
                System.out.println();
            }
            
            System.out.println("=====");
            
            t.clear();
        }
    }
}
