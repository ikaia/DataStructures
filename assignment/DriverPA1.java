package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DriverPA1 {
        
        static int[] inputArray; // Array elements to be modified and for generating Doubly Linked List
        
        // Helper functions
        static void prepareInputDataFromText(String filename) throws FileNotFoundException, IOException{
                        
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        String input = sc.nextLine();
        String[] strs = input.trim().split("\\s+");
        
        // Allocating the array for convenience
        inputArray = new int[strs.length];
        
        StringArrToIntArr(inputArray, strs, 0);
        //System.out.println("Data from File:" + Arrays.toString(inputArray));
        
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
                String fileName = "DLL0.txt";
                prepareInputDataFromText(fileName);
                
                // Initialization
                DoublyLinkedList list = new DoublyLinkedList();
                DoublyLinkedList list_copy = new DoublyLinkedList();
                LinkedListOperations listOps = new LinkedListOperations();
                String reversedListOutput = "";
                
                list.createDoublyLinkedList(inputArray);
                
                //currentList = list.printList();
                System.out.println("Doubly List: " + list.printList());
                
                // Copy the elements of the list to a new doubly linked list for further operations
                list_copy.copyList(list);
                
                listOps.reverseLinkedList(list);
                reversedListOutput = list.printList();
                System.out.println("Reversed List:" + reversedListOutput);
                
                //System.out.println("Original Doubly List: " + list_copy.printList());
                
                boolean isPalindromOutput = listOps.isPalindrome(list_copy);
                System.out.println(isPalindromOutput);

        }

}