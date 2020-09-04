/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrasalgorithm;
import java.util.*;
import java.lang.*;

public class Permutasyon{

public static void permute1(int start, int[] input, int[] toplamDizi) throws Exception {

	
	int myArray[][] = new int[81][81];
	MatrisOkuma m = new MatrisOkuma();
	DijkstrasAlgorithm t = new DijkstrasAlgorithm();
	MatrisOkuma.matrisOku(myArray);
	
    if (start == input.length) {
        //System.out.println(input);
      	

      if(input[0]==input[input.length-1]){
       
       t.dijkstra(myArray, input, toplamDizi);
 		
        }
        return;
    }
    for (int i = start; i < input.length; i++) {
        // swapping
        int temp = input[i];
        input[i] = input[start];
        input[start] = temp;
        // swap(input[i], input[start]);

        permute1(start + 1, input, toplamDizi);
        // swap(input[i],input[start]);

        int temp2 = input[i];
        input[i] = input[start];
        input[start] = temp2;
    }
    
}

public static void permute2(int start, int[] dizi, int[] toplamDizi) throws Exception {

	int myArray[][] = new int[81][81];
	MatrisOkuma m = new MatrisOkuma();
	DijkstrasAlgorithm t = new DijkstrasAlgorithm();
	MatrisOkuma.matrisOku(myArray);

    int sayac = 0;

    while(sayac<(dizi.length)) {

        for(int i=start+1; i<dizi.length-1; i++){
            int temp = dizi[start];
            dizi[start] = dizi[i];
            dizi[i] = temp;

            t.dijkstra(myArray, dizi, toplamDizi);
            
            if(i==dizi.length-1){
                start=1;
                i=start+1;
                continue;
            }
            
        }
        if(start == dizi.length-1){
            
                start = 1;
                sayac++;
                continue;
            
        }
        start +=1;
        sayac++;
    }

	
}




}
