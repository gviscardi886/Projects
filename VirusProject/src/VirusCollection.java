
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VirusCollection {
	
	public ArrayList<Virus> virusList;
	
	public VirusCollection(ArrayList<Virus> Virus) { //VirusCollection constructor.
		
		this.virusList = Virus;	
		
	}
	public void filterGene(String s) {
		//System.out.println(this.virusList);							//Prints arrayList without any changes made.
		for (int k = 0; k < this.virusList.size(); k++) {
			if (virusList.get(k).getGene().equals(s)) {
																//After each time it goes through the loop, it checks if the virus object at 
			} else {											//the indexes of the iterator and calls the .getGene(); method from the VirusClass
				virusList.remove(k);							//equals what the user has inputed
				k--;											//If it doesn't equal the user input, remove it from the arrayList.
		}
															// My program thought that a file with ss-RNA met the conditions for DNA
															//So I had to make a new File that held one Gene type per file. And then I found a way to return 1. */
		//System.out.println(virusList.size());			A test case to show the size of  the ArrayList after it has been removed
		//System.out.println(virusList);					A test case to show what viruses got removed.
	}
	public void filterDefinition(String s) {
		
		for (int x = 0; x < virusList.size(); x++ ) {
			String definition = this.virusList.get(x).getDefinition();		//Filter definition method
			definition.toLowerCase();										//A for loop to go through each definition string in each virusObject of the virusList
			if (definition.contains(s)) {									//Creates a string named "definition" that holds each definition of virusObject
																			//Checks if the definition contains what the user entered
			} else {														//If it does, do nothing. Else, remove it from the virusList.
				virusList.remove(x);
				x--;
			} 
	
			
			
		}
	}
	public void filterOrigin(String s) {						//Filter Origin method.
		for (int y = 0; y < virusList.size(); y++) {			//Has a for loop that goes through each virusObject in the virusList.
			String origin = this.virusList.get(y).getOrigin();	//Creates a string called "origin" that stores the origin for each virusObject.
			if (origin.contains(s)) {							//Has a if else conditional. If the origin has what the user enters do nothing. Else remove it from the list.
				//do nothing
			} else {
				virusList.remove(y);
				y--;
			}
			//System.out.println(origin);
		}
		
	}
	public void filterYear(Range r) {						//FilterYear method.
		for (int i = 0; i < virusList.size(); i++) {		//Has a for loop that goes through the virusList.
			int year = virusList.get(i).getYear();			//Stores the year from each virusObject called "year"
			if (year > r.getMin() && year < r.getMax()) {	//Conditional tests if the year from the virusObject is greater than the minimum entered, but less than the max entered.
				//do nothing								//If it is do nothing and keep it in the virusList. Else remove it from the list.
			} else {
				virusList.remove(i);
				i--;
			}
		}
	}
	public void filterReference(Range r) {					//Filter reference method.
		for (int k = 0; k < virusList.size(); k++) {		//Very similar to the filter year method.
			int bp = virusList.get(k).getReference();		//Has a variable to store the reference in each virusObject as it iterates through the 
															//for loop. 
			if (bp > r.getMin() && bp < r.getMax()) {		//Conditional to see if the reference is greater than the minimum but less than the max.
				//do nothing								//If it is do nothing. Else remove it.
			} else {
				virusList.remove(k);
				k--;
			}
		}
	}
	public void sortYear() {							//Insertion sort for sortYear method.
		for (int k = 1; k < virusList.size(); k++) {	//for loop that goes to through each virus in the virusList
			
			//Checks to see if the current virus is less than the virus before it
			for (int j = k; j > 0 && (this.virusList.get(j).getYear()) < (this.virusList.get(j - 1).getYear()); j--) { 
				Virus temp = virusList.get(j);			//Gets the virus at the place of j in a temp variable
				virusList.set(j, virusList.get(j - 1));	//Swaps the virus at j-1 with the virus of j so that
				virusList.set(j - 1, temp);				//the virus at indices j - 1 is in the front of the virusList.
			}											//puts the virus at indices k to its correct place in the list.
			
		}
		
	}
	public void sortReference() {
		
		for (int i = 1; i < virusList.size(); i++) {		//Insertion sort for sortReference method
			
			for (int k = i; k > 0 && (this.virusList.get(k).getReference()) < (this.virusList.get(k - 1).getReference()); k--) { //Checks to see if the current reference is less than the reference before it.
				Virus temp = virusList.get(k);				//Stores the virus object at indices k in a temp variable
				virusList.set(k, virusList.get(k - 1));		//swaps the virus at indices k - 1 with the virus at indices k to its
				virusList.set(k - 1, temp);					//moves the virus at indices k-1 to the front of the list.
			}												//puts the virus at indices k to its correct place in the list.
		}
	}
	public void sortDefinition() {
			for (int j = 1; j < virusList.size(); j++) {	//Insertion sort for sortDefinition method
			
			for (int k = j; k > 0 && (this.virusList.get(k).getDefinition().length()) < (this.virusList.get(k - 1).getDefinition().length()); k--) { //Checks if the current definition is less than the one before it in length.
				Virus temp = virusList.get(k);				//Stores the currect virus at indices k in a temp variable.
				virusList.set(k, virusList.get(k - 1));		//Swaps the virus at indices k - 1 with the virus at indices k
				virusList.set(k - 1, temp);					//puts the virus at indices k at the correct spot in the viruslist.
			}
		}
		
		
		
	}
	public void sortGene() {
		for (int k = 0; k < virusList.size(); k++) {
			for (int j = k + 1; j < virusList.size(); j++) {			//SortGene method that sorts the gene of each virus object lexicographically
				
				if (this.virusList.get(k).getGene().compareTo(this.virusList.get(j).getGene()) > 1) { //Checks to see if the virus at indices k is greater than 1 when comparing it
					Virus temp = virusList.get(k);														//to the virus at j
					virusList.set(k, this.virusList.get(j));		//If this is true, swap the virus at indices k, to the place of the virus at indices j
					virusList.set(j, temp);							//Puts all viruses with the gene DNA at the front and the ones with RNA in the back. 
				}													//This includes the ones with cRNA and ss-RNA.
			}
		}
	}
	public void sortOrigin() {										//Sort Origin method.
		for (int k = 0; k < virusList.size(); k++) {				//Sorts the origin from each virus lexicographically.
			for (int j = k + 1; j < virusList.size(); j++) {
				if (this.virusList.get(k).getOrigin().compareTo(this.virusList.get(j).getOrigin()) > 1) { //Checks to see if the virus at indices k is greater than 1 when comparing the virus at indices j is greater than 1.
					Virus temp = virusList.get(k);					//Swaps the virus at indices j with the virus at indices k.
					virusList.set(k, this.virusList.get(j));
					virusList.set(j, temp);
				}
			}
			
		}
	}
		
	
	public void list() {
		if (virusList.size() != 0) { //Conditional if the virusList as something inside of it to print it out and show the user
			System.out.println(virusList.toString());	//the changes made.
		} else {																//else if the virusList has nothing inside of it, tell the user that the program couldn't find
			System.out.println("Could not find the word, number, or group of characters entered");	//what the user entered and asks them to try again.
			System.out.println("The range entered was too high or too low from the current list");
		}
	}
	
	
}

