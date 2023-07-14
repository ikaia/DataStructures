package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DriverPA2 {

	private static int size;
	static int[] inputArray; // Array elements to be modified and for generating MinHeap
	static int[] newElementsArray; // New elements to be inserted in the Heap

	// Helper functions
	static void prepareInputDataFromText(String filename) throws FileNotFoundException, IOException{

		File file = new File(filename);
		Scanner sc = new Scanner(file);

		String size_n = sc.nextLine();

		size = Integer.parseInt(size_n);

		// Allocating the array for convenience
		inputArray = new int[2*size + 10];

		String input = sc.nextLine();
		String[] strs = input.trim().split("\\s+");
		StringArrToIntArr(inputArray, strs, 1);

		input = sc.nextLine();
		strs = input.trim().split("\\s+");
		newElementsArray = new int[strs.length];
		StringArrToIntArr(newElementsArray, strs, 0);

		sc.close();
	}

	// Helper functions to populate array according to the need
	public static void StringArrToIntArr(int[] arr, String[] s, int startingindex) {

		//startingindex is the index from where we are populating the array from input file
		for (int i = 0, j = startingindex; i < s.length; i++, j++) {
			arr[j] = Integer.parseInt(s[i]);
		}
	}


	public static void main(String[] arg) throws FileNotFoundException, IOException{

		// Read the file and generate output
		// Change the filename according to your need for testing purpose
		String fileName = "minheap0.txt";
		prepareInputDataFromText(fileName);

		MinHeap minHeapObj = new MinHeap();
		String[] generatedResults = minHeapObj.MinHeapOperations(inputArray, newElementsArray, size);

	}

}