import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int r = scanner.nextInt(), l = scanner.nextInt(), duplicateCount = 0;
        int[][] lastRow = new int[r][l];
        int[][][] g = new int[r][r][l];
        boolean duplicate;
        
        for (int k = 0; k < r; k++) {
            for (int i = 0; i < l; i++) {
                g[0][k][i] = scanner.nextInt();
                for (int n = 1; n < r; n++) {
                    g[n][k][i] = g[0][k][i];
                }
            }
        }

        lastRow[0] = g[0][r - 1];

        for (int n = 1; n < r; n++) {
            lastRow[n] = getRow(g[n], n, r, l);
        }

        for (int i = r - 1; i > -1; i--) {
            duplicate = false;
            for (int n = 0; n < i; n++) {
                if (Arrays.equals(lastRow[i], lastRow[n])) {
                    duplicate = true;
                }
            }
            if (duplicate) {
                duplicateCount++;
            }
        }
        
        System.out.println(lastRow.length - duplicateCount);
    }
    public static int[] getRow(int[][] g, int n, int r, int l) {
        for (int k = r - n; k < r; k++) {
            for (int i = 0; i < l; i++) {
                g[k][i] ^= g[k - 1][i];
            }
        }
        return g[r - 1];
    }
}
