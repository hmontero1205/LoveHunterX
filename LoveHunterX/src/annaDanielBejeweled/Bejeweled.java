package annaDanielBejeweled;

import java.util.Scanner;

public class Bejeweled {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public static void main(String args[]){
		symbol = new String[]{" A "," B "," C ",};

		setGame();
		in = new Scanner(System.in);
		ask();
		String[][] test = {{"a","a","a","a"},{"a","e","f","g"},{"a","j","h","i"},{"a","l","m","n"}};
		//		swapBlank(test);
		//		printPic(test);
//		printPic(test);
//		System.out.println(checkCol(test,0)[2]);
		//	printPic(test);
		//		replaceBlank(test);
		//		printPic(test);

		//clearRow(test[0],checkRow(test[0])[1],checkRow(test[0])[2]);
		//printPic(test);
	}
	public static void setGame(){
		arr2d = new String[3][3];
		for(int row= 0; row < arr2d.length;row++){
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		for(int i =0; i < arr2d.length;i++){
			while(checkRow(arr2d[i])[0] == 1){
				clearRow(arr2d[i],checkRow(arr2d[i])[1],checkRow(arr2d[i])[2]);
				replaceBlank(arr2d);
			}
			//			while(checkCol(arr2d,i)[0]==1){
			//				clearCol(arr2d,checkCol(arr2d,i)[1],checkCol(arr2d,i)[2],i);
			//				replaceBlank(arr2d);
			//			}
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
		while(a <3){
			System.out.println("which row?");
			int row =  Integer.parseInt(in.nextLine());
			System.out.println("which column?");
			int col = Integer.parseInt(in.nextLine());
			System.out.println("which direction?");
			String dir = in.nextLine();	
			swap(arr2d, row,col,dir);
			for(int i = 0;i<arr2d.length;i++){
				while(checkRow(arr2d[i])[0]==1||checkCol(arr2d,i)[0]==1){
					if(checkRow(arr2d[i])[0] == 1 ){
						clearRow(arr2d[i],checkRow(arr2d[i])[1],checkRow(arr2d[i])[2]);
						swapBlank(arr2d);
						replaceBlank(arr2d);
						a++;
					}
					if(checkCol(arr2d,i)[0] == 1){
						clearCol(arr2d,checkCol(arr2d,i)[1],checkCol(arr2d,i)[2],i);
						swapBlank(arr2d);
						replaceBlank(arr2d);
						a++;
					}
				}
			}
			printPic(arr2d);
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
				longestIndex = i - (longest-1);
			}
			temp = 1;
		}

		if (longest>=3){
			//System.out.println("found greater than four");
			results[0] = 1;
			results[1] = longest;
			results[2] = longestIndex;
			return results;

		}
		results[0] = 0;
		return results ;

	}

	public static void clearRow(String[] row, int longest, int longestIndex) {
		for(int i = 0; i<longest; i++){
			row[longestIndex+i] = "   ";
		}


	}
	public static  int[] checkCol(String[][]grid, int a){
		int[] results = new int[3];
		int longest = 1;
		int longestIndex = 0;
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
				longestIndex = index - (longest-1);

			}
			temp = 1;



		}

		if (longest>=3){
			results[0] = 1;
			results[1] = longest;
			results[2] = longestIndex;
			return results;

		}

		results[0] = 0;
		return results ;

	}
	public static void clearCol(String[][] col, int longest, int longestIndex,int a) {
		for(int i = 0; i<longest; i++){
			col[longestIndex+i][a] = "   ";
		}
	}
	public static void replaceBlank(String[][] grid){
		for(int row= 0; row < grid.length;row++){
			for(int col = 0; col < grid[row].length;col++){
				if(grid[row][col].equals("   ")){
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
				if(grid[row][col].equals("   ")){
					swap(grid,row,col,"w");
				}

			}
		}
	}

}



