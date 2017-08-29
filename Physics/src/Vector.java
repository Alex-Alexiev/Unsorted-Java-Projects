
public class Vector {

	public float x;
	public float y;
	public float z;
	
	public Vector(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(double x, double y){
		this((float) x, (float) y, 0);
	}
	
	public Vector(float x, float y){
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public Vector(){
		this(0, 0, 0);
	}
	
	public float distance(Vector v){
		return this.sub(v).magnitude();
	}
	
	public float magnitude(){
		return (float) Math.sqrt((x*x)+(y*y)+(z*z));
	}
	
	public Vector add(Vector a){
		return new Vector(x+a.x, y+a.y, z+a.z);
	}

	public Vector sub(Vector a){
		return new Vector(x-a.x, y-a.y, z-a.z);
	}
	
	public Vector multiply(float k){
		return new Vector(x*k, y*k, z*k);
	}
}
