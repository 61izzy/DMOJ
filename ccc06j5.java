import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Board board = new Board(scanner.next().charAt(0));
        int n = scanner.nextInt(), b = 0, w = 0;
        char[] colour = {'B', 'W', 'B'};
        
        for (int i = 0; i < n; i++) {
            board.move(scanner.nextInt() - 1, scanner.nextInt() - 1,  colour[i%2], colour[i%2 + 1]);
        }

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board.board[r][c] == 'B') {
                    b++;
                }
                else if (board.board[r][c] == 'W') {
                    w++;
                }
            }
        }
        
        System.out.println(b + " " + w);
    }
}
class Board {
    char[][] board = new char[8][8];
    public Board(char config) {
        if (config == 'a') {
            board[3][3] = board[4][4] = 'W';
            board[3][4] = board[4][3] = 'B';
        }
        else if (config == 'b') {
            for (int r = 0, c = 7; r < 8; r++, c--) {
                board[r][r] = 'B';
                board[r][c] = 'W';
            }
        }
        else if (config == 'c') {
            for (int r = 0; r < 8; r++) {
                board[r][2] = board[r][3] = 'B';
                board[r][4] = board[r][5] = 'W';
            }
        }
    }
    int[] x = {-1, -1, -1, 0, 1, 1, 1, 0}, y = {-1, 0, 1, 1, 1, 0, -1, -1};
    public void move(int r, int c, char colour, char notColour) {
        board[r][c] = colour;
        for (int n = 0; n < 8; n++) {
            if (search(r, c, x[n], y[n], colour)) {
                for (int i = r + x[n], j = c + y[n]; i >= 0 && i < 8 && j >= 0 && j < 8 && board[i][j] == notColour; i += x[n], j += y[n]) {
                    board[i][j] = colour;
                }
            }
        }
    }
    public boolean search(int r, int c, int x, int y, char colour) {
        for (int i = r + x, j = c + y; i >= 0 && i < 8 && j >= 0 && j < 8; i += x, j += y) {
            if (board[i][j] == colour) {
                return true;
            }
            else if (board[i][j] == 0) {
                return false;
            }
        }
        return false;
    }
}
