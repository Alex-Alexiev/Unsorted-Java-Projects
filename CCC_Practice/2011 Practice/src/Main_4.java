import java.util.ArrayList;
import java.util.Scanner;

public class Main_4 {

	Vector drillPos = new Vector(0, -1);
	Scanner scanner = new Scanner(System.in);
	boolean[][] grid = new boolean[400][200];
	boolean safety = true;
	ArrayList<Command> commands = new ArrayList<Command>();

	public static void main(String[] args) {
		new Main_4().run();
	}

	void run() {
		init();
		inputData();
		for(Command c: commands){
			drillLine(c);
			System.out.println(drillPos);
			System.out.println(safety);
			if(!safety){
				break;
			}
		}
	}
	
	void init(){
		drillPoint(drillPos.x, drillPos.y);
		drillLine(new Command('d', 2));
		drillLine(new Command('r', 3));
		drillLine(new Command('d', 2));
		drillLine(new Command('r', 2));
		drillLine(new Command('u', 2));
		drillLine(new Command('r', 2));
		drillLine(new Command('d', 4));
		drillLine(new Command('l', 8));
		drillLine(new Command('u', 2));
	}
	
	void inputData(){
		while(true){
			String s = scanner.nextLine();
			String[] split = s.split(" ");
			if (split[0].equals("q")){
				break;
			}
			commands.add(new Command(split[0].charAt(0), Integer.parseInt(split[1])));
		}
	}

	void drillPoint(int x, int y) {
		grid[x + 200][1 - y] = true;
	}

	void drillLine(Command c) {
		if (c.direction == 'u') {
			for (int i = drillPos.y + 1; i <= drillPos.y + c.amount; i++) {
				if (drilled(drillPos.x, i)) {
					safety = false;
				}
				drillPoint(drillPos.x, i);
			}
			drillPos.y += c.amount;
		}
		if (c.direction == 'd') {
			for (int i = drillPos.y - 1; i >= drillPos.y - c.amount; i--) {
				if (drilled(drillPos.x, i)) {
					safety = false;
				}
				drillPoint(drillPos.x, i);
			}
			drillPos.y -= c.amount;
		}
		if (c.direction == 'r') {
			for (int i = drillPos.x + 1; i <= drillPos.x + c.amount; i++) {
				if (drilled(i, drillPos.y)) {
					safety = false;
				}
				drillPoint(i, drillPos.y);
			}
			drillPos.x += c.amount;
		}
		if (c.direction == 'l') {
			for (int i = drillPos.x - 1; i >= drillPos.x - c.amount; i--) {
				if (drilled(i, drillPos.y)) {
					safety = false;
				}
				drillPoint(i, drillPos.y);
			}
			drillPos.x -= c.amount;
		}
	}

	boolean drilled(int x, int y) {
		return grid[x + 200][1 - y];
	}

	public class Vector {

		int x = 0;
		int y = 0;

		Vector(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return Integer.toString(x) + ":" + Integer.toString(y);
		}
	}
	
	public class Command {
		
		int amount;
		char direction;
		
		Command(char direction, int amount){
			this.amount = amount;
			this.direction = direction;
		}
	}
}
