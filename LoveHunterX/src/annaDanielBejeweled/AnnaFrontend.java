package annaDanielBejeweled;

import java.util.Scanner;

import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class AnnaFrontend implements Event {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public void play(){
		symbol = new String[]{" A "," B "," C "," D "," E "};

		setGame();
		in = new Scanner(System.in);
		ask();
	}
	
	public AnnaFrontend(){
		
	}
	public static void setGame(){
		//int number = (int)(Math.random() * 12 + 5 );
		arr2d = new String[10][10];
		for(int row= 0; row < arr2d.length;row++){
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		for(int i =0; i < arr2d.length;i++){
			while(DanielBackend.checkRow(arr2d[i])[0] == 1){
				DanielBackend.clearRow(arr2d[i],DanielBackend.checkRow(arr2d[i])[1],DanielBackend.checkRow(arr2d[i])[2]);
				DanielBackend.replaceBlank(arr2d);
			}
			while(DanielBackend.checkCol(arr2d,i)[0]==1){
				DanielBackend.clearCol(arr2d,DanielBackend.checkCol(arr2d,i)[1],DanielBackend.checkCol(arr2d,i)[2],i);
				DanielBackend.replaceBlank(arr2d);
			}
		}
		
		printPic(arr2d);
	}
	public static void printPic(String[][] pic){
		System.out.print("    ");
		for(int i=0; i<arr2d.length; i++){
			if(i<10){
				System.out.print(i+"  ");
			} 
			else{
				System.out.print(i+" ");
			}
			
		}
		System.out.println();
		for(int row = 0; row< pic.length; row++){
			if(row>9){
				System.out.print(row +" ");
			}
			else{
				System.out.print(row +"  ");
			}
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
		}else{
			if(d.equals("a")){
				String temp = grid[r][c-1];
				grid[r][c-1] = grid[r][c];
				grid[r][c] = temp;
			}else{
			
				if(d.equals("s")){
					String temp =grid[r+1][c];
					grid[r+1][c] = grid[r][c];
					grid[r][c] = temp;
				}else{
					if(d.equals("d")){
						String temp = grid[r][c+1];
						grid[r][c+1] = grid[r][c];
						grid[r][c] = temp;
					}else{
						System.out.println("Direction invalid. Start again.");
						ask();
					}
				}
			}
		}

		return grid;

	}
	public static boolean isValid(String input){
		try{
			int num = Integer.parseInt(input);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
}
	public static void ask(){
		int a  = 0;
		while(a <5){
			System.out.println("which row?");
			String x = in.nextLine();
			if(x.equals("hax")){
				a=10000000;
			}
			else{
				if(!isValid(x)){
					System.out.println("Invalid. Start again.");
					ask();
				}
				int row =  Integer.parseInt(x);
				
				System.out.println("which column?");
				String y = in.nextLine();
				if(!isValid(y)){
					System.out.println("Invalid. Start again");
					ask();
				}
				int col =  Integer.parseInt(y);
				
				System.out.println("which direction?");
				String dir = in.nextLine();	
				if(row==0 && dir.equals("w")){
					System.out.println("You can't do that.");
					ask();
				}
				if(row==arr2d.length-1 && dir.equals("s")){
					System.out.println("You can't do that.");
					ask();
				}
				if(col==0 && dir.equals("a")){
					System.out.println("You can't do that.");
					ask();
				}
				if(col==arr2d[0].length-1 && dir.equals("d")){
					System.out.println("You can't do that.");
					ask();
				}
				if(row>arr2d.length-1 || col>arr2d[0].length-1){
					System.out.println("Invalid number. Start again.");
					ask();
				}
				swap(arr2d, row,col,dir);
				for(int i = 0;i<arr2d.length;i++){
					while(DanielBackend.checkRow(arr2d[i])[0]==1||DanielBackend.checkCol(arr2d,i)[0]==1){
						if(DanielBackend.checkRow(arr2d[i])[0] == 1 ){
							DanielBackend.clearRow(arr2d[i],DanielBackend.checkRow(arr2d[i])[1],DanielBackend.checkRow(arr2d[i])[2]);
							DanielBackend.swapBlank(arr2d);
							DanielBackend.replaceBlank(arr2d);
							a++;
	
						}
						if(DanielBackend.checkCol(arr2d,i)[0] == 1){
							DanielBackend.clearCol(arr2d,DanielBackend.checkCol(arr2d,i)[1],DanielBackend.checkCol(arr2d,i)[2],i);
							DanielBackend.swapBlank(arr2d);
							DanielBackend.replaceBlank(arr2d);
							a++;
						}
					}
				}
				printPic(arr2d);
			}
			System.out.println("Score: "+a);
			if(a>5){
				System.out.println("Good job, you've helped enough!");
			}
		}
	}


}