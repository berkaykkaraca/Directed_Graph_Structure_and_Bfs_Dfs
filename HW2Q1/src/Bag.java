// filename: Bag.java -- a generic class Bag<T> form the class 10/12.
//
// Note that this code _does compile_, but a compiler may show warnings
// ("warning: [unchecked] unchecked cast") -- you can ignore that.


import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	//-----------------------------------------------------
		// Title: Bag class
		// Author: Berkay Kaan Karaca
		// ID: 68317070956
		
		// Section: 1
		// Assignment: 1
		// Description: this class is responsible for implementin Bag in the graph
		//-----------------------------------------------------
  // instance variables
  private final int MAXLEN = 3;
  private int size;
  private T[] data; // array

  // public methods

  public Bag() {
    data = (T[]) new Object[MAXLEN]; // instantiate an array of length MAXLEN
    size = 0;
  }

  public void add(T newItem) {

    // The code below implements an extendable data array.

    if (size == data.length) {
      // (1) allocate a new/temp array of twice the size
      T[] temp = (T[]) new Object[data.length*2]; //empty temporary array
      // (2) copy from old/data to new/temp array
      for (int i = 0; i < size; ++i) {
        temp[i] = data[i];
      }
      // (3) make data point to the new/temp array
      data = temp;
    }

    data[size++] = newItem; // assign the new item in the next available/empty
                            // slot and increment 'size' as well
  }
  

  public int size() {
    return size;
  }

  //********************************************
  //  WRITE YOUE CODE BELOW (1)
  //********************************************











  // iterator() method from Java Iterable interface
  public Iterator<T> iterator() {
    // 1. Create an object of a class which implements Iterator,
    //    which "points to" the beginning of data array.
    // 2. Return the object.
    return new BagIterator(); // call default constructor of BagIterator
  }

  //-----------------------------------------------
  // inner/nested class BagIterator to traverse Bag
  //-----------------------------------------------
  class BagIterator implements Iterator<T> {
    // instance variable
    private int idx;

    // public methods
    public BagIterator() {
      idx = 0;
    }

    public boolean hasNext() {
      if (idx < size)
        return true;
      else
        return false;
    }

    public T next( ) {
      T val = data[idx]; // (1) save element at the current idx in data
      idx++;             // (2) increment idx
      return val;        // (3) return the value
    }

    public void remove( ) {}  // ignore for now
  }
  //----- end inner/nested class BagIterator

  //********************************************
  //  WRITE YOUE CODE BELOW (2)
  //
  //  main()
  //********************************************
 
}