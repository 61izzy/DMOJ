import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.next().split(":");
        int h = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), time = 0;
        
        if (h < 10) {
            time = (7 - h) * 60 - m;
            if (time >= 120) {
                time = 120;
            }
            else if (time <= 0) {
                time = (10 - h) * 60 - m + 30 * (4 - (10 - h)) + m/2;
            }
            else {
                if (h == 5) {
                    time += m * 2;
                }
                else {
                    time += (120 - (60 - m)) * 2;
                    if (time > 200) {
                        time -= 10;
                    }
                }
            }
        }
        else if (h < 19) {
            time = (15 - h) * 60 - m;
            if (time >= 120) {
                time = 120;
            }
            else if (time <= 0) {
                time = (19 - h) * 60 - m + 30 * (4 - (19 - h)) + m/2;
            }
            else {
                if (h == 13) {
                    time += m * 2;
                }
                else {
                    time += (120 - (60 - m)) * 2;
                }
            }
        }
        else {
            time = 120;
        }
        
        m += time;
        for (int i = m; i >= 60; i -= 60) {
            h++;
        }
        m %= 60;
        h %= 24;
        
        if (h < 10) {
            System.out.print(0);
        }
        System.out.print(h + ":");
        if (m < 10) {
            System.out.print(0);
        }
        System.out.println(m);
    }
}
