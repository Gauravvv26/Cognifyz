import java.util.Scanner;

public class TicTacToe
{
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            resetBoard();
            int moves = 0;
            boolean gameWon = false;
            while (!gameWon && moves < 9) {
                printBoard();
                System.out.println("Player " + currentPlayer + " enter row and column: ");
                int row = scanner.nextInt(), col = scanner.nextInt();
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moves++;
                    gameWon = checkWin();
                    if (gameWon) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            if (!gameWon) {
                printBoard();
                System.out.println("It's a draw!");
            }
            System.out.println("Play again? (true/false)");
            playAgain = scanner.nextBoolean();
        } while (playAgain);
        scanner.close();
    }

    private static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}
