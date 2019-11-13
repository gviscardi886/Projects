import java.awt.Color;
import java.awt.color.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class NoColor implements PhotoEffect {

	
	


	public String getName() {
		
		return "Black & White";
	}

	
	public Color[][] apply(Color[][] photo) {
		 
														//Just like the load method it goes through the whole array
														//Instead it has an int value to hold the average of the color objects and
														//reassigns it to the Color object it corresponds to. 
			for (int r = 0; r < photo.length; r++) {
				for (int c = 0; c < photo[0].length; c++) {
					int average  = (photo[r][c].getRed() + photo[r][c].getGreen() + photo[r][c].getBlue()) / 3;
					Color noColor = new Color(average, average, average);
					photo[r][c] = noColor;
				}
			}
			
			
			return photo;
		}
	
}
