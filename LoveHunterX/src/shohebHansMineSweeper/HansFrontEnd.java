package shohebHansMineSweeper;

import java.util.Scanner;

import hansExplorerMain.Event;

public class HansFrontEnd implements Event{
	
	public static Scanner in = new Scanner(System.in);
	
	public void play(String[] args){
		ShohebBackEnd.createBoards();
		//print2DIntArray(ShohebBackEnd.count);
		//displayBoard();
	}
	//
	private static void displayBoard() {
		//for(int row = 0; row < ShohebBackEnd.)
	}

	public static int[] getUserResponse(){
		System.out.println("Please select a row");
		String row = in.nextLine();
		while(!isValid(row)){
			System.out.println("Please input a number thx");
			row = in.nextLine();
		}
		int r = Integer.parseInt(row);
		System.out.println("Please select a column");
		String column = in.nextLine();
		while(!isValid(column)){
			System.out.println("Please input a number thx");
			column = in.nextLine();
		}
		int col = Integer.parseInt(column);
		int[] coords = {r, col};
		return coords;
	}
	
	public static boolean isValid(String input){
		try{
			int num = Integer.parseInt(input);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	private static void print2DIntArray(int[][] arr2D){
		for(int[] i: arr2D){
			for(int num: i){
				System.out.print(num);
			}
			System.out.print("\n");
		}
	}
	
	public static void print2DStringArray(String[][] arr2D){
		for(String[] s: arr2D){
			for(String str: s){
				System.out.print(str);
			}
			System.out.print("\n");
		}
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	



}
