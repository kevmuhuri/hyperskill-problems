import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class TestValidator {
	public static void main(String[] args) {
		try {
			File myNumbers = new File("hyperskill-3785-test-07.txt");
			Scanner scan = new Scanner(myNumbers);
			int size = scan.nextInt();
			int arraySize = size * size;
			int[][] sudoku = new int[arraySize][arraySize];

			ArrayList<Integer>[] missingRowNumber = new ArrayList[arraySize];
			for (int i = 0; i < arraySize; ++i) {
				missingRowNumber[i] = new ArrayList<>();
			}
			ArrayList<Integer>[] missingColumnNumber = new ArrayList[arraySize];
			for (int i = 0; i < arraySize; ++i) {
				missingColumnNumber[i] = new ArrayList<>();
			}
			//Fill the sudoku with values from the file
			for (int i = 0; i < arraySize; ++i) {
				for (int j = 0; j < arraySize; ++j) {
					sudoku[i][j] = scan.nextInt();
				}
			}
			scan.close();

			//Check rows and columns for missing numbers
			for (int num = 1; num <= arraySize; ++num) {
				for (int i = 0; i < arraySize; ++i) {
					boolean notFoundColumn = true;
					boolean notFoundRow = true;
					for (int j = 0; j < arraySize; ++j) {
						if (sudoku[i][j] == num) {
							notFoundRow = false;
						}
						if (sudoku[j][i] == num) {
							notFoundColumn = false;
						}
					}
					//missing in column
					if (notFoundColumn) {
						missingColumnNumber[i].add(num);
					}
					//missing in row
					if (notFoundRow) {
						missingRowNumber[i].add(num);
					}
				}
			}

			//Print missing values and in rows if any
			System.out.println("Missing Row numbers.");
			for (int i = 0; i < missingRowNumber.length; ++i) {
				if (!missingRowNumber[i].isEmpty()) {
					System.out.println("Row number " + (i + 1) + ": " + missingRowNumber[i]);
				}
			}
			System.out.println();
			//Print missing values and in columns if any
			System.out.println("Missing Column numbers.");
			for (int i = 0; i < missingColumnNumber.length; ++i) {
				if (!missingColumnNumber[i].isEmpty()) {
					System.out.println("Column number " + (i + 1) + ": " + missingColumnNumber[i]);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

