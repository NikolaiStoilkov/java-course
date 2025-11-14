package JavaBasics;

import java.util.Scanner;

class TicTacToe {
    private Boolean isWinnerAvailable = false;
    private String[][] currentState = new String[3][6];
    private String currentPlayer = null;
    private Scanner scanner = new Scanner(System.in);

    public void main(String[] args) {
        // Prepare the game state
        fillWithEmptyValuesCurrentState();

        IO.println("Welcome to Tic Tac Toe!");
        IO.println("For help: -help");

        IO.print("Enter your sign: ");

        currentPlayer = verifyCurrentPlayer();

        while (!isWinnerAvailable) {
            gameCycle();
        }
    }

    private void help() {
        IO.println("Possible signs are: X or O");
        IO.println("Commands for selection position are: \n" +
                "            \"top-left\", \"top-center\", \"top-right\",\n" +
                "            \"center-left\", \"center\", \"center-right\",\n" +
                "            \"bottom-left\", \"bottom-center\", \"bottom-right\","
        );

        IO.println("To exit press Enter");

        scanner.nextLine();
    }

    private void gameCycle() {
        drawTable();

        String move = playersMove();

        addPlayersMoveToCurrentState(move);

        checkForWinner();

        if (isWinnerAvailable) {
            IO.println("Winner is " + currentPlayer + "!");

            System.exit(0);
            return;
        }

        changePlayers();
    }

    private void checkForWinner() {
        if (checkDiagonals() || checkHorizontalLines() || checkVerticalLines()) {
            isWinnerAvailable = true;
        }
    }

    private boolean checkDiagonals() {
        boolean leftToRightDiagonal = currentState[0][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        boolean rightToLeftDiagonal = currentState[0][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        return leftToRightDiagonal || rightToLeftDiagonal;

    }

    private boolean checkHorizontalLines() {
        boolean topHorizontalLine = currentState[0][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[0][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[0][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        boolean middleHorizontalLine = currentState[1][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        boolean bottomHorizontalLine = currentState[2][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        return topHorizontalLine || middleHorizontalLine || bottomHorizontalLine;
    }

    private boolean checkVerticalLines() {
        boolean leftVerticalLine = currentState[0][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][1]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        boolean middleVerticalLine = currentState[0][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][3]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        boolean rightVerticalLine = currentState[0][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[1][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim())
                && currentState[2][5]
                .trim()
                .equalsIgnoreCase(currentPlayer.trim());

        return leftVerticalLine || middleVerticalLine || rightVerticalLine;
    }

    private void addPlayersMoveToCurrentState(String move) {
        if (checkIfPositionIsTaken(move)) {
            IO.println("This position is already taken");
            gameCycle();
        }

        switch (move) {
            case "top-left":
                currentState[0][1] = currentPlayer;
                break;
            case "top-center":
                currentState[0][3] = currentPlayer;
                break;
            case "top-right":
                currentState[0][5] = currentPlayer;
                break;
            case "center-left":
                currentState[1][1] = currentPlayer;
                break;
            case "center":
                currentState[1][3] = currentPlayer;
                break;
            case "center-right":
                currentState[1][5] = currentPlayer;
                break;
            case "bottom-left":
                currentState[2][1] = currentPlayer;
                break;
            case "bottom-center":
                currentState[2][3] = currentPlayer;
                break;
            case "bottom-right":
                currentState[2][5] = currentPlayer;
                break;
            default:
                IO.println("Wrong position!");
                gameCycle();
        }
    }

    private void drawTable() {
        IO.println("Drawing the Tic Tac Toe table...");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                if (col % 2 == 0) {
                    IO.print("|   ");
                } else {
                    IO.print(currentState[row][col]);
                }
            }

            IO.println("|");
            IO.println("----------------------");
        }

    }

    private String playersMove() {
        IO.print("Your move: ");

        return scanner.nextLine();
    }

    private void changePlayers() {
        if (currentPlayer.trim().equals("x")) {
            currentPlayer = "o  ";
        } else {
            currentPlayer = "x  ";
        }
    }

    private void fillWithEmptyValuesCurrentState() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                if (col % 2 == 0) {
                    IO.print("|   ");
                } else {
                    currentState[row][col] = "  ";
                }

            }
        }
    }

    private String verifyCurrentPlayer() {
        String sign = scanner.nextLine();

        if (sign.equalsIgnoreCase("-help")) {
            help();
            main(null);
        }

        if (!sign.equals("x") && !sign.equals("o")) {
            throw new Error("Sign now allowed");
        }

        return sign + " ";
    }

    private Boolean checkIfPositionIsTaken(String position) {
        return switch (position) {
            case "top-left" -> !currentState[0][1]
                    .trim()
                    .isEmpty();
            case "top-center" -> !currentState[0][3]
                    .trim()
                    .isEmpty();
            case "top-right" -> !currentState[0][5]
                    .trim()
                    .isEmpty();
            case "center-left" -> !currentState[1][1]
                    .trim()
                    .isEmpty();
            case "center" -> !currentState[1][3]
                    .trim()
                    .isEmpty();
            case "center-right" -> !currentState[1][5]
                    .trim()
                    .isEmpty();
            case "bottom-left" -> !currentState[2][1]
                    .trim()
                    .isEmpty();
            case "bottom-center" -> !currentState[2][3]
                    .trim()
                    .isEmpty();
            case "bottom-right" -> !currentState[2][5]
                    .trim()
                    .isEmpty();
            default -> false;
        };

    }
}
