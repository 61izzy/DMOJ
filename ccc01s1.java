import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.next();
        String[] suit = {s.substring(0, s.indexOf("D")), s.substring(s.indexOf("D"), s.indexOf("H")), s.substring(s.indexOf("H"), s.indexOf("S")), s.substring(s.indexOf("S"))}, suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        int[] points = new int[4];
        
        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < suit[n].length(); i++) {
                if (suit[n].charAt(i) == 'A')
                    points[n] += 4;
                if (suit[n].charAt(i) == 'K')
                    points[n] += 3;
                if (suit[n].charAt(i) == 'Q')
                    points[n] += 2;
                if (suit[n].charAt(i) == 'J')
                    points[n]++;
            }
            if (suit[n].length() == 3)
                points[n]++;
            if (suit[n].length() == 2)
                points[n] += 2;
            if (suit[n].length() == 1)
                points[n] += 3;
        }
        
        System.out.println("Cards Dealt              Points");
        for (int n = 0; n < 4; n++) {
            System.out.print(suits[n]);
            for (int i = 1; i < suit[n].length(); i++) {
                System.out.print(" " + suit[n].charAt(i));
            }
            for (int i = 25 - (suits[n].length() + (suit[n].length() - 1) * 2); i > 0; i--) {
                System.out.print(" ");
            }
            System.out.printf("%6s", points[n]);
            System.out.println();
        }
        System.out.printf("%31s", "Total " + (points[0] + points[1] + points[2] + points[3]));
    }
}
