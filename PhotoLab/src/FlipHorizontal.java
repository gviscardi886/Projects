import java.awt.Color;

public class FlipHorizontal implements PhotoEffect{

	
	public String getName() {
		
		return "Flip Horizontal";
	}

	
	public Color[][] apply(Color[][] photo) {
		for(int row = 0; row < photo.length; row++) {
			for (int col = 0; col<photo[row].length/ 2; col++) {
				Color temp = photo[row][col];
				photo[row][col] = photo[row][photo[row].length - col - 1];
				photo[row][photo[row].length - col - 1] = temp;
			}
		}
		return photo;
	}

	

}
