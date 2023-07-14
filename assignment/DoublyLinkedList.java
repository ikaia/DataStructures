package assignment;

public class DoublyLinkedList {

	//Initially, head and tail is set to null

	public Node head, tail = null;

	int size = 0;

	//A node class for doubly linked list

	public static class Node{

		int data;

		Node previous;

		Node next;

		public Node(int data) {

			this.data = data;

		}

	}

	/*

	 * Helper function to add a node to the list

	 */

	public void addNode(int data) {

		//Create a new node

		Node newNode = new Node(data);

		/*

		 * if list is empty, head and tail points to newNode; head's previous will be null ; tail's next will be null

		 * else add newNode to the end of list. tail->next set to newNode ; newNode->previous set to tail; newNode becomes new tail; tail's next point to null

		 */

		//

		if(head == null) {

			head = tail = newNode;

			head.previous = null;

			tail.next = null;

		}

		else {

			tail.next = newNode;

			newNode.previous = tail;

			tail = newNode;

			tail.next = null;

		}

		size++;

	}

	/*

	 * Helper function to print all the nodes of doubly linked list

	 */

	public String printList() {

		String printedList = "";

		//Node current will point to head

		Node current = head;

		if(head == null) {

			System.out.println("Doubly linked list is empty");

		}

		while(current != null) {

			printedList = printedList + current.data + " ";

			current = current.next;

		}

		return printedList.trim();

	}

	/*

	 * Helper Function for copying content of one doubly linked list to another doubly linked list

	 */

	public void copyList(DoublyLinkedList list) {

		Node temp = null;

		temp = list.head;

		//list_copy.addNode(temp.data);

		addNode(temp.data);

		while(temp.next != null) {

			temp = temp.next;

			//list_copy.addNode(temp.data);

			addNode(temp.data);

		}

	}

	/*

	 * Helper Function for create doubly linked list from input array

	 */

	public void createDoublyLinkedList(int[] inputarray) {

		// TODO Auto-generated method stub

		for(int i = 0; i < inputarray.length; i++) {

			addNode(inputarray[i]);

		}

	}

}