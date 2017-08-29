import java.util.ArrayList;
import java.util.Scanner;

public class Main_5 {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Step> all = new ArrayList<Step>();
	static Step goal = new Step(new String[] { "1", "2"}, 0);

	public static void main(String[] args) {
		
		//all.add(new Step(new String[] { "3", "2", "1" },0));
		Step x = new Step(new String[] {"2", "1" },0);
		all.add(x);
		
		int index  = 0;
		
		while(true){
			Step temp = all.get(index);
			if(temp.addToArray()){
			 	System.out.println(all.get(all.size()-1));
			 	break;
			}
			index++;
			if (index == all.size()){
				System.out.println("IMPOSSIBLE");
				break;
			}
			
		}
		
		System.out.println(all.size());
	}

	public static class Step {

		String[] positions;
		int gen;

		Step(String[] positions, int gen) {
			this.positions = positions;
			this.gen = gen;
		}

		public boolean addToArray() {
			for (int i = 0; i < this.positions.length - 1; i++) {
				char left = this.getTop(i);
				char right = this.getTop(i + 1);
				if (left != ' ' && (left < right || right == ' ')) {
					Step x = this.clone();
					x.addToTop(left, i + 1);
					x.removeFromTop(i);
					if (x.equals(goal)) {
						all.add(x);
						return true;
					}
					if (!x.exists()) {
						all.add(x);
					}
				}
				if (right != ' ' && (right < left || left == ' ')) {
					Step x = this.clone();
					x.addToTop(right, i);
					x.removeFromTop(i + 1);
					if (x.equals(goal)) {
						all.add(x);
						return true;
					}
					if (!x.exists()) {
						all.add(x);
					}
				}

			}
			
			return false;

		}

		public Step clone() {
			String[] x = new String[this.positions.length];
			for (int i = 0; i < this.positions.length; i++) {
				x[i] = this.positions[i];
			}
			return new Step(x, this.gen + 1);
		}

		public char getTop(int index) {
			if (this.positions[index].length() >= 1) {
				return this.positions[index].charAt(0);
			} else {
				return ' ';
			}

		}

		public void addToTop(char chr, int i) {
			this.positions[i] = chr + this.positions[i];
		}

		public void removeFromTop(int i) {
			this.positions[i] = this.positions[i].substring(1);
		}

		public boolean equals(Step s) {
			for (int i = 0; i < positions.length; i++) {
				if (!positions[i].equals(s.positions[i])) {
					return false;
				}
			}

			return true;
		}

		public String toString() {
			String x = "";
			for (int i = 0; i < this.positions.length; i++) {
				x += this.positions[i] + ":";
			}
			x += "Generation: " + gen;
			return x;
		}

		public boolean exists() {
			for (Step s : all) {
				if (s.equals(this)) {
					return true;
				}
			}

			return false;
		}
	}

}