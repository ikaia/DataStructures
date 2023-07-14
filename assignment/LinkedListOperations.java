package assignment;

import assignment.DoublyLinkedList.Node;

public class LinkedListOperations {
        
   
		public void reverseLinkedList(DoublyLinkedList list) {
			// TODO Auto-generated method stub
			/*** *** Write YOUR CODE HERE *** ***/
	        Node temp = null;
	        Node current = list.head;
	 
	        /* swap next and prev for all nodes of
	         doubly linked list */
	        while (current != null) {
	            temp = current.previous;
	            current.previous = current.next;
	            current.next = temp;
	            current = current.previous;
	        }
	 
	        /* Before changing head, check for the cases like
	         empty list and list with only one node */
	        if (temp != null) {
	            list.head = temp.previous;
	        }
			
		}
		
	     /*
         * Function to check if list is palindrome or not
         * A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam or racecar.
         * Return the boolean result of your implementation
         */
		public boolean isPalindrome(DoublyLinkedList list) {
			// TODO Auto-generated method stub
			
			DoublyLinkedList a = new DoublyLinkedList();
			a.copyList(list);
			
			reverseLinkedList(a);
			
			Node n = list.head;
			Node m = a.head;
			
			while (n.next != null) {
				if (n.data != m.data) {
					return false;
				}
				n = n.next;
				m = m.next;
				
		
			}
			 return true;
			 
			
			
			
			
		}


        /* 
         * Function to reverse the Doubly linked list 
         * Details of the Doubly Linked List are in the file DoublyLinkedList.java
         * Reverse the provided list
    */   }




