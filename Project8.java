package ch10;

import java.util.Scanner;

/**
 * Tik tak toe game
 */
public class Project8 {
    static int[][] arr = new int[3][3];
    final static int PLAYER_X = 1;
    final static int PLAYER_O = 2;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int player = PLAYER_X;
        int choice = 0;
        do {
            showTable();
            System.out.println("Player " + player + " Please make a move from 1 to 9");

            choice = getChoice();

            if (choice >= 1 && choice <= 9) {

                if (choiceProcess(choice, player)) {
                    System.out.println("Great");

                } else {
                    System.out.println("This position is already taken");
                    continue;
                }


            } else {
                System.out.println("Wrong choice please give valid number");
                continue;
            }

            if (win()) {
                System.out.println("Player "+player+ "wins");
                break;
            }
            if (tie()){
                System.out.println("Its a Tie");
                break;
            }
           player = changePlayer(player);

        } while (true);
    }

    /**
     *
     * @return the choice of each player
     */
    public static int getChoice() {
        int choice = in.nextInt();

        return choice;

    }

    /**
     *
     * @param choice the choic
     * @param player that is his turn
     * @return true in order to continue
     */
    public static boolean choiceProcess(int choice, int player) {

        switch (choice) {
            case 1:
                if (arr[0][0] == 0) {
                    arr[0][0] = player;
                    return true;
                }
                break;
            case 2:
                if (arr[0][1] == 0) {
                    arr[0][1] = player;
                    return true;
                }
                break;
            case 3:
                if (arr[0][2] == 0) {
                    arr[0][2] = player;
                    return true;
                }
                break;
            case 4:
                if (arr[1][0] == 0) {
                    arr[1][0] = player;
                    return true;
                }
            case 5:
                if (arr[1][1] == 0) {
                    arr[1][1] = player;
                    return true;
                }
                break;
            case 6:
                if (arr[1][2] == 0) {
                    arr[1][2] = player;
                    return true;
                }
                break;
            case 7:
                if (arr[2][0] == 0) {
                    arr[2][0] = player;
                    return true;
                }
                break;
            case 8:
                if (arr[2][1] == 0) {
                    arr[2][1] = player;
                    return true;
                }
                break;
            case 9:
                if (arr[2][2] == 0) {
                    arr[2][2] = player;
                    return true;
                }
                break;
        }

        return false;
    }

    /**
     * show the table with symbols
     */
    public static void showTable() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                if (arr[i][j] == 0) {
                    System.out.print(count + "  ");
                } else if (arr[i][j] == 1) {
                    System.out.print("X  ");

                } else
                    System.out.print("O  ");
            }
            System.out.println();
        }


    }

    /**
     * checks if the is a winner
     * @return true or false
     */

    public static boolean win() {

        return checkDiagonals() || checkColums() || checkRaws();

    }

    /**
     * checks if it is a tie
     * @return
     */
    public static boolean tie(){
        for (int i =0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean checkColums() {
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] != 0 && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRaws() {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] != 0 && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonals() {
        if (arr[0][0] != 0 && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
                return true;
        }
        if (arr[2][0] != 0 && arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
            return true;
        }

        return false;
    }

    /**
     * changes the player
     * @param player
     * @return
     */
    public static int changePlayer(int player){
        if (player == PLAYER_X){
            return PLAYER_O;
        }else {
            return PLAYER_X;
        }

    }
}