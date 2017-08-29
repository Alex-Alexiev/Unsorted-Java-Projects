import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public class Main_Robot {

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot();

		for (int i =0; i < 2100; i++){
			for (int j = 0; j < 1080; j++){
				System.out.println(robot.getPixelColor(i, j));
			}
		}	

	}

}
