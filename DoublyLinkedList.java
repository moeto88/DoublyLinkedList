import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;



		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	public int size = 0;



	/**
	 * Constructor of an empty DLL
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic running time cost: θ(1)
	 *
	 * Justification:
	 * There is no loop in this method and there are only constant operations, 
	 * which means θ(1) is the worst-case asymptotic running time cost.
	 */
	public boolean isEmpty()
	{
		if(head == null)
		{
			size = 0;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * Worst-case asymptotic running time cost: θ(N)
	 *
	 * Justification:
	 *  There are if and else statements in this method, which is θ(1) constantly.
	 *  In one else statement, there is only one for-loop, which takes pos (N) and this means θ(N) for this for-loop.
	 *  There are only constant statements in this for-loop and this is why θ(N) is the running time inside of this loop.
	 *  Finally, θ(1) + θ(N) = θ(N) and this will be the worst-case asymptotic running time cost.
	 */
	public void insertBefore( int pos, T data ) 
	{
		DLLNode newNode = new DLLNode(data, null, null);


		if(isEmpty())
		{
			head = tail = newNode;
		}
		else
		{
			if(pos <= 0)
			{
				newNode.next = head;
				newNode.prev = null;
				head.prev = newNode;
				head = newNode;
			}
			else if(pos >= size)
			{
				newNode.prev = tail;
				newNode.next = null;
				tail.next = newNode;
				tail = newNode;
			}
			else
			{
				DLLNode curr = head;
				DLLNode tmpNode = null;
				for(int i = 0; i < pos; i++)
				{
					tmpNode = curr.next;
					curr = tmpNode;
				}
				tmpNode.prev.next = newNode;
				newNode.prev = tmpNode.prev;
				tmpNode.prev = newNode;
				newNode.next = tmpNode;
			}
		}
		size++;

	}

	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic running time cost: θ(N)
	 *
	 * Justification:
	 *  There are if and else statements in this method, which is θ(1) constantly.
	 *  In one else-if statement, there is only one for-loop, which takes pos (N-1) and this means θ(N-1) for this for-loop.
	 *  There are only constant statements in this for-loop and this is why θ(N) is the running time inside of this loop.
	 *  Finally, θ(1) + θ(N) = θ(N) and this will be the worst-case asymptotic running time cost.
	 *
	 */
	public T get(int pos) 
	{

		if(isEmpty())
		{
			return null;
		}
		else
		{
			if(pos == 0)
			{
				return head.data;
			}
			else if(pos == size - 1)
			{
				return tail.data;
			}
			else if(0 < pos && pos < size - 1)
			{
				DLLNode curr = head;
				DLLNode tmpNode = null;
				for(int i = 0; i < pos; i++)
				{
					tmpNode = curr.next;
					curr = tmpNode;
				}
				return tmpNode.data;
			}
			else
			{
				return null;
			}
		}
	}

	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 * Worst-case asymptotic running time cost: TODO
	 *
	 * Justification:
	 *  There are if and else statements in this method, which is θ(1) constantly.
	 *  In one else-if statement, there is only one for-loop, which takes pos (N-1) and this means θ(N-1) for this for-loop.
	 *  There are only constant statements in this for-loop and this is why θ(N) is the running time inside of this loop.
	 *  Finally, θ(1) + θ(N) = θ(N) and this will be the worst-case asymptotic running time cost.
	 */
	public boolean deleteAt(int pos) 
	{
		DLLNode test = null;
		if(isEmpty())
		{
			return false;
		}
		else
		{
			if(pos == 0)
			{
				head = head.next;
				size--;
				return true;
			}
			else if(pos > 0 && pos < size - 1)
			{
				DLLNode curr = head;
				DLLNode tmpNode = null;
				for(int i = 0; i < pos; i++)
				{
					tmpNode = curr.next;
					curr = tmpNode;
				}
				tmpNode.prev.next = tmpNode.next;
				tmpNode.next.prev = tmpNode.prev;
				size--;
				return true;
			}
			else if(pos == size - 1)
			{
				if(pos == 1)
				{
					head.next = null;
					tail = head;
					tail.next = null;
					size--;
				}
				else
				{
					tail = tail.prev;
					tail.next = null;
					size--;
				}
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: θ(N)
	 *
	 * Justification:
	 *  The first if statement is a constant operartion, which means θ(1).
	 *  In this statement, there are two while statements and they are not a nested loop, which means θ(N) for each while-loop.
	 *  Finally, θ(1) + θ(N) + θ(N) = θ(N) and this will be the worst-case asymptotic running time cost.
	 */
	public void reverse()
	{
		if(isEmpty())
		{
			return;
		}
		else if(head.next == null)
		{
			return;
		}
		else 		{
			DLLNode curr = head;
			DLLNode tmpNode = null;
			while(curr != null)
			{
				tmpNode = curr.prev;
				curr.prev = curr.next;
				curr.next = tmpNode;
				curr = curr.prev;
			}
			head = tmpNode.prev;

			curr = head;
			while(curr.next != null)
			{
				curr = curr.next;
			}
			tail = curr;
		}
	}

	/**
	 * Removes all duplicate elements from the list.
	 * The method should remove the _least_number_ of elements to make all elements uniqueue.
	 * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
	 * Then it should contain "A", "B", "C", "D" after it returns. A, A, B, C, D, E
	 * The relative order of elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: θ(N^2)
	 *
	 * Justification:
	 *  There are two if statements before going to for-loop and they are constant operations, which means θ(1).
	 *  In the 2nd if statement, there is one nested for-loop and the inside of the 2nd for-loop is θ(N^2).
	 *  There are only constant operations in the 2nd for-loop and this is why θ(N^2) is the running time inside of this loop.
	 *  Finally, θ(1) + θ(N^2) = θ(N^2) and this will be he worst-case asymptotic running time cost.
	 */
	public void makeUnique()
	{
		if(!isEmpty())
		{
			if(head.next != null)
			{
				DLLNode tmpNode = null;
				DLLNode cmpNode = null;
				for(tmpNode = head; tmpNode != null; tmpNode = tmpNode.next)
				{
					for(cmpNode = tmpNode.next; cmpNode != null; cmpNode = cmpNode.next)
					{
						if(tmpNode.data == cmpNode.data)
						{
							size--;
							cmpNode.prev.next = cmpNode.next;
							if(cmpNode.next != null)
							{
								cmpNode.next.prev = cmpNode.prev;
							}
							else
							{
								tail = cmpNode;
								tail.next = null;
								System.out.println("Tail is" + tail.data);
								System.out.println("Head is" + head.data);
							}
						}
					}
				}
			}

		}
	}


	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic running time cost: θ(1)
	 *
	 * Justification:
	 *  There is no loop in this method and there are only constant operations, 
	 *  which means θ(1) is the worst-case asymptotic running time cost.
	 */
	public void push(T item) 
	{
		DLLNode newNode = new DLLNode(item, null, null);
		newNode.next = head;
		head = newNode;
	}

	/**
	 * This method returns and removes the element that was most recently added by the push method.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: θ(1)
	 *
	 * Justification:
	 *  There is no loop in this method and there are only constant operations, 
	 *  which means θ(1) is the worst-case asymptotic running time cost.
	 */
	public T pop() 
	{
		if(!isEmpty())
		{
			if(head.next != null)
			{
				DLLNode tmp = head;
				head = head.next;
				head.prev = null;
				return tmp.data;
			}
			else
			{
				DLLNode tmp = head;
				head = null;
				return tmp.data;
			}
		}
		else
			return null;
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic running time cost: θ(1)
	 *
	 * Justification:
	 *  There is no loop in this method and there are only constant operations, 
	 *  which means θ(1) is the worst-case asymptotic running time cost.
	 */
	public void enqueue(T item) 
	{
		DLLNode newNode = new DLLNode(item, null, null);
		if(isEmpty())
		{
			head = tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by the enqueue method.
	 * @return the earliest item inserted with an enqueue; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: θ(1)
	 *
	 * Justification:
	 *  There is no loop in this method and there are only constant operations, 
	 *  which means θ(1) is the worst-case asymptotic running time cost.
	 */
	public T dequeue() 
	{
		if(!isEmpty())
		{
			DLLNode tmp = head;
			if(head == tail)
			{
				head = tail = null;
			}
			else
			{
				head = head.next;
				head.prev = null;
			}
			return tmp.data;
		}
		else
			return null;
	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic running time cost:   Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 */
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true; 

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}


}


