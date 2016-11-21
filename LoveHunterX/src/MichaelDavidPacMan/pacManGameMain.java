package MichaelDavidPacMan;

import java.util.Scanner;
import MichaelDavidPacMan.MichaelCellRoom;

public class pacManGameMain {

	//things we need:
	//	a default grid - I got this, any questions feel free to email me. mli8855@bths.edu
	//	a pacman - This too.
	//	dogs
	//	pieces of bones - can be done /w a counter.

	public static MichaelCellRoom cells[][];
	public static Scanner in;
	public static boolean inPacGame = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		cells = new MichaelCellRoom[8][8];
		for(int r=0; r<cells.length;r++){
			for(int c=0;c<cells[r].length;c++){
				cells[r][c]= new MichaelCellRoom();
				if(cells[r][c].getAccessible()){
					System.out.print("T");
				}else{
					System.out.print("F");
				}
			}
			System.out.println();
		}
		printMaze();
	}

	public static void printMaze(){
		String[][] grid = new String[cells.length][cells[0].length];
		//X = not accessible
		//O = bone frag here
		for (int row =0; row<grid.length; row++){
			for(int col = 0; col < grid[row].length; col ++){
				grid[row][col]=" ";
				if(!(cells[row][col].getAccessible())){
					grid[row][col]="X";
				}else{
					if(cells[row][col].getBFrag()){
						grid[row][col]="O";
					}
				}
			}
		}
		
		//upper border
		for (int col = 0; col < grid[0].length; col++){
			System.out.print(" _");
		}
		System.out.println();
		
		for (int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				System.out.print("|");
				System.out.print(grid[row][col]);
				if (col == grid[row].length -1){
					System.out.print("|");
				}
			}
			System.out.println();
		}
		
		//bottom border
		for (int col = 0; col < grid[0].length; col++){
			System.out.print(" ¯");
		}
	}

//	private static void generateGrid(){
//		String[][] grid = new String[10][36];
//		for(int row = 0; row < grid.length; row++){
//			for(int col = 0; col < grid[row].length; col ++){
//				grid[row][col] = " ";
//			}
//		}
//
//		for(int row = 0; row < grid.length; row++){
//			for(int col = 0; col < grid[row].length; col += 5){
//				grid[row][col] = "|";
//			}
//		}
//
//		for(int row = 0; row < grid.length; row += 3){
//			for(int col = 0; col < grid[row].length; col ++){
//				if(grid[row][col].equals(" ")){
//					grid[row][col] = "_";
//				}
//			}
//		}
//		for(int col = 0; col < grid[0].length; col++){
//			grid[0][col] = "_";
//		}
//		grid[0][0] = " ";
//		grid[0][grid[0].length - 1] = " ";
//		for (int i = 0; i < grid.length; i++){
//			for(int j = 0; j < grid[i].length; j++){
//				System.out.print(grid[i][j]);
//			}
//			System.out.println();
//		}
//	}
}
