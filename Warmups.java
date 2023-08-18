package HacherRank_Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Warmups {
    public static void main(String[] args) {
        System.out.println(timeConversion("12:00:00PM"));
    }

    // Array Sum
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int sum = 0;
        for (int i = 0; i < ar.size(); i++) {
            sum = sum + ar.get(i);
        }
        return sum;
    }

    //compare the triplets
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceTotalScore =0;
        int bobTotalScore =0;
        for (int i = 0; i < 3; i++) {
            int aliceScore=a.get(i);
            int bobScore=b.get(i);
            if(aliceScore != bobScore){
                int temp= aliceScore > bobScore ? aliceTotalScore++ : bobTotalScore++ ;
            }
        }
        ArrayList<Integer> list =new ArrayList<>();
        list.add(aliceTotalScore);
        list.add(bobTotalScore);
        return list;
     }

     // A very big sum
     public static long aVeryBigSum(List<Long> ar) {
         // Write your code here
         long sum=0;
         for (int i = 0; i < ar.size(); i++) {
             sum=ar.get(i)+sum;
         }
         return sum;
         }

      // Diagonal Difference
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rightToLeft =0;
        int leftToRight =0;
        for (int i = 0; i < arr.size(); i++) {
            rightToLeft += arr.get(i).get(i);                // first diagonal sum ex: rtol =arr(0)(0)+arr(1)(1)+arr(2)(2)
            leftToRight += arr.get(i).get(arr.size()-(i+1)); // second diagonal sum ex: ltor =arr(0)(2)+arr(1)(1)+arr(2)(0)
        }
        return Math.abs(rightToLeft-leftToRight);
    }

     //plus minus
     public static void plusMinus(List<Integer> arr) {
         // Write your code here
         float pvalues=0;
         float nvalues=0;
         float zeros =0;
         for (int n: arr) {
             if(n>0){
                 pvalues++;
             }
             else if(n<0){
                 nvalues++;
             }else{
                 zeros++;
             }
         }
         float n = arr.size();
         System.out.printf("%.6f\n",pvalues/n);
         System.out.printf("%.6f\n",nvalues/n);
         System.out.printf("%.6f\n",zeros/n);

     }

     //Minimax
     public static void miniMaxSum(List<Integer> arr) {
         // Write your code here
         long min=arr.get(0);
         long max=arr.get(0);
         long sum =0;
         for(int n: arr){
             sum +=n;
             if(n>min) min=n;
             if(n<max) max=n;
         }
         System.out.println((sum-min)+" "+(sum-max));
     }

     //Time Conversion
     public static String timeConversion(String s) {
         int hours = Integer.parseInt(s.substring(0, 2)); // indicates the first two elements in the string ex 12 from hours
         String ampm = s.substring(8);   //it indicates the first 8 elements from the given time

         if (ampm.equals("AM")) {
             if (hours == 12) {
                 return "00" + s.substring(2, 8); //if its 12 Am then in military its starts with 00 at the hours
             } else {
                 return s.substring(0, 8);
             }
         } else {
             if (hours == 12) {
                 return s.substring(0, 8);
             } else {
                 return (hours + 12) + s.substring(2, 8);
             }
         }
     }

     //staircase pattern
     public static void staircase(int n) {
         // Write your code here
         for (int row = 1; row <= n ; row++) { // indicates the row size
             for (int space = n-1; space >= row; space--) {   //indicates the area the blank space to be included
                 System.out.print(" ");
             }
             for (int col = 1; col <= row ; col++) {    //indicates the columns
                 System.out.print("#");
             }
             System.out.println();
         }

     }

     //Birthday cake candles
     public static int birthdayCakeCandles(List<Integer> candles) {
         // Write your code here
         int max=Integer.MIN_VALUE;  //returns the minimum value in an array
         int maxcount=0;             //count of the maximum numbers
         for (Integer n: candles) {
             if(n>max)               //if n > maximum then maximum = number
                 max=n;
         }
         for (Integer n: candles) {
             if(n==max)              //if number of elements equal to maximum number
                 maxcount++;         //count of maximum increases
         }
         return maxcount;
     }
}

