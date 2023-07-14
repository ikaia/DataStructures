package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DriverPA4 {
	
	static int[] inputArray; // Array elements for QuickSort operation
	
	// Helper functions
	static void prepareInputDataFromText(String filename) throws FileNotFoundException, IOException{
			
		File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        String input = sc.nextLine();
        String[] strs = input.trim().split("\\s+");
        inputArray = new int[strs.length];
        StringArrToIntArr(inputArray, strs, 0);
        //System.out.println("inputArray " + Arrays.toString(inputArray));
        
        sc.close();
    }
	
	// Helper functions
	public static void StringArrToIntArr(int[] arr, String[] s, int startingindex) {
		
		//startingindex is the index from where we are populating the array from input file
		for (int i = 0, j = startingindex; i < s.length; i++, j++) {
			arr[j] = Integer.parseInt(s[i]);
	    }
	}
	
	/* A utility function to print array of size n */
    static String printArray(int arr[])
    {
        String result = "";
    	for (int i = 0; i < arr.length; i++)
            result = result + arr[i] + " ";
        
    	return result.trim();
    }
	
	public static void main(String[] arg) throws FileNotFoundException, IOException{
	    
		// Read the file and generate output
		// Change the filename according to your need for testing purpose
		String fileName = "qs0.txt";
		prepareInputDataFromText(fileName);
		
		QuickSort qs = new QuickSort();
		
		int[] clonnedArrForPartitionCheck = inputArray.clone();
		int pivotPosition = qs.inPlacePartition(clonnedArrForPartitionCheck, 0, clonnedArrForPartitionCheck.length - 1);
		System.out.println(pivotPosition);
		
		// Gradescope will only evaluate the contents of the array for the first partition operation
		String firstPartitionOperationOutput = printArray(clonnedArrForPartitionCheck);
		System.out.println(firstPartitionOperationOutput);
		
		String quickSortOperationOutput = qs.quickSortOperation(inputArray);
		System.out.println(quickSortOperationOutput);

	}

}

