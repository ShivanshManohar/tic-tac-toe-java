import java.util.Scanner;

public class TicTacToeSimple {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in); // topmost row is 0th index and the leftmost column is 0th index

        // fill board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);

            System.out.println("Player " + player + " enter row and column (0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            // check if input is within range
            if (r < 0 || r > 2 || c < 0 || c > 2) {
                System.out.println("Invalid position! Please enter values between 0 and 2.");
                continue; // skip rest and ask again
            }

            // check if cell is free
            if (board[r][c] == ' ') {
                board[r][c] = player;

                // check winner
                if (checkWin(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    // switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already taken, try again.");
            }
        }

        sc.close();
    }

    // print current board
    static void printBoard(char[][] b) {
        for (int i = 0; i < 3; i++) {
            System.out.println(b[i][0] + "|" + b[i][1] + "|" + b[i][2]);
            if (i < 2) System.out.println("-+-+-");
        }
    }

    // check rows, cols, diags
    static boolean checkWin(char[][] b, char p) {
        for (int i = 0; i < 3; i++) {
            if ((b[i][0] == p && b[i][1] == p && b[i][2] == p) ||
                (b[0][i] == p && b[1][i] == p && b[2][i] == p)) {
                return true;
            }
        }
        if ((b[0][0] == p && b[1][1] == p && b[2][2] == p) ||
            (b[0][2] == p && b[1][1] == p && b[2][0] == p)) {
            return true;
        }
        return false;
    }

    // check if board is full
    static boolean isFull(char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
