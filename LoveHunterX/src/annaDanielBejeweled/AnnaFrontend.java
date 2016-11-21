package annaDanielBejeweled;

import java.util.Scanner;

public class AnnaFrontend {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public static void main(String args[]){
		symbol = new String[]{" A "," B "," C "," D "};

		setGame();
		in = new Scanner(System.in);
		ask();
	}
	public static void setGame(){
		int number = (int)(Math.random() * 12 + 5 );
		arr2d = new String[number][number];
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
		printPic(arr2d);
	}
	public static void printPic(String[][] pic){
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
			String temp = grid[r][c+1];
			grid[r][c+1] = grid[r][c];
			grid[r][c] = temp;

		}

		return grid;

	}
	public static void ask(){
		int a  = 0;
		while(a <10){
			System.out.println("which row?");
			int row =  Integer.parseInt(in.nextLine());
			System.out.println("which column?");
			int col = Integer.parseInt(in.nextLine());
			System.out.println("which direction?");
			String dir = in.nextLine();	
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
					System.out.println(a);
				}
			}
			printPic(arr2d);
		}

	}

}