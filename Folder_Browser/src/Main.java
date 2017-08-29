import java.io.File;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static long total = 0;

	interface IVisit {
		void visit(File f);
	}

	public static void main(String[] args) {
		System.out.println("Enter the directory:");
		File dir = new File(scanner.nextLine());
		getChildren(dir, new IVisit() {
			@Override
			public void visit(File f) {
				total++;
				//System.out.println(f);
			}
		});
		System.out.println(total);
	}

	static void getChildren(File parent, IVisit visitor) {
		if (parent.isDirectory()) {
			File[] children = parent.listFiles();
			if (children != null) {
				for (File f : children) {
					if (f.isDirectory()) {
						getChildren(f, visitor);
					} else {
						visitor.visit(f);
					}
				}
			}
		}
	}
}
