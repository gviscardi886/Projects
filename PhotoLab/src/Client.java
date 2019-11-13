import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client{
	public static void main(String[] args) {
		PhotoFile[] picData = new LoadPicture[3];
		picData[0] = new LoadPicture ("ECHelmet.txt");
        picData[1] = new LoadPicture ("ECMorning.txt");
		picData[2] = new LoadPicture ("ECShield.txt");
		
       
		PhotoEffect[] effects = new PhotoEffect [3];
		effects[0] = new FlipHorizontal();
		effects[1] = new FlipVertical();
		effects[2] = new NoColor();
		PhotoLab.start(picData, effects);  
        
        
            
     }
 }
	

