import processing.core.PApplet;

public class ReLearningProccessingMain extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("ReLearningProccessingMain");
	}
	
	public void settings() {
		size(1000, 700);
		
	}
		
	public void setup() {
		surface.setResizable(true);
		frameRate(60);
		fill(255);
	}
	
	public void draw() {
		background(0);
		fill(255);
		rect(0, 0, width/10, height/10);
		
	}

	
}
