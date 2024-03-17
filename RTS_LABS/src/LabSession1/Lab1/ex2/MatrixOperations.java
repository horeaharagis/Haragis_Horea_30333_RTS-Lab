package LabSession1.Lab1.ex2;
public class MatrixOperations {

    public static int[][] addMatrices(int[][] m1,int[][] m2){
        int[][] sum = new int[3][3];
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return sum;
    }

    public static int[][] multiplyMatrices(int[][] m1, int[][] m2){
        int prod[][]=new int[3][3];
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    prod[i][j] = prod[i][j] + m1[i][k] * m2[k][j];
                }
            }
        }
        return prod;
    }

    public static void printMatrix(int[][] m){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
     int m1[][]={{2,3,1},{7,1,6},{9,2,4}};
     int m2[][]={{8,5,3},{3,9,2},{2,7,3}};

     System.out.println("Matrix 1 is:");
     printMatrix(m1);
     System.out.println("Matrix 2 is:");
     printMatrix(m2);

     int[][] sum=addMatrices(m1,m2);
     int[][] prod=multiplyMatrices(m1,m2);

     System.out.println("The sum is:");
     printMatrix(sum);
     System.out.println("The product is:");
     printMatrix(prod);

    }
}
