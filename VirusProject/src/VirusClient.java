import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class VirusClient {

	public static void main(String[] args) throws FileNotFoundException {
		//TODO Auto-generated method stub
			
			System.out.println("Welcome to Virus Project");		//User introduction
			System.out.println("This program will be able to sort and filter a list of viruses");
			System.out.println("Please enter a command to begin");
			System.out.println();
			System.out.println("Note: Enter a sort/filter with the thing you want to sort/filter with a capital letter");
			System.out.println("For example, if you wanted to sort the year enter \"sortYear\" as the input");
			System.out.println("For filter commands another prompt will come up saying \"What should the program filter by?\"");
			System.out.println("that is when you should enter what you would like to filter");
			
			File[] files = new File("C:\\Users\\GabrielViscardi\\Desktop\\School 9th Grade\\AP Computer Science\\Virus Project Files\\").listFiles();
																//An Array of files is created to hold all the files in the directory above.
			ArrayList<Virus> virusList = new ArrayList<Virus>();
			
			
 			
			
			for (int f = 1; f < files.length - 1; f++) {		//Each iteration of the for loop, holds the fileName and prints
			        String name = files[f].getName();			//it out.						 		 
			} 
			int arrListCount = 0;
			for (File file: files) {
				Scanner parseFile = new Scanner(file);
				
				parseFile.next();									// For each file, scan by each line and get the information needed
				parseFile.next();									//Gets Locus, Gene, and Year on the first line and then scans the next line for definition
				 													//Makes a special conditional that says if it does not have a period then add the next line to definition 
				int bp = parseFile.nextInt();						
				//System.out.println(bp);
				
				parseFile.next();
				String reference = parseFile.next();     
				//System.out.println(reference);
				
				parseFile.next();
				parseFile.next();
				
				String date = parseFile.next();
				Scanner parseDate = new Scanner(date).useDelimiter("-");
				parseDate.nextInt();
				parseDate.next();
				int year = parseDate.nextInt();
				
				//System.out.println(year);
				
				 parseFile.nextLine();
				
				 String definition = parseFile.nextLine();
				 
				
				 if (!definition.contains(".")) {								//Way to get Definition Code
					 definition = definition + " " + parseFile.nextLine();
					 //System.out.println(definition);
				 } else {
					
					 //System.out.println(definition);
				 }
				String Origin = ""; 
				while (parseFile.hasNextLine())  {					//While loop scans each line until the first token contains Origin. 
					String lineHolder = parseFile.nextLine();			//if else, move to the nextLine
					if (lineHolder.contains("ORIGIN")) {
						
						while (parseFile.hasNextLine()) {			 
							if (parseFile.hasNextLine()) {
								String line = parseFile.nextLine();
								
								if (lineHolder == null) {
																//if the cursor as reached the end of the file do nothing
								} else {
								Scanner parseLine = new Scanner(line);	//else parse the line to break it up into tokens
								parseLine.next();
								
								
									if (parseLine.hasNext()) {		//Keeps adding the next token until it doesn't have a next token.
										Origin = parseLine.next();
										while (parseLine.hasNext()) {
										Origin += parseLine.next();
										}
										
									}
								}
							}
										
						}
						
						
					} else if (parseFile.hasNextLine()) {  //If the next line does not contain the word "Origin" go to the next line.
						parseFile.nextLine();
					}
				} 
				Virus one = new Virus(bp, reference, year, definition, Origin);  //Make Virus objects for each file
				arrListCount++;													//And add it to an ArrayList
				virusList.add(one);
				
				//System.out.println(arrListCount);
			}
			
			Scanner userInput = new Scanner(System.in);		
			
 			String input = userInput.nextLine();
 			Scanner parseInput;
 			
 			
 			VirusCollection viruses = new VirusCollection(virusList); //Make a Virus Collection object that is storing each Virus object
 			
 			
 		while (!input.contains("quit")) {
 			if (input.contains("quit")) {
	 			 System.out.println("Thank you for using VirusSort. Goodbye!");
	 		 } else {
 			if(input.contains("filterGene")) {										//Scanner input Commands
 				parseInput = new Scanner(input);									//If user enters filterGene and then a type of Gene
 				parseInput.next();													//Calls .filterGene() method from VirusCollection class.
 				//Add protective if statement that checks if there is a next token.
 				String gene = parseInput.next();
 				viruses.filterGene(gene);
 				
 			} else if (input.contains("list")) {  					//The rest of the code below is for the userInput
 				viruses.list();										//If the user enters "help" or another word such as
 																	//"list" it will call the corresponding method.
 			} else if (input.contains("help")) {
 				help();
 			} else if (input.contains("sortYear")) {
 				viruses.sortYear();
 			} else if (input.contains("sortReference")) {
 				viruses.sortReference();
 			} else if (input.contains("sortDefinition")) {
 				viruses.sortDefinition();
 			} else if (input.contains("sortGene")) {
 				viruses.sortGene();
 			} else if (input.contains("sortOrigin")) {
 				viruses.sortOrigin();
 			} else if (input.contains("filterDefinition")) {
 				System.out.println("What should the program filter by definition?");
 				String filterDef = userInput.nextLine();
 				parseInput = new Scanner(filterDef);
 				String filterdefinition = parseInput.nextLine();
 				filterdefinition.toLowerCase();
 				System.out.println(filterdefinition);
 				viruses.filterDefinition(filterdefinition);
 				
 			} else if (input.contains("filterOrigin")) {
 				System.out.println("What should the program filter by origin?");
 				String filterOrigin = userInput.nextLine();
 				parseInput = new Scanner (filterOrigin);
 				filterOrigin.toLowerCase();
 				
 				viruses.filterOrigin(filterOrigin);
 			
 			} else if (input.contains("filterYear")) {
 				System.out.println("What should the program filter by year?");
 				String filterYear = userInput.nextLine();
 				
 				
 				Range r = Range.parse(filterYear);	
 				System.out.println(filterYear);		
 				viruses.filterYear(r);
 				
 			} else if (input.contains("filterReference")) {
 				System.out.println("What should the program filter by reference?");
 				String filterReference = userInput.nextLine();
 				
 				Range r = Range.parse(filterReference); 
 				viruses.filterReference(r);
 				
	 		 } else {
 				System.out.println("Incorrect input. Please try again"); 				//If the user enters a word or number when the program asks to enter a command
 				System.out.println("If the user is unsure what to enter type 'help'");	//It will say incorrect input and then prompt the user again to retry
 			}
	 		 }
 			System.out.println("Please enter another command"); //Keeps prompting the user to type a command until they type "quit".
 			System.out.println("Type \"list\" to see the changes made");
 			userInput = new Scanner (System.in);				   
 			input = userInput.nextLine();
 		} 
 		
 			
 		
			
			
		}
	public static void help() { //Informs the user what each method does so they know what to correctly enter.
		System.out.println("List: lists the current data unchanged or changed by a sortmethod or filtermethod");
		System.out.println("Filter: Removes Virus objects from the virusCollection that don't meet the criteria");
		System.out.println("Sort: Sorts the Virus objects in the virusCollection arrayList based on year, bp, definition, gene, and origin");
		System.out.println("Quit: Terminates the program and no longer asks for further input");
	}
		
		
		
	}
			
			
				
			
			        
						    
			   

	

		
	
	
	
 
