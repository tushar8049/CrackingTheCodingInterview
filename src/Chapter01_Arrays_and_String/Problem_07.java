package Chapter01_Arrays_and_String;


import CTCI_Libraries.AssortedMethods;

/**
 * Problem 7: Rotate Matrix
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class Problem_07 {
    public static void main(String[] arg){
        int[][] matrix = AssortedMethods.randomMatrix(3,3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        matrix = rotateMatrix(matrix);
        AssortedMethods.printMatrix(matrix);
    }

    public static int[][] rotateMatrix(int[][] matrix){

        //Return NULL if the matrix is not a square or is empty
        if(matrix.length == 0 || matrix.length != matrix[0].length)
            return null;

        int n = matrix.length;

        // Approach Layer by layer and start Rotating the layers from outside to inside.
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first ; i < last; i++){
                int offset = i - first;

                //Save TOP
                int top = matrix[first][i];

                //Set LEFT to TOP
                matrix[first][i] = matrix[last-offset][first];

                //Set BOTTOM to LEFT
                matrix[last-offset][first] = matrix[last][last - offset];

                //Set RIGHT to BOTTOM
                matrix[last][last - offset] = matrix[i][last];

                //Set TOP to RIGHT
                matrix[i][last] = top;
            }
        }
        //Rotated Matrix
        return matrix;
    }

}
