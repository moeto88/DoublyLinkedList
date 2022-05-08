import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        //System.out.print(testDLL.size);
        testDLL.insertBefore(1,2);
        //System.out.print(testDLL.size);
        testDLL.insertBefore(2,3);
        //System.out.print(testDLL.size);
        
        assertEquals("Checking get at position 0 with a list containing 3 elements", "1", testDLL.get(0).toString());
       
        assertEquals("Checking get at position 1 with a list containing 3 elements", "2",  testDLL.get(1).toString());
        
        assertEquals("Checking get at position 2 with a list containing 3 elements", "3", testDLL.get(2).toString());
   
        assertEquals("Checking get at position 3 with a list containing 3 elements", null, testDLL.get(3));
        
        assertEquals("Checking get at position -1 with a list containing 3 elements", null, testDLL.get(-1));
        
        
        testDLL = new DoublyLinkedList<Integer>();
        assertEquals("Checking get at position 3 with an empty list", null, testDLL.get(3));
    }
    
    
    @Test
    public void testDeleteAt()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        
        //System.out.println(testDLL.toString());
        //System.out.println(testDLL.size);
        
        testDLL.deleteAt(0);
        //System.out.println(testDLL.toString());
        //System.out.println(testDLL.size);
        assertEquals("Checking deleteAt at position 0 (head) with a list containing 5 elements", "2,3,4,5", testDLL.toString());
        
        //System.out.print(testDLL.head.data);
        
        testDLL.deleteAt(1);
        //System.out.println(testDLL.toString());
        //System.out.println(testDLL.size);
        assertEquals("Checking deleteAt at position 1 with a list containing 4 elements", "2,4,5", testDLL.toString());
        
        
        testDLL.deleteAt(2);
        //System.out.println(testDLL.toString());
        //System.out.println(testDLL.size);
        assertEquals("Checking deleteAt at position 2 (tail) with a list containing 3 elements", "2,4", testDLL.toString());
        
        
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.deleteAt(2);
        assertEquals("Checking deleteAt at position 1 with an empty list", "", testDLL.toString());
    }
    
    
    @Test
    public void testReverse() 
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        
        testDLL.reverse();
        assertEquals("Checking reverse with a list containing 5 elements", "5,4,3,2,1", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals("Checking reverse with a list containing only one element", "1", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        assertEquals("Checking reverse with an empty list", "", testDLL.toString());
    }
    
    
    //@Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,1);
        testDLL.insertBefore(4,4);
        testDLL.insertBefore(5,2);
        testDLL.insertBefore(6,1);
        
        testDLL.makeUnique();
        assertEquals("Checking makeUnique with a list containing 7 elements where there are three ones and two twos", "1,2,3,4", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.makeUnique();
        assertEquals("Checking makeUnique with an empty list", "", testDLL.toString());
        
        testDLL.insertBefore(0,1);
        testDLL.makeUnique();
        assertEquals("Checking makeUnique with a list containing inl", "1", testDLL.toString());
    }
    
    
    @Test
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(0);
    	testDLL.push(1);
    	testDLL.push(2);
    	assertEquals("Checking push with pushing 3 elements", "2,1,0", testDLL.toString());
    }
    
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(0);
    	testDLL.push(1);
    	testDLL.push(2);
    	
    	assertEquals("Checking pop with poping 1 element from a list containing 3 elements", "2", testDLL.pop().toString());
    	assertEquals("Checking pop with poping 1 element from a list containing 3 elements", "1,0", testDLL.toString());
    	
    	
    	testDLL = new DoublyLinkedList<Integer>();

    	assertEquals("Checking pop with poping 1 element from an empty list", null, testDLL.pop());
    	assertEquals("Checking pop with poping 1 element from an empty list", "", testDLL.toString());
    
    	testDLL.push(3);
    	//ystem.out.print(testDLL.toString());
    	assertEquals("Checking pop with poping 1 element from a list containing only one elemen", "3", testDLL.pop().toString());
    	assertEquals("Checking pop with poping 1 element from a list containing only one element", "", testDLL.toString());
    }
    
    
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(0);
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	assertEquals("Checking enqueue with enqueuing 3 elements", "0,1,2", testDLL.toString());
    }
    
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(0);
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	assertEquals("Checking dequeue with dequeuing 1 element from a list containing 3 elements", "0", testDLL.dequeue().toString());
    	assertEquals("Checking dequeue with dequeuing 1 element from a list containing 3 elements", "1,2", testDLL.toString());
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("Checking dequeue with dequeuing 1 element from an empty list", null, testDLL.dequeue());
    	assertEquals("Checking dequeue with dequeuing 1 element from an empty list", "", testDLL.toString());
    	
    	testDLL.enqueue(2);
    	assertEquals("Checking dequeue with dequeuing 1 element from a list containing only one elemen", "2", testDLL.dequeue().toString());
    	assertEquals("Checking dequeue with dequeuing 1 element from a list containing only one elemen", "", testDLL.toString());
    }
    
    @Test
    public void test()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,2);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,2);
        testDLL.insertBefore(3,1);
        testDLL.insertBefore(4,1);
        testDLL.insertBefore(5,2);
        testDLL.insertBefore(6,1);
        
        testDLL.makeUnique();
        assertEquals("2,1", testDLL.toString());
        
        testDLL.deleteAt(1);
        assertEquals("2", testDLL.toString());

    }
    
   
}
