import processing.core.PApplet;
import java.awt.Color;
import processing.core.PVector;

public class movingTriangle {
	
	private PVector[] vertices = new PVector[3];
	private Color fillColor = Color.WHITE, strokeColor = Color.BLACK;
	private PVector velocity = new PVector(0, 0), com = new PVector(0, 0);
	private PApplet screen;
	private float strokeWidth, angleVelocity, velMag = 1;
	
	public movingTriangle(PApplet screen_, PVector[] vertices_, PVector velocity_, 
						  float angle_, float angleVelocity_,
						  Color fillColor_, Color strokeColor_, float strokeWidth_) {
		screen = screen_;
		fillColor = fillColor_;
		strokeColor = strokeColor_;
		strokeWidth = strokeWidth_;
		vertices = vertices_.clone();
		velocity = velocity_.copy();
		angleVelocity = angleVelocity_;
		for (PVector i : vertices) {
			i = i.rotate(angle_);
			com = PVector.add(com, i);
		}
		com = PVector.div(com, 3);
		for (PVector i : vertices) {
			i.x -= com.x;
			i.y -= com.y;
		}
	}

	public PVector[] getVertices() {
		return vertices;
	}

	public void setVertices(PVector[] vertices) {
		this.vertices = vertices;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}

	public float getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(float strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	public PApplet getScreen() {
		return screen;
	}
	
	public PVector getCom() {
		return com;
	}

	public void setCom(PVector com) {
		this.com = com;
	}

	public float getAngleVelocity() {
		return angleVelocity;
	}

	public void setAngleVelocity(float angleVelocity) {
		this.angleVelocity = angleVelocity;
	}

	public float getVelMag() {
		return velMag;
	}

	public void setVelMag(float velMag) {
		this.velMag = velMag;
	}

	public void move() {
		for (PVector i : vertices) {
			i = i.rotate(angleVelocity);
		}
		if (com.x > screen.width) {
			com.x = 1;
		}

		else if (com.x < 0) {
			com.x = screen.width - 1;
		}
		
		else if (com.y > screen.height) {
			com.y = 1;
		}

		else if (com.y < 0) {
			com.y = screen.height - 1;
		}
		velocity = velocity.rotate(angleVelocity);
		com = PVector.add(com, PVector.mult(velocity, velMag));
	}
	
	public void display() {
		screen.pushMatrix();
		screen.fill(fillColor.getRGB());
		screen.stroke(strokeColor.getRGB());
		screen.strokeWeight(strokeWidth);
		screen.translate(com.x, com.y);
		screen.triangle(vertices[0].x, vertices[0].y, 
						vertices[1].x, vertices[1].y, 
						vertices[2].x, vertices[2].y);
		screen.fill(255, 0, 0);
		screen.noStroke();
		screen.ellipse(0, 0, 2, 2);
		screen.popMatrix();
	}	
}
