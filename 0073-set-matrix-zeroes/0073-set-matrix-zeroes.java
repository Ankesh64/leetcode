class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zerorows[] = new boolean[matrix.length];
        boolean zerocols[] = new boolean[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    zerorows[i]=true;
                    zerocols[j]=true;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(zerorows[i] || zerocols[j]){
                    matrix[i][j]=0;
                }
            }
        }  
    }
}