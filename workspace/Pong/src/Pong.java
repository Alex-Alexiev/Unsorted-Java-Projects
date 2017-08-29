
import processing.core.PApplet;

public class Pong extends PApplet {

	public static void main(String[] args) {

		PApplet.main("Pong");
	}

	static int BALLS = 10;

	public void settings() {
		size(400, 400);
	}

	ball balli;
	paddle leftPaddle;

	public void setup() {
		frameRate(60);
		surface.setResizable(true);

		fill(255);
		

					
				balli = new ball((int)random(0, width), (int)random(0, height),
						25, 25, (int)random(-10, 10), (int)random(-10, 10));


		
		leftPaddle = new paddle(3, 60);
	}

	public void draw() {

		background(0);

		if (balli.overlaps(leftPaddle)){
			
			balli.bounceX();
		}
		
		
		balli.move();
		balli.display();
		leftPaddle.followMouse();
		leftPaddle.display();

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

		private int x = 0, y = 0, w = 0, h = 0, dx = 0, dy = 0;

		public ball(int x_, int y_, int w_, int h_, int dx_, int dy_) {

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

			ellipse(x, y, w, h);
		}
		
		public void bounceX(){
			
			dx = -dx;
			
		}
		
		public void bounceY(){
			
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

		private int  w = 0, h = 0, y = 0, x = 40;

		public paddle(int w_, int h_) {

			w = w_;
			h = h_;
			


		}
		
		public  void followMouse(){
			
			y = mouseY;
			
		}
		
		public void display(){
			
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
