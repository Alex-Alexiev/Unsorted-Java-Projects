import java.util.Random;
import processing.core.PApplet;

public class Main extends PApplet {

	Random random = new Random();
	static int xLines = 3;
	static int yLines = 3;
	static int[][] status = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	static boolean xTurn = true;
	static int xScore = 0;
	static int oScore = 0;
	static int ties = 0;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(1400, 900);
	}

	public void setup() {
		frameRate(60);
		background(0);
	}

	public void draw() {
		background(0);
		drawBoard();

		if (statusSum() == 1) {
			firstMove();
		}
		if (xTurn) {
			drawPieces();
		}
		if (!xTurn) {
			if (winnable()) {
				win();
				drawPieces();
			} else if (blockable()) {
				block();
				drawPieces();
			} else {
				randomMove();
				drawPieces();
			}
			xTurn = true;
		}
		if (xWon() || oWon() || full()) {
			if (xWon()) {
				xScore++;
				drawWinLine();
			}
			else if (oWon()) {
				oScore++;
				drawWinLine();
			}
			else if (full()) {
				ties++;
			}
			drawPieces();
			clear();
			xTurn = true;
		}
		drawText();
		System.out.println(status[0][0]+":"+status[1][0]+":"+status[2][0]+":"+
				status[0][1]+":"+status[1][1]+":"+status[2][1]+":"+
				status[0][2]+":"+status[1][2]+":"+status[2][2]);
	}

	public void drawWinLine() {
		for (int i = 0; i < 3; i++) {
			if ((checkX(i, 0) && checkX(i, 1) && checkX(i, 2))) {
				line(i + 1, i + 7);
				i = 3;
			} else if ((checkX(0, i) && checkX(1, i) && checkX(2, i))) {
				line(i * 3 + 1, i * 3 + 3);
				i = 3;
			} else if ((checkX(0, 0) && checkX(1, 1) && checkX(2, 2))) {
				line(1, 9);
				i = 3;
			} else if ((checkX(2, 0) && checkX(1, 1) && checkX(0, 2))) {
				line(3, 7);
				i = 3;
			} else if ((checkO(i, 0) && checkO(i, 1) && checkO(i, 2))) {
				line(i + 1, i + 7);
				i = 3;
			} else if ((checkO(0, i) && checkO(1, i) && checkO(2, i))) {
				line(i * 3 + 1, i * 3 + 3);
				i = 3;
			} else if ((checkO(0, 0) && checkO(1, 1) && checkO(2, 2))) {
				line(1, 9);
				i = 3;
			} else if ((checkO(2, 0) && checkO(1, 1) && checkO(0, 2))) {
				line(3, 7);
				i = 3;
			}
		}
	}

	public void drawBoard() {
		stroke(255);
		strokeWeight(10);
		fill(0);

		for (int i = 1; i < xLines; i++) {
			line(300 * i, 0, 300 * i, 900);
		}
		for (int j = 1; j < yLines; j++) {
			line(0, 300 * j, 900, 300 * j);
		}
	}

	public void drawPieces() {
		stroke(255);
		strokeWeight(10);
		fill(0);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				stroke(255);

				int pos = 3 * i + j + 1;

				int xPos = (900 / (xLines * 2) * (((pos - 1) % 3) + (((pos - 1) % 3) + 1)));

				int yPos = 0;

				if (status[i][j] == 1) {

					if (pos < 4 && pos > 0) {
						yPos = 150;
					}
					;
					if (pos < 7 && pos > 3) {
						yPos = 450;
					}
					;
					if (pos < 10 && pos > 6) {
						yPos = 750;
					}
					;
					line(xPos - 100, yPos - 100, xPos + 100, yPos + 100);
					line(xPos + 100, yPos - 100, xPos - 100, yPos + 100);
				}

				else if (status[i][j] == 2) {

					if (pos < 4 && pos > 0) {
						yPos = 150;
					}
					;
					if (pos < 7 && pos > 3) {
						yPos = 450;
					}
					;
					if (pos < 10 && pos > 6) {
						yPos = 750;
					}
					;
					ellipse(xPos, yPos, 200, 200);

				}
			}

		}

	}

	public void mouseClicked() {
		if (xTurn) {
			if (mouseX < 900) {
				if (status[mouseY / (300)][mouseX / (300)] == 0) {
					status[mouseY / (300)][mouseX / (300)] = 1;
					xTurn = false;
				} else {
					xTurn = true;
				}
			}
		}
		drawPieces();

	}

	public boolean xWon() {
		for (int i = 0; i < 3; i++) {
			if ((checkX(i, 0) && checkX(i, 1) && checkX(i, 2)) == true) {
				return true;
			} else if ((checkX(0, i) && checkX(1, i) && checkX(2, i)) == true) {
				return true;
			} else if ((checkX(0, 0) && checkX(1, 1) && checkX(2, 2)) == true) {
				return true;
			} else if ((checkX(2, 0) && checkX(1, 1) && checkX(0, 2)) == true) {
				return true;
			}

		}
		return false;
	}

	public boolean oWon() {
		for (int i = 0; i < 3; i++) {
			if ((checkO(i, 0) && checkO(i, 1) && checkO(i, 2))) {
				return true;
			} else if ((checkO(0, i) && checkO(1, i) && checkO(2, i))) {
				return true;
			} else if ((checkO(0, 0) && checkO(1, 1) && checkO(2, 2))) {
				return true;
			} else if ((checkO(2, 0) && checkO(1, 1) && checkO(0, 2))) {
				return true;
			}
		}
		return false;
	}

	public boolean checkX(int x, int y) {
		return (status[y][x] == 1);
	}

	public boolean checkO(int x, int y) {
		return (status[y][x] == 2);
	}

	public void line(int pos1, int pos2) {
		int pos1X = (900 / (xLines * 2) * (((pos1 - 1) % 3) + (((pos1 - 1) % 3) + 1)));
		int pos2X = (900 / (xLines * 2) * (((pos2 - 1) % 3) + (((pos2 - 1) % 3) + 1)));
		int pos1Y = 0;
		int pos2Y = 0;
		if (pos1 < 4 && pos1 > 0) {
			pos1Y = 150;
		}

		else if (pos1 < 7 && pos1 > 3) {
			pos1Y = 450;
		}

		else if (pos1 < 10 && pos1 > 6) {
			pos1Y = 750;
		}
		;
		if (pos2 < 4 && pos2 > 0) {
			pos2Y = 150;
		}

		else if (pos2 < 7 && pos2 > 3) {
			pos2Y = 450;
		}

		else if (pos2 < 10 && pos2 > 6) {
			pos2Y = 750;
		}
		;
		stroke(255, 0, 0);
		line(pos1X, pos1Y, pos2X, pos2Y);
	}

	public void clear() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				status[i][j] = 0;
			}
		}
	}

	public boolean full() {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += status[i][j];
			}
		}
		return (sum == 13);
	}

	public void firstMove() {

		if (status[1][1] == 1) {
			int corner = random.nextInt(4);
			switch (corner) {
			case 0:
				status[0][0] = 2;
				break;
			case 1:
				status[0][2] = 2;
				break;
			case 2:
				status[2][0] = 2;
				break;
			case 3:
				status[2][2] = 2;
				break;
			}
		} else {
			status[1][1] = 2;
		}

		xTurn = true;
	}

	public int statusSum() {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += status[i][j];
			}
		}
		return sum;
	}

	public boolean winnable() {
		boolean winnable = false;
		for (int i = 0; i < 3; i++) {
			if (((status[i][0] + status[i][1] + status[i][2]) == 4)
					&& ((status[i][0] != 1) && (status[i][1] != 1) && (status[i][2] != 1))) {
				winnable = true;
			} else if (((status[0][i] + status[1][i] + status[2][i]) == 4)
					&& ((status[0][i] != 1) && (status[1][i] != 1) && (status[2][i] != 1))) {
				winnable = true;
			} else if (((status[0][0] + status[1][1] + status[2][2]) == 4)
					&& ((status[0][0] != 1) && (status[1][1] != 1) && (status[2][2] != 1))) {
				winnable = true;
			} else if (((status[0][2] + status[1][1] + status[2][0]) == 4)
					&& ((status[0][2] != 1) && (status[1][1] != 1) && (status[2][0] != 1))) {
				winnable = true;
			}
		}
		return winnable;

	}

	public void win() {
		for (int i = 0; i < 3; i++) {
			if (((status[i][0] + status[i][1] + status[i][2]) == 4)
					&& ((status[i][0] != 1) && (status[i][1] != 1) && (status[i][2] != 1))) {

				for (int j = 0; j < 3; j++) {
					if (status[i][j] == 0) {
						status[i][j] = 2;
						j = 3;
						i = 3;
					}
				}
			} else if (((status[0][i] + status[1][i] + status[2][i]) == 4)
					&& ((status[0][i] != 1) && (status[1][i] != 1) && (status[2][i] != 1))) {

				for (int j = 0; j < 3; j++) {
					if (status[j][i] == 0) {
						status[j][i] = 2;
						j = 3;
						i = 3;
					}
				}
			} else if (((status[0][0] + status[1][1] + status[2][2]) == 4)
					&& ((status[0][0] != 1) && (status[1][1] != 1) && (status[2][2] != 1))) {

				for (int j = 0; j < 3; j++) {
					if (status[j][j] == 0) {
						status[j][j] = 2;
						j = 3;
						i = 3;
					}
				}
			} else if (((status[0][2] + status[1][1] + status[2][0]) == 4)
					&& ((status[0][2] != 1) && (status[1][1] != 1) && (status[2][0] != 1))) {
				if (status[0][2] == 0) {
					status[0][2] = 2;
					i = 3;
				}
				if (status[1][1] == 0) {
					status[1][1] = 2;
					i = 3;
				}
				if (status[2][0] == 0) {
					status[2][0] = 2;
					i = 3;
				}
			}
		}
	}

	public boolean blockable() {
		boolean blockable = false;
		for (int i = 0; i < 3; i++) {
			if (((status[i][0] + status[i][1] + status[i][2]) == 2)
					&& ((status[i][0] != 2) && (status[i][1] != 2) && (status[i][2] != 2))) {
				blockable = true;
			}
			if (((status[0][i] + status[1][i] + status[2][i]) == 2)
					&& ((status[0][i] != 2) && (status[1][i] != 2) && (status[2][i] != 2))) {
				blockable = true;
			}
			if (((status[0][0] + status[1][1] + status[2][2]) == 2)
					&& ((status[0][0] != 2) && (status[1][1] != 2) && (status[2][2] != 2))) {
				blockable = true;
			}
			if (((status[0][2] + status[1][1] + status[2][0]) == 2)
					&& ((status[0][2] != 2) && (status[1][1] != 2) && (status[2][0] != 2))) {
				blockable = true;
			}
		}
		return blockable;

	}

	public void block() {
		for (int i = 0; i < 3; i++) {
			if (((status[i][0] + status[i][1] + status[i][2]) == 2)
					&& ((status[i][0] != 2) && (status[i][1] != 2) && (status[i][2] != 2))) {
				for (int j = 0; j < 3; j++) {
					if (status[i][j] == 0) {
						status[i][j] = 2;
						i = 3;
						j = 3;
					}
				}
			} else if (((status[0][i] + status[1][i] + status[2][i]) == 2)
					&& ((status[0][i] != 2) && (status[1][i] != 2) && (status[2][i] != 2))) {
				for (int j = 0; j < 3; j++) {
					if (status[j][i] == 0) {
						status[j][i] = 2;
						i = 3;
						j = 3;
					}
				}
			} else if (((status[0][0] + status[1][1] + status[2][2]) == 2)
					&& ((status[0][0] != 2) && (status[1][1] != 2) && (status[2][2] != 2))) {
				for (int j = 0; j < 3; j++) {
					if (status[j][j] == 0) {
						status[j][j] = 2;
						i = 3;
						j = 3;
					}
				}
			} else if (((status[0][2] + status[1][1] + status[2][0]) == 2)
					&& ((status[0][2] != 2) && (status[1][1] != 2) && (status[2][0] != 2))) {
				if (status[0][2] == 0) {
					status[0][2] = 2;
					i = 3;
				}
				if (status[1][1] == 0) {
					status[1][1] = 2;
					i = 3;
				}
				if (status[2][0] == 0) {
					status[2][0] = 2;
					i = 3;
				}
			}
		}

	}

	public void randomMove() {
		for (int i = 0; i <= 1; i++){
			if (status[i][i+1] == 0){
				status[i][i+1] = 2;
				i=2;
			}
			else if (status[i+1][i] == 0){
				status[i+1][i] = 2;
				i=2;
			}
		}
	}

	public void myDelay(long time) {
		long startTime = millis();
		while ((millis() - startTime) < time) {
			drawPieces();
		}
		drawPieces();
	}

	public void drawText() {
		fill(255);
		textSize(100);
		text("Score:", 1000, 300);
		textSize(60);
		text("X wins: " + xScore, 1000, 400);
		text("O wins: " + oScore, 1000, 500);
		text("Ties: " + ties, 1000, 600);
	}

}

/*
 * 1. If X in center{O in corner} 2. If X ! in center{O in center} 3. If
 * winnable {win} 4. If blockable {block} 5. If else {apply pressure in edge} 6.
 * If else {place O random}
 */
