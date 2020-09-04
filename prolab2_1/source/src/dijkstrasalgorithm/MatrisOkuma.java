/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrasalgorithm;

/**
 *
 * @author AhmetFurkan
 */



import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class MatrisOkuma {
   public static void matrisOku(int [][]myArray) throws Exception {
      Scanner sc = new Scanner(new BufferedReader(new FileReader("sample.txt")));

      while(sc.hasNextLine()) {
         for (int i=0; i<myArray.length; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<line.length; j++) {
               myArray[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
   }
}

