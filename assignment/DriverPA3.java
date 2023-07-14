package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DriverPA3 {
	
	static int[] inputArray; // Array elements for generating BST
	static int[] deleteElementsArray; // Elements to be deleted from the BST
	static int[] searchElementsArray; // Elements to be searched in the BST
	
	// Helper functions
	static void prepareInputDataFromText(String filename) throws FileNotFoundException, IOException{
			
		File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        String input = sc.nextLine();
        String[] strs = input.trim().split("\\s+");
        inputArray = new int[strs.length];
        StringArrToIntArr(inputArray, strs, 0);
        //System.out.println("inputArray " + Arrays.toString(inputArray));
        
        input = sc.nextLine();
        strs = input.trim().split("\\s+");
        deleteElementsArray = new int[strs.length];
        StringArrToIntArr(deleteElementsArray, strs, 0);
        //System.out.println("deleteElementsArray: " + Arrays.toString(deleteElementsArray));
        
        input = sc.nextLine();
        strs = input.trim().split("\\s+");
        searchElementsArray = new int[strs.length];
        StringArrToIntArr(searchElementsArray, strs, 0);
        //System.out.println("searchElement:" + searchElement);
        
        sc.close();
    }
	
	// Helper functions
	public static void StringArrToIntArr(int[] arr, String[] s, int startingindex) {
		
		//startingindex is the index from where we are populating the array from input file
		for (int i = 0, j = startingindex; i < s.length; i++, j++) {
			arr[j] = Integer.parseInt(s[i]);
	    }
	}
	
	
	public static void main(String[] arg) throws FileNotFoundException, IOException{
	    
		// Read the file and generate output
		// Change the filename according to your need for testing purpose
		
		String fileName = "bst0.txt";
		prepareInputDataFromText(fileName);
		
		
		BSTOperations bst = new BSTOperations();
		String insertOperationOutput = bst.insertOperationInBST(inputArray);
		System.out.println(insertOperationOutput);
		
		String deleteOperationOutput = bst.deleteOperationInBST(deleteElementsArray);
		System.out.println(deleteOperationOutput);
		
		String searchOperationOutput = bst.searchOperationInBST(searchElementsArray);
		System.out.println(searchOperationOutput);

	}

}

