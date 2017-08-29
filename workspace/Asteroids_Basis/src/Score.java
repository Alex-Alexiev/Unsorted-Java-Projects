import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;

public class Score extends movingText {
	
	int score_value = 0;
	
	public Score(PApplet screen_, int t_, int x_, int y_, int h_, int dx_, int dy_, Color strokeColor_,
			int strokeWeight_) {
		super(screen_, Integer.toString(t_), x_, y_, h_, dx_, dy_, strokeColor_, strokeWeight_);
		score_value = t_;
	}
	
	public void display() {
		get_screen().textAlign(PConstants.CENTER);
		get_screen().textSize(get_h());
		get_screen().stroke(get_strokeColor().getRGB());
		get_screen().strokeWeight(get_strokeWeight());
		get_screen().text(score_value, get_x(), get_y());
	}
	
	// ------------- Accessors ------------ //
	
	public int get_score_value() {
		return score_value;
	}
	
	// ------------------------------------ //
	
	// ------------- Mutators ------------- //
	
	public void set_score_value(int score_value_) {
		score_value = score_value_;
	}
	
	public void increment_score(int value_) {
		score_value += value_;
	}
	
	public void decrement_score(int value_) {
		score_value -= value_;
	}
	
	// ------------------------------------ //
}
