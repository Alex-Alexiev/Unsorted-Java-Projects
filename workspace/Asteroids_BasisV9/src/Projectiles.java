import java.awt.Color;
import processing.core.PApplet;

public class Projectiles{

	private int x = 0, y = 0, w = 0, h = 0, dx = 0, dy = 0, strokeWeight = 1;
	private PApplet screen;
	private Color fillColor = Color.WHITE, strokeColor = Color.BLACK;

	public Projectiles(PApplet screen_, int x_, int y_, int w_, int h_, int dx_, int dy_,
						 Color fillColor_, Color strokeColor_, int strokeWeight_) {
		strokeWeight = strokeWeight_;
		strokeColor = strokeColor_;
		fillColor = fillColor_;
		screen = screen_;
		x = x_;
		y = y_;
		w = w_;
		h = h_;
		dx = dx_;
		dy = dy_;
	}

	public void move() {
		x += dx;
		y += dy;
	}

	public void display() {
		screen.stroke(strokeColor.getRGB());
		screen.strokeWeight(strokeWeight);
		screen.fill(fillColor.getRGB());
		screen.ellipse(x, y, w, h);
	}

	// ------------- Accessors -------------- //

	public int get_x() {
		return x;
	}

	public int get_y() {
		return y;
	}

	public int get_w() {
		return w;
	}

	public int get_h() {
		return h;
	}

	public int get_dx() {
		return dx;
	}

	public int get_dy() {
		return dy;
	}
	
	public Color get_fillColor() {
		return fillColor;
	}
	
	public Color get_strokeColor() {
		return strokeColor;
	}
	
	public int get_strokeWeight() {
		return strokeWeight;
	}

	// ------------------------------------ //

	// ------------ Mutators -------------- //

	public void set_x(int x_) {
		x = x_;
	}

	public void set_y(int y_) {
		y = y_;
	}

	public void set_w(int w_) {
		w = w_;
	}

	public void set_h(int h_) {
		h = h_;
	}

	public void set_dx(int dx_) {
		dx = dx_;
	}

	public void set_dy(int dy_) {
		dy = dy_;
	}
	
	public void set_fillColor(Color fillColor_) {
		fillColor = fillColor_;
	}
	
	public void set_strokeColor(Color strokeColor_) {
		strokeColor = strokeColor_;
	}
	
	public void set_strokeWeight(int strokeWeight_) {
		strokeWeight = strokeWeight_;
	}

	// ----------------------------------- //

	public boolean overlaps(movingText obj) {
		return (PApplet.abs(get_x() - obj.get_x()) < (get_w() + obj.get_w()) / 2
				&& PApplet.abs(get_y() - obj.get_y()) < (get_h() + obj.get_h()) / 2);
	}

	public boolean overlaps(Asteroids obj) {
		return (PApplet.abs(get_x() - obj.get_x()) < (get_w() + obj.get_w()) / 2
				&& PApplet.abs(get_y() - obj.get_y()) < (get_h() + obj.get_h()) / 2);
	}
	

}