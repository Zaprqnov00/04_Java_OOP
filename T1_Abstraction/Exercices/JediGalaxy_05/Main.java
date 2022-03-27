package T1_Abstraction.Exercices.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dimension[0];
        int col = dimension[1];

        int[][] matrix = new int[row][col];

        int value = 0;

        createMatrix(row, col, matrix, value);

        String command = scanner.nextLine();

        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] petarInput = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int evilRow = evilInput[0];
            int evilCol = evilInput[1];

            fillEvilMatrix(matrix, evilRow, evilCol);

            int petarRow = petarInput[0];
            int peterCol = petarInput[1];

            sum = fillPetarMatrix(matrix, sum, petarRow, peterCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static long fillPetarMatrix(int[][] matrix, long sum, int petarRow, int peterCol) {
        while (petarRow >= 0 && peterCol < matrix[1].length) {
            if (petarRow < matrix.length && peterCol >= 0 && peterCol < matrix[0].length) {
                sum += matrix[petarRow][peterCol];
            }

            peterCol++;
            petarRow--;
        }
        return sum;
    }

    private static void fillEvilMatrix(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void createMatrix(int row, int col, int[][] matrix, int value) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
