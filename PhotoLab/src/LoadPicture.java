import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	
public class LoadPicture extends PhotoFile{
	public LoadPicture(String fileName) {
		super(fileName);
		
	}
	
    public Color[][] load() throws FileNotFoundException {
        Scanner fileName = new Scanner (new File(super.getFileName()));
        int height = fileName.nextInt(); 
        int width = fileName.nextInt();
                               
               Color[][] picSize = new Color[height][width];
                  for (int rows = 0; rows < picSize.length; rows++) {
                	  for (int columns = 0; columns < picSize[rows].length; columns++) {
                		
                		  int redVal = fileName.nextInt();
                          int blueVal = fileName.nextInt();
                          int greenVal = fileName.nextInt();
                		  Color pixel = new Color(redVal, blueVal, greenVal);
                		  picSize[rows][columns] = pixel;
                		  
                	  }
                  }
                                 
        
           return picSize;
       
}
}


		
		
		

