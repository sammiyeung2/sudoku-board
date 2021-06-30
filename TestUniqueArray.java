
public class TestUniqueArray {

	public static void main(String[] args) {
		UniqueArray<String> sua = new UniqueArray<String>();

		System.out.println("number of empty spots = " + sua.getLength());
		System.out.println("number of filled spots = " + sua.getNumElements());
		
		if (sua.getLength() == 5 && sua.getNumElements() == 0) {
			System.out.println("Test 1 Passed");
		} else {
			System.out.println("Test 1 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		sua.addItem("Canada");
		sua.addItem("Brazil");
		
		System.out.println("number of empty spots = " + sua.getLength());
		System.out.println("number of filled spots = " + sua.getNumElements());
		
		System.out.println(sua);
		
		if (sua.getLength() == 5 && sua.getNumElements() == 2) {
			System.out.println("Test 2 Passed");
		} else {
			System.out.println("Test 2 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		System.out.println("number of empty spots = " + sua.getLength());
		System.out.println("number of filled spots = " + sua.getNumElements());
		
		System.out.println(sua);
		
		if (sua.toString().equals("Canada, Brazil")) {
			System.out.println("Test 3 Passed");
		} else {
			System.out.println("Test 3 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		sua.addItem("India");
		sua.addItem("Germany");
		sua.addItem("China");
		sua.addItem("Ukraine");
		sua.addItem("Brazil");
		sua.addItem("Canada");
		
		System.out.println("tests if you can expand the capacity and restart the prev entries");
		
		System.out.println("number of empty spots = " + sua.getLength());
		System.out.println("number of filled spots = " + sua.getNumElements());
		
		System.out.println(sua);
		
		if (sua.getLength() == 10 && sua.getNumElements() == 6) {
			System.out.println("Test 4 Passed");
		} else {
			System.out.println("Test 4 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		System.out.println("number of empty spots = " + sua.getLength());
		System.out.println("number of filled spots = " + sua.getNumElements());
		
		System.out.println(sua);
		
		if (sua.toString().equals("Canada, Brazil, India, Germany, China, Ukraine")) {
			System.out.println("Test 5 Passed");
		} else {
			System.out.println("Test 5 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------

		UniqueArray<Integer> iua = new UniqueArray<Integer>();
		
		System.out.println("number of empty spots = " + iua.getLength());
		System.out.println("number of filled spots = " + iua.getNumElements());
		
		System.out.println(iua);

		if (iua.toString().equals("") && iua.getLength() == 5) {
			System.out.println("Test 6 Passed");
		} else {
			System.out.println("Test 6 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		iua.addItem(17);
		iua.addItem(17);
		iua.addItem(17);
		iua.addItem(17);
		iua.addItem(17);
		iua.addItem(17);
		
		System.out.println("number of empty spots = " + iua.getLength());
		System.out.println("number of filled spots = " + iua.getNumElements());
		
		System.out.println(iua);
		
		if (iua.getLength() == 5 && iua.getNumElements() == 1) {
			System.out.println("Test 7 Passed");
		} else {
			System.out.println("Test 7 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		System.out.println("number of empty spots = " + iua.getLength());
		System.out.println("number of filled spots = " + iua.getNumElements());
		
		System.out.println(iua);
		
		if (iua.toString().equals("17")) {
			System.out.println("Test 8 Passed");
		} else {
			System.out.println("Test 8 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		iua.addItem(6);
		iua.addItem(12);
		iua.addItem(22);
		
		System.out.println("number of empty spots = " + iua.getLength());
		System.out.println("number of filled spots = " + iua.getNumElements());
		
		System.out.println(iua);

		if (iua.getLength() == 5 && iua.getNumElements() == 4) {
			System.out.println("Test 9 Passed");
		} else {
			System.out.println("Test 9 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
		
		iua.addItem(15);
		iua.addItem(12);
		iua.addItem(20);
		iua.addItem(31);
		iua.addItem(17);
		iua.addItem(3);
		iua.addItem(29);
		iua.addItem(42);
		iua.addItem(18);
		
		System.out.println("number of empty spots = " + iua.getLength());
		System.out.println("number of filled spots = " + iua.getNumElements());
		
		System.out.println(iua);

		if (iua.getLength() == 15 && iua.toString().equals("17, 6, 12, 22, 15, 20, 31, 3, 29, 42, 18")) {
			System.out.println("Test 10 Passed");
		} else {
			System.out.println("Test 10 Failed");
		}
		
		System.out.println("\n");
		
		// ------------------------------------------------
	}

}
