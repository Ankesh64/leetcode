class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] aux=new int[n*n+1];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                aux[grid[i][j]]++;
            }
        }
        int[] ans=new int[2];
        for(int i=1; i<aux.length; i++){
                if(aux[i]>1){
                    ans[0]=i;
                }
                else if(aux[i]==0){
                    ans[1]=i;
                }
        }
        return ans;
    }
}