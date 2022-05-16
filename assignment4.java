import java.util.Scanner;

class assignment4 {
    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        int x = row;
        int y = col;
        while (x >= 0 & y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        x = row;
        y = col;
        while (x >= 0 & y < n) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    private static boolean nQueen(int[][] board, int row, int n) {
        if (row >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {
                board[row][i] = 1;
                if (nQueen(board, row + 1, n)) {
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of board : ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        nQueen(board, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}