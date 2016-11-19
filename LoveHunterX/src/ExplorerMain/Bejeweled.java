package ExplorerMain;

import java.util.Scanner;

public class Bejeweled {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public static void main(String args[]){
		symbol = new String[]{" A "," B "," C "," D "};

		setGame();
		in = new Scanner(System.in);
		ask();
		String[][] test = {{"b","a","a","a"},{"n","e","f","g"},{"x","j","h","i"},{"a","l","m","n"}};
		//printPic(test);
//		System.out.println(" ");
//		//swap(test,);
//		//checkCol(test,0);
//		swapBlank(test);
//		printPic(test);
//		System.out.println(" ");
//		replaceBlank(test);
//		printPic(test);
	//	checkRow(test[0]);
	//	printPic(test);
//		replaceBlank(test);
//		printPic(test);

	}
	public static void setGame(){
		arr2d = new String[10][10];
		for(int row= 0; row < arr2d.length;row++){
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		printPic(arr2d);

	}

	public static void printPic(String[][] pic){
		for(int row = 0; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}

	public static String[][] swap(String[][] grid,int r, int c,String d){

		if(d.equals("w")){
			String temp = grid[r-1][c] ;
			grid[r-1][c] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d.equals("a")){
			String temp = grid[r][c-1];
			grid[r][c-1] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d.equals("s")){
			String temp =grid[r+1][c];
			grid[r+1][c] = grid[r][c];
			grid[r][c] = temp;
		}
		if(d.equals("d")){
			System.out.println("swapping right");
			String temp = grid[r][c+1];
			grid[r][c+1] = grid[r][c];
			grid[r][c] = temp;

		}

		return grid;

	}

	public static void ask(){
		int a  = 0;
		while(a  <2){
			System.out.println("which row?");
			int row =  Integer.parseInt(in.nextLine());
			System.out.println("which column?");
			int col = Integer.parseInt(in.nextLine());
			System.out.println("which direction?");
			String dir = in.nextLine();
			System.out.println(row+ " "+ col + " " +dir);
			printPic(swap(arr2d, row,col,dir));
			a++;
		}

	}

	public static int[] checkRow(String[] row){
		int[] results = new int[3];
		int longest = 1;
		int longestIndex = 0;
		int temp = 1;
		for(int i = 0;i<row.length;i++){
			int index = i;
			while(index<row.length-1&&row[index] == row[index+1]){

				temp++;
				index++;
			}
			i = index;
			if(longest<temp){
				longest = temp;
			}
			temp = 1;
		}

		if (longest>=3){
			System.out.println("found greater than four");
			results[0] = 1;
			results[1] = longest;
			results[2] = longestIndex;
			return results;
			
		}

		return null ;

	}

	public static void clearRow(String[] row, int longest, int longestIndex) {
		
		
	}
	public static  boolean checkCol(String[][]grid, int a){

		int longest = 1;
		int temp = 1;
		for(int i = 0;i<grid.length;i++){
			int index = i;
			while(index<grid.length-1&&grid[index][a] == grid[index+1][a]){

				temp++;
				index++;
			}
			i = index;
			if(longest<temp){
				longest = temp;
			}
			temp = 1;



		}

		if (longest>=3){
			System.out.println("found greater than three");
			return true;
		}

		return false;

	}

	public static void replaceBlank(String[][] grid){
		for(int row= 0; row < grid.length;row++){
			for(int col = 0; col < grid[row].length;col++){
				if(grid[row][col].equals(" ")){
					double rand = Math.random();
					int roll = (int) (symbol.length * rand);
					grid[row][col] = symbol[roll];
				}
			}
		}
	}
	
	public static void swapBlank(String[][]grid){
		for(int row = grid.length-1; row > 0; row--){
			for(int col = 0; col < grid[0].length-1; col++){
				if(grid[row][col].equals(" ")){
					swap(grid,row,col,"w");
				}
					
			}
		}
	}
	
}

	

