package com.samsung.test;

public class MatrixTranspose {
    public int[][] transpose(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;

        int [][]B;
        B = new int[n][m];
        
/*        //Create a copy
        for(int i=0;i < m; i++){
            for(int j=0; j < n; j ++){
                B[i][j] = A[i][j];
            }
        }*/
        
        //A[j][i] = B[i][j]; 
        for(int i=0;i < n; i++){
            for(int j=0; j < m; j ++){
                B[i][j] =A[j][i];
            }
        }
        return A;
    }
    
    public static void main(String []args){
    	int A[][]= {{1},{2}};
    	
    	MatrixTranspose mt = new MatrixTranspose();
    	mt.transpose(A);
    	 
    }

}
