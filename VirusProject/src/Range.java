import java.util.Scanner;

public class Range {
	
	public int min;
	public int max;
	
	
	
	public Range (int lowestNum, int highestNum) { //Range constructor/
		this.min  = lowestNum;		//Stores a variable for min.
		this.max = highestNum;		//Stores a variable for max.
		
		
	}
	public static Range parse(String s) {
		Scanner parseString;
	if (s.contains("-")) {
		parseString = new Scanner(s).useDelimiter("-"); //Parses the string that the user enters.
		int min = parseString.nextInt();			//The first number becomes the minimum
		int max = parseString.nextInt();			//The next number becomes the maximum
		Range r = new Range (min, max);				//Creates a range object with a min and max
		return r;                                   //returns the object created.
	} else {
		parseString = new Scanner(s);
		int min = parseString.nextInt();
		int max = min + 999;
		Range r = new Range (min, max);
		return r;
	}
	}
	
	public boolean contains (int n) {
		return true;
	}
	public int getMin() { //Accessor method for min.
		return this.min;
		
	}
	public int getMax() { //Accessor method for max.
		return this.max;
	}
}
