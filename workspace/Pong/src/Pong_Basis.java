import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;

public class Pong_Basis extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Pong_Basis");
	}
	
	public void settings() {
		size(800, 800);
	}
	
	Paddle pad1;
	Score score1;
	
	int num_of_Ellipses = 100;
	
	ArrayList<movingEllipse> ellipses;
	ArrayList<Integer> for_deletion;

	public void setup() {
		surface.setResizable(true);
		frameRate(60);
		fill(255);
		for_deletion = new ArrayList<Integer>();
		pad1 = new Paddle(this, width/2, height/2, 20, 100,
						  0, 0, Color.WHITE, Color.BLUE, 2);
		ellipses = new ArrayList<movingEllipse>();
		for (int i = 0; i < num_of_Ellipses; i++) {
			int radius = (int) random(10, 25);
			ellipses.add(new movingEllipse(this, (int) random(width/4, 3*width/4), (int) random(height/4, 3*height/4),
						 radius, radius, (int) random(5, 10), (int) random(5, 10), 
						 new Color(255, 255, 255), new Color(0, 0, 255), 3));
		}
		score1 = new Score(this, 0, width/2, 50, 28, 0, 0, new Color(255, 255, 255), 3);
	}

	public void draw() {
		if (for_deletion.size() > 0) {
			for_deletion = new ArrayList<Integer>();
		}
		background(0);
		pad1.move();
		pad1.display();
		for (movingEllipse i : ellipses) {
			i.move();
			if (pad1.overlaps(i)) {
				i.set_x(i.get_x() - i.get_dx());
				i.set_dx(-i.get_dx());
			}
			i.display();
			if (i.get_x() + i.get_w() / 2 < pad1.get_x() - pad1.get_w() / 2) {
				score1.decrement_score(1);
				for_deletion.add(ellipses.indexOf(i));
			}
		}
		for (int i = for_deletion.size() - 1; i >= 0; i--) {
			ellipses.remove((int) for_deletion.get(i));
		}
		score1.display();
	}
}
