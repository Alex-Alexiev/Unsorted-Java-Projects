
import java.util.ArrayList;

import processing.core.PApplet;

public class Random_Balls extends PApplet {

	public static void main(String[] args) {

		PApplet.main("Random_Balls");
	}

	static int INITBALLS = 1;

	public void settings() {
		size(1000, 1000);
	}

	ArrayList<ball> balli = new ArrayList<ball>();
	paddle leftPaddle;

	public void setup() {
		frameRate(60);
		surface.setResizable(true);
		leftPaddle = new paddle(3, 60);
		fill(0);
	}
	
	public void addBall(int x_, int y_, int w_, int h_, int dx_, int dy_){
		
		balli.add(new ball(x_, y_, w_, h_, dx_, dy_, 
				(int) random(0, 255), (int) random(0, 255), (int)random(0, 255)));	
	}

	
	public void draw() {

		background(255);
		
		if (mousePressed){

			addBall(mouseX, mouseY, (int) random(4, 50), (int) random(4, 50), (int) random(-50, 50), (int) random(-50, 50));
		}

		for (int i = 0; i < balli.size(); i++) {

			if (balli.get(i).overlaps(leftPaddle)) {

				balli.get(i).bounceX();
			}

			balli.get(i).move();
			balli.get(i).display();

		}

	}

	class movingRect {

		private int x = 0, y = 0, w = 0, h = 0, dx = 0, dy = 0;

		public movingRect() {

		}

		public movingRect(int x_, int y_, int w_, int h_, int dx_, int dy_) {

			x = x_;
			y = y_;
			w = w_;
			h = w_;
			dx = dx_;
			dy = dy_;

		}

		public void move() {

			if (x + w / 2 > width || x - w / 2 < 0) {
				dx *= -1;
			}
			if (y + h / 2 > height || y - h / 2 < 0) {
				dy *= -1;
			}
			x += dx;
			y += dy;

		}

		public void display() {

			rectMode(CENTER);
			rect(x, y, w, h);
			rectMode(CORNER);
		}

		//// Getters ////

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

		//// Setters ////

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

		public boolean overlaps(movingRect obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

		public boolean overlaps(ball obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

	}

	class ball {

		private int x = 0, y = 0, w = 0, h = 0, dx = 0, dy = 0, fillR = 0, fillG = 0, fillB = 0;

		public ball(int x_, int y_, int w_, int h_, int dx_, int dy_, int fillR_, int fillG_, int fillB_) {

			x = x_;
			y = y_;
			w = w_;
			h = w_;
			dx = dx_;
			dy = dy_;
			fillR = fillR_;
			fillG = fillG_;
			fillB = fillB_;
		}

		public void move() {

			if (x + w / 2 > width || x - w / 2 < 0) {
				dx *= -1;
			}
			if (y + h / 2 > height || y - h / 2 < 0) {
				dy *= -1;
			}
			x += dx;
			y += dy;

		}

		public void display() {
			
			fill(fillR, fillG, fillB);
			ellipse(x, y, w, h);

		}

		public void bounceX() {

			dx = -dx;

		}

		public void bounceY() {

			dy = -dy;
		}
		
		

		//// Getters ////

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

		//// Setters ////

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

		public boolean overlaps(ball obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

		public boolean overlaps(movingRect obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

		public boolean overlaps(paddle obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

	}

	class paddle {

		private int w = 0, h = 0, y = 0, x = 40;

		public paddle(int w_, int h_) {

			w = w_;
			h = h_;

		}

		public void followMouse() {

			y = mouseY;

		}

		public void display() {

			rectMode(CENTER);

			rect(x, y, w, h);

		}

		public void set_x(int x_) {
			h = x_;
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

		public boolean overlaps(ball obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

		public boolean overlaps(movingRect obj) {

			return (abs(get_x() - obj.get_x()) < abs(get_w() + obj.get_w()) / 2
					&& abs(get_y() - obj.get_y()) < abs(get_h() + obj.get_h()) / 2);

		}

	}
}
