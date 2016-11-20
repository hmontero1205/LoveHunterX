package MichaelDavidPacMan;

	import java.util.Scanner;

public class pacManGameMain {
	
//things we need:
//	a default grid
//	a pacman
//	dogs
//	pieces of bones
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void generateGrid(){
		String[][] grid = new String[7][36];
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col ++){
				grid[row][col] = " ";
			}
		}
		
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col += 5){
				grid[row][col] = "|";
			}
		}
		
		for(int row = 0; row < grid.length; row += 3){
			for(int col = 0; col < grid[row].length; col ++){
				if(grid[row][col].equals(" ")){
					grid[row][col] = "_";
				}
			}
		}
		for(int col = 0; col < grid[0].length; col++){
			grid[0][col] = "_";
		}
		grid[0][0] = " ";
		grid[0][grid[0].length - 1] = " ";
		for (int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(grid[i][j]);

			}
			System.out.println();
		}
	}
}
