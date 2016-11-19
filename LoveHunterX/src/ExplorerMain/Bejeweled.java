package ExplorerMain;

import java.util.Scanner;

public class Bejeweled {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public static void main(String args[]){
		symbol = new String[]{"A","B","C"};
		
		setGame();
		in = new Scanner(System.in);
		ask();
		//String[][] test = {{"a","b","c","d"},{"a","e","f","g"},{"a","j","h","i"},{"a","l","m","n"}};
		//printPic(test);
		//System.out.println("swapping");
		//swap(test,);
		// wdf
		//checkCol(test,0);

	}
	public static void setGame(){
		arr2d = new String[2][3];
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

	public static void swap(String[][] grid,int r, int c,String d){

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

		printPic( grid);

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
			swap(arr2d, row,col,dir);
			a++;
		}

	}

	public static boolean checkRow(String[] row){
		int longest = 1;
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

			//yay

		}

		if (longest>=3){
			System.out.println("found greater than four");
			return true;
		}

		return false;

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
}


