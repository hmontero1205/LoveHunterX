package michaelDavidPacMan;

import java.util.Scanner;
import michaelDavidPacMan.MichaelCellRoom;
import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class MichaelPacManGameMain implements Event {

	//things we need:
	//	a default grid - I got this, any questions feel free to email me. mli8855@bths.edu
	//	a pacman - This too.
	//	dogs
	//	pieces of bones - can be done /w a counter.

	public static MichaelCellRoom cells[][];
	public static Scanner in;
	public static boolean inPacGame=true;
	
	public MichaelPacManGameMain(){
		
	}

	public void play() {
		System.out.println("You encounter an angry looking doge. There are bone fragments scattered on the ground.\n"
				+ "Maybe if you give doge enough bone fragments, he'll come thru with the key xD");
		in = new Scanner(System.in);
		cells = new MichaelCellRoom[10][10];
		for(int r=0; r<cells.length;r++){
			for(int c=0;c<cells[r].length;c++){
				cells[r][c]= new MichaelCellRoom();
				//				if(cells[r][c].getAccessible()){
				//					System.out.print("T");
				//				}else{
				//					System.out.print("F");
				//				}
			}
						//System.out.println();
		}
		while(inPacGame){
			printMaze();
			String input = in.nextLine();
			MichaelPacMan.interpretInput(input);
			MichaelPacMan.getBoneFrags();
			if(MichaelPacMan.getNumCollected()>=10){
				System.out.println("You fed the doge and now doge respects you. With that, doge gives you the key to the house.");
				inPacGame=false;
				HansCaveExplorer.caves[4][1].getDoor(1).setLocked(false);
			}
		}
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
					if(row == MichaelCellRoom.currentRoomRow && col == MichaelCellRoom.currentRoomCol){
						grid[row][col] = "!";
					}
				}
			}
		}
		//starting cell must be accessible.
		cells[0][0].accessible = true;

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

		System.out.println("\n You have collected " + MichaelPacMan.getNumCollected() + " bone fragments.");
	}

}
