
/**
 * This class is an array that checks for duplicate items.
 * @author sammi
 *
 * @param <T> Generic type T
 */
public class UniqueArray <T> {
	
	// make 2 instance variables
	// array of generic type T
	private T[] array;
	// integer 
	private int num;
	
	
	// constructor that initializes the array with 5 slots
	public UniqueArray() {

		// initialize the array
		array = (T[])new Object[5];
		// set the counter for number of elements to 0
		num = 0;
	}
	
	
	// setter method to increase the capacity of the array
	private void expandCapacity() {
		
		// make a temporary array of type T that's 5 slots larger than the array we want to expand
		T[] largerArray = (T[]) new Object[array.length + 5];
		
		// copy over elements from existing array
		for (int i = 0; i < array.length; i++) {
			largerArray[i] = array[i];
		}
		
		// set the current array equal to the temporary array
		array = largerArray;
	}
	
	// setter method to add an item to the array
	public void addItem(T element) {

		
		// iterate over the array
		for (int i = 0; i < array.length; i++) {
			// if the given element is already within the array, don't add the element
			if (array[i] == element) {
				break;
			}
			// if it's not in the array
			else {
				// check if the current array slot is at the very end of the array (it will be if the array is full)
				if (i == array.length - 1) {
					// add the given element to the last remaining spot
					array[i] = element;
					// increment element counter
					num++;
					// expand the array's capacity by 5 slots
					expandCapacity();
					// break this loop so that excessive slots aren't added
					break;
				}
				else {
					// if the array isn't full, add the given element to the first available spot
					if (array[i] == null) {
						array[i] = element;
						// increment element counter
						num++;
						break;
					}
				}
			}
		}
		
	}
	
	
	// getter method to get the number of spots available in the array
	public int getLength() {
		// return the array length
		return array.length;
	}
	
	
	// getter method to get the number of spots filled in the array 
	public int getNumElements() {
		
		// return the element counter
		return num;
	}
	
	
	// toString method to return a formatted string with each of the elements in the array  
	public String toString() {
		
		// create an empty string
		String s = "";
		
		// loop through the array
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				
				// add elements to the array
				s += array[i];
			}
			
			// if it isn't at the end of the array, add a comma and space
			if (i < (getNumElements() - 1)) {
				s += ", ";
			}
		}
		
		// return the final string
		return s;
	}
	
	
}
