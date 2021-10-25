class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j< grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    answer++;
                    recursive(grid,i,j);
                }
            }
        }
        return answer;
        
    }
    
    public void recursive(char[][] grid, int x, int y){
        if(x<0 || x> grid.length-1 || y<0 || y> grid[x].length-1) return;
        if(grid[x][y]!='1') return;
        grid[x][y] = '0';
        
        recursive(grid,x+1,y);
        recursive(grid, x-1,y);
        recursive(grid,x,y+1);
        recursive(grid,x,y-1);
       
        
    }
    
    
    
}