import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String row;
        char[] mark = {'O', 'X'};
        char[][] c = new char[3][3];
        int[] score = new int[2];
        
        for (int x = 0; x < 3; x++) {
            row = scanner.next();
            for (int y = 0; y < 3; y++) {
                c[x][y] = row.charAt(y);
            }
        }
        
        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 3; n++) {
                score[i] += getResult(c[n][0], c[n][1], c[n][2], mark[i]);
                score[i] += getResult(c[0][n], c[1][n], c[2][n], mark[i]);
            }
            score[i] += getResult(c[0][0], c[1][1], c[2][2], mark[i]);
            score[i] += getResult(c[0][2], c[1][1], c[2][0], mark[i]);
        }
        
        System.out.println(score[0] > 0 && score[1] > 0 ? "Error, redo" : score[0] == score[1] ? "Tie" : score[0] > score[1] ? "Griffy" : "Timothy");
    }
    
    public static int getResult (char c1, char c2, char c3, char mark) {
        if (c1 == mark && c2 == mark && c3 == mark) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
