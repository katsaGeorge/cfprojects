package ch10;
/**
 * Βρίσκει το μεγαλύτερο συνεχόμενο άθροισμα απο ακεραίους
 * σε έναν πίνακα και αποδίδει απο ποιο στοιχείο του πίνακα
 * αρχίζει και σε ποιο τελείωνει.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Project6 {

    public static void main(String[] args) {

        int[] arr = {0, 3, -4, -6, 7, 2, -3};

        int global = arr[0];
        int local = arr[0];
        int end = 0;
        int start = 0;
        for (int i = 1; i < arr.length; i++) {

            if (local + arr[i] < arr[i]) {
                local = arr[i];
                start = i;
            } else {
                local = local + arr[i];
            }
            if (local > global) {
                global = local;
                end = i;
            }

        }

        //Για να δείξω πιο όμορφα το subArray
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = start; i <= end; i++ ){
            arr2.add(arr[i]);
        }



        System.out.printf("The maximum continiously summary of ints is %d and the start " +
                "is in position %d, the end is in position %d\n",global , start, end);

        System.out.print(arr2);


          }
        }


