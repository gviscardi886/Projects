import java.awt.Color;

public class FlipVertical implements PhotoEffect{

	
	public String getName() {
		
		return "Flip Vertical";
	}

	
	public Color[][] apply(Color[][] photo) {
		

		for (int col = 0; col < photo[0].length; col++) {
			for (int row = 0; row < photo.length / 2; row++) {
				Color temp = photo[row][col];
				photo[row][col] = photo[photo.length - row - 1][col];
				photo[photo.length  - row - 1][col] = temp;
			}
		}
		
		return photo;
	}

}
