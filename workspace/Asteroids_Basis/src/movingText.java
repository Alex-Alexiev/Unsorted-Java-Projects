import processing.core.PApplet;
import processing.core.PConstants;
import java.awt.Color;

public class movingText {

	private int x = 0, y = 0, w = 0, h = 0, dx = 0, dy = 0, strokeWeight = 1;
	private String t = "";
	private PApplet screen;
	private Color strokeColor = Color.BLACK;

	public movingText(PApplet screen_, String t_, int x_, int y_, int h_, int dx_, int dy_, Color strokeColor_,
			int strokeWeight_) {
		strokeWeight = strokeWeight_;
		strokeColor = strokeColor_;
		screen = screen_;
		t = t_;
		x = x_;
		y = y_;
		w = t.length() * h_ / 2;
		h = h_;
		dx = dx_;
		dy = dy_;
	}

	public void move() {
		if (x + w / 2 > screen.width || x - w / 2 < 0) {
			dx *= -1;
		}
		if (y + h / 2 > screen.height || y - h / 2 < 0) {
			dy *= -1;
		}
		x += dx;
		y += dy;
	}

	public void display() {
		screen.textAlign(PConstants.CENTER);
		screen.textSize(h);
		screen.stroke(strokeColor.getRGB());
		screen.strokeWeight(strokeWeight);
		screen.text(t, x, y);
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

	public String get_t() {
		return t;
	}

	public Color get_strokeColor() {
		return strokeColor;
	}

	public int get_strokeWeight() {
		return strokeWeight;
	}
	
	public PApplet get_screen() {
		return screen;
	}

	// ------------------------------------ //

	// ------------ Mutators -------------- //

	public void set_x(int x_) {
		x = x_;
	}

	public void set_y(int y_) {
		y = y_;
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

	public void set_t(String t_) {
		t = t_;
	}

	public void set_strokeColor(Color strokeColor_) {
		strokeColor = strokeColor_;
	}

	public void set_strokeWeight(int strokeWeight_) {
		strokeWeight = strokeWeight_;
	}

	// ----------------------------------- //}

	public boolean overlaps(Asteroids obj) {
		return (PApplet.abs(get_x() - obj.get_x()) < (get_w() + obj.get_w()) / 2
				&& PApplet.abs(get_y() - obj.get_y()) < (get_h() + obj.get_h()) / 2);
	}

	public boolean overlaps(Spaceship obj) {
		return (PApplet.abs(get_x() - obj.get_x()) < (get_w() + obj.get_w()) / 2
				&& PApplet.abs(get_y() - obj.get_y()) < (get_h() + obj.get_h()) / 2);
	}
}