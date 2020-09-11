/**

Problem: Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j<grid[i].length; j++) {
                
                if (grid[i][j] == 1) 
                    perimeter += edge(grid, i, j);
                
            }
        }
        return perimeter;
    }
    
    public int edge(int[][] grid, int x, int y) {
        int edge = 0;
        
        if (x==0 || (x>0 && grid[x-1][y] == 0 ) ) edge++; //up
        if (y==0 || (y>0 && grid[x][y-1] == 0 ) ) edge++; //left
        if (x == grid.length - 1 || (x < grid.length - 1 && grid[x+1][y] == 0)) edge++; //down
        if (y == grid[0].length - 1 || (y < grid[0].length - 1 && grid[x][y+1] == 0)) edge++; //right
        
        return edge;
    }
}