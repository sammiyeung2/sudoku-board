/**
 * This class represents the Sudoku board as an array of linked data structures.
 * @author sammi
 *
 */

public class Sudoku {
	
	// Create an Instance Variable representing the board as an an array of linked nodes
	private LinearNode<Integer>[] board;
	
	/**
	 * Constructor takes in a 2D array of the Sudoku's values and creates the board using Linear Nodes
	 * @param array
	 */
	public Sudoku(int[][] array) {
		
		// Initializes the board with 9 LinearNode slots
		board = new LinearNode[9];
		
		
		// looping through each of the 9 slots
		for (int row = 0; row < board.length; row++) {
		// initializing each slot with values from column 1 of the 2D array
			board[row] = new LinearNode<Integer>(array[row][0]);
			
			// create a pointer that starts at the left most node
			LinearNode<Integer> front = board[row];
			// create a pointer for the current node
			LinearNode<Integer> rowNode;
			
			// looping through the 2D array
			for (int col = 1; col < array.length; col++) {
				// create nodes and insert the corresponding values in from the appropriate row, col cell
				rowNode = new LinearNode<Integer>(array[row][col]);
				// connect the nodes
				front.setNext(rowNode);
				// adjust the front pointer
				front = rowNode;
			}
		}
		
	}
	
	
	/**
	 * Boolean method to check if the given row is valid (aka contains all 9 unique numbers from 1 to 9)
	 * @param row row number from 1 to 9
	 * @return true if the given row is valid; false if it is invalid
	 */
	public boolean isValidRow(int row) {
		
		// create a current pointer at the left most node; index row - 1 instead of row bc index runs from 0 to 8
		LinearNode<Integer> current = board[row - 1];
		// create a new Unique Array to hold all the values of the row and prepare it for unique-value scanning
		UniqueArray<Integer> testArray = new UniqueArray<Integer>();
		
		// loop through the row of nodes
		while (current != null) {
			
			//if the number (element) inside the node doesn't follow the Sudoku's rules, return false
			if (current.getElement() < 1 || current.getElement() > 9) {
				return false;
			}
			
			// append the number inside the node to the array 
			testArray.addItem(current.getElement());

			// adjust the current pointer
			current = current.getNext();
		}
		
		// if there are not 9 unique elements in the array, return false 
		if (testArray.getNumElements() != 9) {
			return false;
		}
		
		// if nothing is false above, the row has passed the conditions and thus return true
		return true;

	}
	
	/**
	 * Boolean method to check if a given column is valid (aka contains all 9 unique numbers from 1 to 9)
	 * @param col column number from 1 to 9
	 * @return true if the column is valid; false if it is invalid
	 */
	public boolean isValidCol(int col) {
		
		// create a new Unique Array to hold all the values of the column and prepare it for unique-value scanning
		UniqueArray<Integer> testArray = new UniqueArray<Integer>();
		
		// iterate over all the rows 
		for (int row = 0; row < board.length; row++) {
			
			// start the current pointer at the left most node
			LinearNode<Integer> current = board[row];
			
			// iterate until current index equals the desired column index 
			for (int index = 0; index < col - 1; index++) {
				// adjust the current pointer until the column index is reached
				current = current.getNext();
			}
			
			// return false if the number isn't from 1 to 9 (and thus doesn't fit sudoku rules)
			if (current.getElement() < 1 || current.getElement() > 9) {
				return false;
			}
			
			// add the column value to the test array
			testArray.addItem(current.getElement());
		}
		
		// if the test array holding the column's values doesn't have 9 unique values, return false
		if (testArray.getNumElements() != 9) {
			return false;
		}
		
		// if nothing is false above, return true
		return true;
		
		
	}
	
	
	/**
	 * Boolean method that checks if a 3x3 box in the Sudoku is valid (starting at the top left coordinate).
	 * @param row row index where the box begins
	 * @param col column index where the box begins
	 * @return true if the box is valid; false if the box is invalid
	 */
	public boolean isValidBox(int row, int col) {
		
		// adjust the given row and column values to match the way java indexes
		row = row - 1;
		col = col - 1;
		
		// setup an array to hold all the values of the box
		UniqueArray<Integer> testArray = new UniqueArray<Integer>();
		
		// setup a counter for the while loop
		int counter = 0;

		// prepare a while loop to run it for the size of the 3x3 box
		while (counter < 3) {
			
			// create a current pointer that starts at the left most node
			LinearNode<Integer> current = board[row];
			
			// run the current pointer until you reach the column index you want to start the 3x3 box at
			for (int x = 0; x < col; x++) {
				current = current.getNext();
			}
			
			// add in the values from the next 3 right slots (move the pointer along until the column end point)
			for (int j = 0; j < 3; j++) {
				// if the column value (element) doesn't follow the sudoku's rules then return false
				if (current.getElement() < 1 || current.getElement() > 9) {
					return false;
				}
				// add the box value into the test array
				testArray.addItem(current.getElement());
				current = current.getNext();
			}
			
			// run down the height of the 3x3 box
			row++;
			// increment to stop the while loop after 3 times
			counter++;
			
		}
		
		
		// if there aren't 9 unique values in the box, return false
		if (testArray.getNumElements() != 9) {
			return false;
		}
		
		// if nothing is false above, return true
		return true;
		
		
	}

	
	/**
	 * Boolean method to check if the entire Sudoku is valid.
	 * @return true if the board is valid; false if it isn't
	 */
	public boolean isValidSolution() {
		
		// check if all the rows are valid
		for (int i = 1; i <= 9; i++) {
			// if any one row is invalid, return false right away
			if (isValidRow(i) == false) {
				return false;
			}
		}
		
		// check if all the columns are valid
		for (int j = 1; j <= 9; j++) {
			// if any one column is invalid, return false right away
			if (isValidCol(j) == false) {
				return false;
			}
		}
		
		// check if all the 3x3 boxes are valid
		for (int row = 1; row <= 7; row = row + 3) {
			for (int col = 1; col <= 7; col = col + 3) {
				// if any box is invalid, return false right away
				if (isValidBox(row, col) == false) {
					return false;
				}
			}
		}
		
		// if false hasn't been returned yet, it means all 3 rules are satisfied in the 27 method calls; thus return true
		return true;
		
	}
	
	
	/**
	 * toString method that builds a string with all the values from the array of linked data structures into a grid.
	 */
	public String toString() {

		// create an empty string
		String s = "";
		
		// for each row
		for (int row = 0; row < board.length; row++) {

			// start a current node pointer at the left mode node
			LinearNode<Integer> current = board[row];
			
			// for each column
			for (int col = 0; col < board.length; col++) {
				
				// add the value in the row, col cell to the string
				s += current.getElement(); 
				
				// add 2 spaces if it isn't the final column
				if (col < board.length - 1) {
					s += "  ";
				}
				
				// move along the current node pointer
				current = current.getNext();
			}
			
			// create a new line between the rows if it isn't the final row
			if (row < board.length - 1) {
				s += "\n";
			}
		}
		
		// return the final string
		return s;
		
	}
	
	
}
