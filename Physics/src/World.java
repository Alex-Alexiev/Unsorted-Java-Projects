import java.util.ArrayList;
import processing.core.PApplet;

public class World {

	ArrayList<Body> all = new ArrayList<Body>();
	PApplet applet;

	public World(PApplet applet) {		
		//Perfect circle
		for (int i = 0; i < 100000; i++){
			all.add(new Body(new Vector(802*Math.random(), 600*Math.random()), new Vector(0, 1), 10,(float) -10));
			all.add(new Body(new Vector(1197*Math.random(), 600*Math.random()), new Vector(0,-1), 10,(float) 10));	
		}
		//all.add(new Body(new Vector(800, 300), new Vector(-0.1, 2), 10,(float) 0));
		//all.add(new Body(new Vector(1200, 600), new Vector(0.1,-2), 10,(float) 0));	
		this.applet = applet;

	}

	public Vector calculateForce(Body b) {
		Vector sum = new Vector();   
		for (Body body : all) {
			if (body != b) {
				sum = sum.add(body.exertEForce(b));
				sum = sum.add(body.exertGForce(b));
			}
		}
		return sum;
	}
	
	public void itterate(){
		for(Body body: all){
			body.updatePosition();
			body.updateVelocity(applet);
			body.updateAcceleration(calculateForce(body));
		}
	}

	
	public void draw(){
		itterate();
		for(Body body: all){
			body.draw(applet);
		}
	}
	
	
	public void add(float x, float y){
		all.add(new Body(new Vector(650, 600), new Vector(0, 2), 1,(float) -1));
	}
}
