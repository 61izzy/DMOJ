import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int j, w, h, jump, lowestLeftWall, lowestRightWall;
        String[] l;
        
        for (int i = 0; i < 10; i++) {
            j = scanner.nextInt();
            w = scanner.nextInt();
            h = scanner.nextInt();
            l = new String[h];
            for (int n = 0; n < h; n++) {
                l[n] = scanner.next();
            }
            if (!(l[h - 2].contains("@"))) {
                System.out.println("CLEAR");
            }
            else {
                for (int n = l[h - 2].indexOf('L'); n <= l[h - 2].indexOf('G'); n++) {
                    if (l[h - 2].charAt(n) == '.' || l[h - 2].charAt(n) == 'L') {
                        continue;
                    }
                    else if (l[h - 2].charAt(n) == 'G') {
                        System.out.println("CLEAR");
                        break;
                    }
                    else {
                        jump = 0;
                        lowestLeftWall = -1;
                        lowestRightWall = -1;
                        for (int x = h - 2; x >= 0 && x >= h - 2 - j; x--) {
                            if (l[x].charAt(n - 1) == '@') {
                                lowestLeftWall = x;
                                break;
                            }
                        }
                        for (int x = h - 2; x >= 0 && x >= h - 2 - j; x--) {
                            if (l[x].charAt(n + 1) == '@') {
                                lowestRightWall = x;
                                break;
                            }
                        }
                        for (int x = h - 3; x >= 0 && x >= h - 2 - j; x--) {
                            if (l[x].charAt(n) == '.') {
                                jump = (h - 2) - x;
                                break;
                            }
                        }
                        if (jump > 0 && h - 2 - jump > lowestLeftWall && h - 2 - jump > lowestRightWall) {
                            continue;
                        }
                        else {
                            System.out.println(n + 1);
                            break;
                        }
                    }
                }
            }
        }
    }
}
