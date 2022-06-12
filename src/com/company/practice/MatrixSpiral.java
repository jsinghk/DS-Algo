package com.company.practice;

public class MatrixSpiral {

    public static void main(String[] args) {
        int row = 4;
        int col = 3;
        printSpiralMatrixNaturalNumbers(row, col);

        int[][] givenMatrix = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        traverseMatrixSpirally(givenMatrix);
    }

    //Time complexity is O(row*col)
    //Space complexity is O(row*col)
    public static void printSpiralMatrixNaturalNumbers(int row, int col) {
        int num = 1;
        int[][] spiralMatrix = new int[row][col];
        int r = 0, c = 0;
        while (r < row && c < col) {
            //Upper Boundary
            for (int j = c; j < col; j++) {
                spiralMatrix[r][j] = num++;
            }
            r++;

            //Right Boundary
            for (int i = r; i < row; i++) {
                spiralMatrix[i][col - 1] = num++;
            }
            col--;

            //Lower Boundary
            if (r < row) {
                for (int j = col - 1; j >= c; j--) {
                    spiralMatrix[row - 1][j] = num++;
                }
                row--;
            }

            //Left Boundary
            if (c < col) {
                for (int i = row - r; i >= r; i--) {
                    spiralMatrix[i][c] = num++;
                }
                c++;
            }
        }
        for (int[] arr : spiralMatrix) {
            for (int res : arr) {
                System.out.print(res + "   ");
            }
            System.out.println();
        }
    }

    //Time complexity is O(row*col)
    //Space complexity is O(1)
    public static void traverseMatrixSpirally(int[][] givenMatrix) {
        int row = givenMatrix.length;
        int col = givenMatrix[0].length;
        int r = 0, c = 0;
        while (r < row && c < col) {
            //Upper Boundary
            for (int j = c; j < col; j++) {
                System.out.print(givenMatrix[r][j] + "  ");
            }
            r++;

            //Right Boundary
            for (int i = r; i < row; i++) {
                System.out.print(givenMatrix[i][col - 1] + "  ");
            }
            col--;

            //Lower Boundary
            if (r < row) {
                for (int j = col - 1; j >= c; j--) {
                    System.out.print(givenMatrix[row - 1][j] + "  ");
                }
                row--;
            }

            //Left Boundary
            if (c < col) {
                for (int i = row - r; i >= r; i--) {
                    System.out.print(givenMatrix[i][c] + "  ");
                }
                c++;
            }
        }
    }

}
