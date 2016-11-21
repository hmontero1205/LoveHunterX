package ExplorerMain;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom caves[][];
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		caves = new CaveRoom[5][10];
		for(int r=0; r<caves.length;r++){
			for(int c=0;c<caves[r].length;c++){
				caves[r][c] = new CaveRoom("You're at coords ("+r+","+c+")!");
			}
		}
		
		currentRoom = caves[4][7];
		currentRoom.enter();
		caves[4][7].setConnection(CaveRoom.WEST, caves[4][6], new Door("gravel path",true));
		caves[4][6].setConnection(CaveRoom.NORTH, caves[3][6], new Door("gravel path",true));
		caves[4][6].setConnection(CaveRoom.WEST, caves[4][5], new Door("gravel path",true));
		caves[4][7].setConnection(CaveRoom.NORTH, caves[3][7], new Door("gravel path",true));
		caves[3][7].setConnection(CaveRoom.WEST, caves[3][6], new Door("gravel path",true));
		caves[3][6].setConnection(CaveRoom.WEST, caves[3][5], new Door("gravel path",true));
		caves[3][5].setConnection(CaveRoom.WEST, caves[3][4], new Door("gravel path",true));
		caves[3][4].setConnection(CaveRoom.WEST, caves[3][3], new Door("gravel path",true));
		caves[3][3].setConnection(CaveRoom.WEST, caves[3][2], new Door("gravel path",true));
		caves[4][5].setConnection(CaveRoom.WEST, caves[4][4], new Door("gravel path",true));
		caves[4][5].setConnection(CaveRoom.NORTH, caves[3][5], new Door("gravel path",true));
		caves[4][4].setConnection(CaveRoom.WEST, caves[4][3], new Door("gravel path",true));
		caves[4][4].setConnection(CaveRoom.NORTH, caves[3][4], new Door("gravel path",true));
		caves[4][3].setConnection(CaveRoom.WEST, caves[4][2], new Door("gravel path",true));
		caves[4][3].setConnection(CaveRoom.NORTH, caves[3][3], new Door("gravel path",true));
		caves[4][2].setConnection(CaveRoom.NORTH, caves[3][2], new Door("gravel path",true));
		caves[4][2].setConnection(CaveRoom.WEST, caves[4][1], new Door("grand door",false));
		caves[4][1].setConnection(CaveRoom.NORTH, caves[3][1], new Door("rug",true));
		caves[3][1].setConnection(CaveRoom.NORTH, caves[2][1], new Door("door",false));
		caves[4][1].setConnection(CaveRoom.WEST, caves[4][0], new Door("rug",true));
		caves[4][0].setConnection(CaveRoom.NORTH, caves[3][0], new Door("rug",true));
		caves[3][0].setConnection(CaveRoom.EAST, caves[3][1], new Door("rug",true));
		caves[2][0].setConnection(CaveRoom.EAST, caves[2][1], new Door("rug",true));
		caves[2][1].setConnection(CaveRoom.EAST, caves[2][2], new Door("rug",true));
		caves[2][2].setConnection(CaveRoom.EAST, caves[2][3], new Door("rug",true));
		caves[2][3].setConnection(CaveRoom.EAST, caves[2][4], new Door("rug",true));
		caves[2][4].setConnection(CaveRoom.EAST, caves[2][5], new Door("rug",true));
		caves[2][5].setConnection(CaveRoom.EAST, caves[2][6], new Door("rug",true));
		caves[2][6].setConnection(CaveRoom.EAST, caves[2][7], new Door("rug",true));
		caves[2][7].setConnection(CaveRoom.EAST, caves[2][8], new Door("rug",true));
		caves[2][8].setConnection(CaveRoom.EAST, caves[2][9], new Door("rug",true));
		caves[1][0].setConnection(CaveRoom.SOUTH, caves[2][0], new Door("door",false));
		caves[1][0].setConnection(CaveRoom.NORTH, caves[0][0], new Door("rug",true));
		caves[1][0].setConnection(CaveRoom.EAST, caves[1][1], new Door("rug",true));
		caves[2][5].setConnection(CaveRoom.NORTH, caves[1][5], new Door("rug",true));
		caves[1][5].setConnection(CaveRoom.NORTH, caves[0][5], new Door("door",false));
		caves[0][1].setConnection(CaveRoom.EAST, caves[0][2], new Door("rug",true));
		caves[0][1].setConnection(CaveRoom.WEST, caves[0][0], new Door("rug",true));
		caves[0][1].setConnection(CaveRoom.SOUTH, caves[1][1], new Door("rug",true));
		caves[1][1].setConnection(CaveRoom.EAST, caves[1][2], new Door("rug",true));
		caves[1][2].setConnection(CaveRoom.NORTH, caves[0][2], new Door("rug",true));
		caves[1][2].setConnection(CaveRoom.EAST, caves[1][3], new Door("door",false));
		caves[0][2].setConnection(CaveRoom.EAST, caves[0][3], new Door("door",false));
		caves[0][3].setConnection(CaveRoom.SOUTH, caves[1][3], new Door("tiled floor",true));
		caves[0][4].setConnection(CaveRoom.SOUTH, caves[1][4], new Door("tiled floor",true));
		caves[1][4].setConnection(CaveRoom.SOUTH, caves[2][4], new Door("bathroom door",false));
		caves[0][5].updateContents("M");
		caves[4][0].updateContents("B");
		caves[0][9].updateContents("D");
		caves[4][9].updateContents("G");
		caves[0][1].updateContents("F");
		caves[1][1].updateContents("F");
		caves[0][6].setConnection(CaveRoom.SOUTH, caves[1][6], new Door("bedroom tile",true));
		caves[0][6].setConnection(CaveRoom.EAST, caves[0][7], new Door("bedroom tile",true));
		//caves[1][6].setConnection(CaveRoom.SOUTH, caves[2][6], new Door("bedroom door",true));
		
		
		inventory = new Inventory();
		startExploring();
	}

	public static void startExploring() {
		while(true){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("wyd fam xD");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}

	public static void print(String string) {
		System.out.println(string);
		
	}

}
