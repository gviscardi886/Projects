
public class Virus {
	public String Gene;
	public int Locus;
	public String Definition;
	public int Reference;
	public String Origin;
	
	public Virus(int bpCount, String gene, int year, String definition, String origin) { //Virus constructor.
		
		
		Reference = bpCount;			//Stores variables for each required item in a virus Object.
		Gene = gene;					// (Reference, Gene, Locus, Definition, and Origin are the required items).
		Locus = year;
		Definition = definition;
		Origin = origin;
	}
	
	public int getYear() {  //Accessor method for the year for each virus
		return this.Locus;
	}
	
	
	public String getDefinition() { //Accessor method for the definition of each virus
		return this.Definition;
	}
	
	
	public int getReference() { //Accessor method for the reference of each virus
		return this.Reference;
	}
	
	
	public String getOrigin() { //Accessor method for the origin of each virus
		return this.Origin;
	}
	
	
	public String getGene() { //Accessor method for the gene for each virus.
		return this.Gene;
	}
	
	public String toString() { //toString method for definition
		return Definition;
		
	}

	

	
	
}
