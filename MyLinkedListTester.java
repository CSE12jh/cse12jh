package hw2Part1;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;


/**
 *  Title: class LinkedListTester
 *  Description: JUnit test class for LinkedList class
 *  @author Philip Papadopoulos, Christine Alvarado
 *  @version 3.0 05-April-2015
 * */

/*
 * You should modify the information above to add your names and CSE12 accounts.
 * 
 * We have provided 7 tests to help you get familiar. 
 *
 * As a part of the Milestone submission, you have to add 10 new tests.
 * These tests will ONLY be graded against the correcCollectionst implementation of MyLinkedList.
 * However, you will also be given feedback on how your tests behave on the 
 * buggy implementation of MyLinkedList. 
 *
 * After the Milestone submission, you will be able to view each other's tests which you
 * can use to add or improve your tests for the final submission. At the final submission,
 * if you are using someone else's tests, we expect you to give the required attribution.
 * We also expect you to write a README file that explains in greater detail why you used
 * the test. 
 * 
 * For the Final Submission, your tests will be graded against both the correct and
 * buggy implementation of MyLinkedList. At the time of final submission, you will be
 * given feedback on how your tests behave against few but not all, buggy implementations.
 *
 * Finally, when your tester is complete, you will rename it MyLinkedListTester.java 
 * (renaming LinkedList to MyLinkedList everywhere in the file) so that you can
 * use it to test your MyLinkedList and MyListIterator classes.
 */
public class LinkedListTester
{
  private LinkedList<Integer> empty ;
  private LinkedList<Integer> one ;
  private LinkedList<Integer> several ;
  private LinkedList<String>  slist ;
  static final int DIM = 5;
  static final int FIBMAX = 30;
  
  /**
   * Standard Test Fixture. An empty list, a list with one entry (0) and 
   * a list with several entries (0,1,2)
   */ 
  @Before
  public void setUp()
  {
    empty = new LinkedList<Integer>();
    one = new LinkedList<Integer>();
    one.add(0,new Integer(0));
    several = new LinkedList<Integer>() ;
    // List: 1,2,3,...,Dim
    for (int i = DIM; i > 0; i--)
      several.add(0,new Integer(i));
    
    // List: "First","Last"
    slist = new LinkedList<String>();
    slist.add(0,"First");
    slist.add(1,"Last");
  }
  /** Test if heads of the lists are correct */
  @Test
  public void testGetHead()
  {
    assertEquals("Check 0",new Integer(0),one.get(0)) ;
    assertEquals("Check 0",new Integer(1),several.get(0)) ;
  }
  
  /** Test if size of lists are correct */
  @Test
  public void testListSize()
  {
    assertEquals("Check Empty Size",0,empty.size()) ;
    assertEquals("Check One Size",1,one.size()) ;
    assertEquals("Check Several Size",DIM,several.size()) ;
  }
  
  /** Test setting a specific entry */
  @Test
  public void testSet()
  {
    slist.set(1,"Final");
    assertEquals("Setting specific value", "Final",slist.get(1));
  }
  
  /** Test isEmpty */
  @Test
  public void testEmpty()
  {
    assertTrue("empty is empty",empty.isEmpty()) ;
    assertTrue("one is not empty",!one.isEmpty()) ;
    assertTrue("several is not empty",!several.isEmpty()) ;
  }

  /** Test out of bounds exception on get */
  @Test
  public void testGetException()
  {
    try 
    {
      empty.get(0);
      // This is how you can test when an exception is supposed 
      // to be thrown
      fail("Should have generated an exception");  
    }
    catch(IndexOutOfBoundsException e)
    {
      //  normal
    }
  }

  
  /** Test iterator on empty list and several list */
  @Test
  public void testIterator()
  {
    int counter = 0 ;
    ListIterator<Integer> iter;
    for (iter = empty.listIterator() ; iter.hasNext(); )
    {
      fail("Iterating empty list and found element") ;
    }
    counter = 0 ;
    for (iter = several.listIterator() ; iter.hasNext(); iter.next())
      counter++;
    assertEquals("Iterator several count", counter, DIM);
  }
  
  
  /** test Iterator Fibonacci.
    * This is a more holistic test for the iterator.  You should add
    * several unit tests that do more targeted testing of the individual
    * iterator methods.  */
  @Test
  public void testIteratorFibonacci()
  {
    
    LinkedList<Integer> fib  = new LinkedList<Integer>();
    ListIterator<Integer> iter;
    // List: 0 1 1 2 3 5 8 13 ... 
    // Build the list with integers 1 .. FIBMAX
    int t, p = 0, q = 1;
    fib.add(0,p);
    fib.add(1,q);
    for (int k = 2; k <= FIBMAX; k++)
    {
      t = p+q;
      fib.add(k,t);
      p = q; q = t; 
    }
    // Now iterate through the list to near the middle, read the
    // previous two entries and verify the sum.
    iter = fib.listIterator();
    int sum = 0;
    for (int j = 1; j < FIBMAX/2; j++)
      sum = iter.next();
    iter.previous();
    assertEquals(iter.previous() + iter.previous(),sum);
    // Go forward with the list iterator
    assertEquals(iter.next() + iter.next(),sum);
  }
  /* Add your own tests here */
  
  //get index value
  @Test
  public void testGet()
  {
	  several.set(1, new Integer (4));
	 
	  assertEquals("Check the Specific Value ",(Integer)4,several.get(1));
  }
  
  //remove index value
  
  @Test
  public void testRemove()
  {
	  slist.add(1, new String("Second"));
	  slist.remove(1);
	  assertEquals("Check Remove Value in List", "Last", slist.get(1) );
  }
  
  //get the last value of linkList
  
  @Test
  public void getTail()
  {
	  assertEquals("Check Last Value",new Integer(0),one.get(one.size()-1)) ;
	  assertEquals("Check Last Value",new Integer(5),several.get(several.size()-1)) ;
  }
  
  //Make the linkedlist clean
  
  @Test
  public void testClear()
  {
	  several.clear();
	  assertEquals("Check Clear List", 0, several.size());
  }
  
  
  
  @Test
  public void testIndex()
  {
	  assertEquals("Find Index Specific Value Stored", 2, several.indexOf(3));
	  assertEquals("Find Index Specific Value Stored", 1, slist.indexOf("Last"));
  }
  @Test
  public void testArray()
  {
	 several.clear();
	 several.add(0,1);
	 several.add(1,4);
	 several.add(2,3);
	 several.add(3,2);
	 several.add(4,5);
	 several.add(5,7);
	 several.add(6,9);
	 several.add(7,6);
	 several.add(8,8);
	 
	 
	 Collections.sort(several);

	 assertEquals("Check Array sorted", (Integer)7,several.get(6));
  }
  @Test
  public void hasNext()
  {
     
      ListIterator<Integer> iter;
      iter = several.listIterator();     
      assertTrue("Check has next",iter.hasNext());
     
      }
  @Test
	public void hasPrevious()
    {

    ListIterator<Integer> iter;
    iter = several.listIterator();     
    iter.next();
    assertTrue("Check has previous",iter.hasPrevious());
     
    }

	@Test
	public void Next()
	{
     
      ListIterator<Integer> iter;
      iter = several.listIterator();     
      assertEquals("Check has next", (Integer) 1 ,iter.next());
     
      }
	@Test
	public void previous()
	{
     
     ListIterator<Integer> iter;
     iter = several.listIterator();
     iter.next();
     assertEquals("Check has next", (Integer) 1 ,iter.previous());
     
    }
}
