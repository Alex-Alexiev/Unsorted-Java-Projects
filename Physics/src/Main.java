import processing.core.PApplet;

public class Main extends PApplet{
	
	World w;
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void settings(){
		w = new World(this);
		size(2000, 1200);
	}
	
	public void setup(){
		frameRate(100);
		background(255);
	}
	
	public void draw(){ 
		background(255);
		fill(0, 0, 255);
		w.draw();
	}
	
	public void mouseClicked(){
		w.add(mouseX, mouseY);
	}

}
