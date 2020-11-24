import java.util.Scanner;

class SpiralMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[][] arr = new int[size][size];
		int num = 1;
		int row = 0;
		int col = 0;

		//To control & update the limits of rows and columns as we spiral
		int rowFloor = 0;
		int colFloor = 0;
		int rowCeil = size - 1;
		int colCeil = size - 1;

		//A single rotation: 1 - go right, 2 - go down, 3 - go left, 4 - go up
		int turn = 1;

		while (num <= size * size) {
			while (turn == 1) {
				if (col <= colCeil) {
					arr[row][col] = num;
					++col;
					++num;
				} else {
					++turn;
					row = ++rowFloor;
					col = colCeil;
				}
			}
			while (turn == 2) {
				if (row <= rowCeil) {
					arr[row][col] = num;
					++row;
					++num;
				} else {
					++turn;
					col = --colCeil;
					row = rowCeil;
				}
			}
			while (turn == 3) {
				if (col >= colFloor) {
					arr[row][col] = num;
					--col;
					++num;
				} else {
					++turn;
					col = colFloor;
					row = --rowCeil;
				}
			}
			while (turn == 4) {
				if (row >= rowFloor) {
					arr[row][col] = num;
					--row;
					++num;
				} else {
					turn = 1;
					col = ++colFloor;
					row = rowFloor;
				}
			}
		}

		for (int[] line : arr) {
			for (int value : line) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
