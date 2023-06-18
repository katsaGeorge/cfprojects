package ch10;

/**
 * A system that book or cancel a seat in a theater until
 * a specify time and date or if the seats are all booked.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Porject10 {
    static boolean[][] seats = new boolean[30][12];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final LocalDate CURRENT_DATE = LocalDate.now();
        final LocalTime CURRENT_TIME = LocalTime.now();
        LocalDate targetDate = LocalDate.of(2023, 7, 10);
        LocalTime targetTime = LocalTime.of(19, 30);
        char columnSeat;
        String response = " ";

        // Run the program until the specified target date and time, and seats are not full

        while ((CURRENT_DATE.isBefore(targetDate) && CURRENT_TIME.isBefore(targetTime) && (!isFull(seats)))) {

            System.out.println("Welcome  if you want to book a seat please press B. If you want to cancel a seat please press C");

            response = in.nextLine().trim();

            if (response.matches("[Bb]")) {

                System.out.println("Please choose a row between 1-30 and a column between A-L");
                int row = in.nextInt();
                int col = in.next().charAt(0);

                if (exists(row, col,seats)) {
                    columnSeat = (char) col;
                    book(columnSeat, row);
                }else{
                    System.out.println("This seat is already booked please choose another one");
                    in.nextLine();
                    continue;

                }

            } else if (response.matches("[Cc]")) {

                System.out.println("Please provide a row between 1-30 and your column betwwen A-L to cancel the seat");
                int row = in.nextInt();
                int col = in.next().charAt(0);
                in.nextLine();
                if (!exists(row, col,seats)) {
                    columnSeat = (char) col;
                    cancel(columnSeat, row);
                }else{
                    System.out.println("This seat isn't booked please choose the right seat");
                    in.nextLine();
                    continue;
                }
              } else {
                System.out.println("Please give a valid option");
            }

                in.nextLine();
        }


    }

    /**
     *  book a seat
     * @param column
     * @param row
     */
    public static void book(char column, int row) {

        int realRow = row - 1;
        int colSeat = (int) column;
        colSeat = colSeat - 65;

        seats[realRow][colSeat] = true;
        System.out.println("Succesfull book");

    }

    /**\
     * cancel a seat
     * @param column
     * @param row
     */
    public static void cancel(char column, int row) {

        int realRow = row - 1;
        int colSeat = (int) column;
        colSeat = colSeat - 65;

        seats[realRow][colSeat] = true;
        System.out.println("Succesfull cancel");

    }

    /**
     * check if the array is full
     * @param arr
     * @return
     */

    public static boolean isFull(boolean[][] arr) {

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 12; j++) {
                if (!arr[i][j]) {
                    return false;
                }

            }

        }
        System.out.println("All the seats are booked");
        return true;
    }

    /**
     * checks if the seat that has been given has already exists.
     * @param row
     * @param col
     * @param seats
     * @return
     */
    public static boolean exists(int row, int col, boolean[][] seats) {
            int column = col -65;
        System.out.println(column);
            row = row-1;
        if (!seats[row][column]) {
            return true;
        }

        return false;

    }
}

