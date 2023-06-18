package ch10;
/**
 * Διαβάζει ένα αρχείο χαρακτηρα - χαρακτήρα και τους εισάγει σε εναν πινακα 296* 2. Εμφανίζει
 * ανα χαρακήρα στην αρχή (ταξινομημένο) και εν συνεχεία ανα ποσοστό
 * εμφάνισης ταξινομημένο.
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Project3 {

    public static void main(String[] args) {

        int [][] arr = new int[256][2];
        int pivot = 0;
        int counterCharacter = 0;

            try(BufferedReader bf = new BufferedReader(new FileReader("C:\\tmp\\project3.txt"))) {

                int character;
                int index;
                while((character = bf.read()) != -1){
                    counterCharacter++;

                    if ((index = characterExists( character, arr, pivot))!= -1){

                        arr[index][1]++;

                    }else{
                        if (pivot > 255) continue;
                            arr[pivot][0] = character;
                            arr[pivot][1] = 1;
                            pivot++;

                    }
                }

            }catch (IOException e){
            e.printStackTrace();
            }
            printArray(shortByChar(arr,pivot),pivot, counterCharacter);
            System.out.println();
            printArray(shortByFreq(arr,pivot),pivot,counterCharacter);



    }

    /**
     *
     * @param character the character that has been read
     * @param arr  the array
     * @param pivot the current position of array
     * @return the position of character if exists   -1 if not
     */
    public static int characterExists(int character, int[][] arr, int pivot){

            for (int i = 0; i <pivot; i++){
                if (arr[i][0] == character){
                    return i;
                }
            }
            return -1;
    }


    /*
    Prints the array
     */
    public static void printArray( int arr[][], int  pivot, int counterCharacter){

        for ( int i =0; i < pivot; i++ ){
            float freq = ((float)arr[i][1] / counterCharacter) * 100;
            System.out.println((char)arr[i][0]+" "+ " Frequency: "+ freq + "%");
        }

    }

    /*
    Shorts by Character
     */
    public static int[][] shortByChar(int[][] arr, int pivot){
        Arrays.sort(arr, 0, pivot,Comparator.comparing(a-> a[0]));
        return arr;
    }

    /*
    Shorts by frequency
     */
    public static int[][] shortByFreq(int[][] arr, int pivot){
        Arrays.sort(arr, 0, pivot,Comparator.comparing(a-> a[1]));
        return arr;
    }


}
