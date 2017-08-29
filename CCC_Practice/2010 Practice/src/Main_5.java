import java.util.Scanner;

public class Main_5 {

	static Scanner scanner = new Scanner(System.in);
	static int[][] board = new int[8][8];

	public static void main(String[] args) {
		safeFill(1, 0, 0);
		safeFill(-1, 7, 7);
		int itteration = 1;
		
		while(true){
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == itteration){
						fillPossible(itteration+1, i, j);
					}
				}
			}	
			itteration++;
		}
	}

	public static void safeFill(int value, int x, int y) {
		if (x < 8 && x > -1 && y < 8 && y > -1) {
			if (board[x][y] == -1){
				System.out.println(value-1);
				System.exit(0);
			}
			if (board[x][y] == 0){
				board[x][y] = value;
			}
		}
	}

	public static void fillPossible(int value, int x, int y) {
		safeFill(value, x + 1, y + 2);
		safeFill(value, x + 2, y + 1);
		safeFill(value, x + 2, y - 1);
		safeFill(value, x + 1, y - 2);
		safeFill(value, x - 1, y - 2);
		safeFill(value, x - 2, y - 1);
		safeFill(value, x - 2, y + 1);
		safeFill(value, x - 1, y + 2);
	}

	public static void print() {
		for (int i = 7; i > -1; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
