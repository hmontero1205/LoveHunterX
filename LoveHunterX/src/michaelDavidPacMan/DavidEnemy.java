package michaelDavidPacMan;


public class DavidEnemy {
	public static int currentEnemyOneRoomRow = MichaelPacManGameMain.cells.length-1;
	public static int currentEnemyTwoRoomRow = MichaelPacManGameMain.cells.length-2;
	public static int currentEnemyOneRoomCol = MichaelPacManGameMain.cells[0].length-1;
	public static int currentEnemyTwoRoomCol = MichaelPacManGameMain.cells[0].length-2;
	
	public static void updateEnemyMovement(int enemyNum){
		int randDirec = (int) ((Math.random() * 4) + 1);
		
		if(enemyNum == 1){
				if(randDirec == 1){
					if(currentEnemyOneRoomRow>0 && checkIfOneAccessible(-1,0)){
						currentEnemyOneRoomRow--;
					}
					else{
						randDirec = 3;
					}
				}
				if(randDirec == 2){
					if(currentEnemyOneRoomCol>0 && checkIfOneAccessible(0,-1)){
						currentEnemyOneRoomCol--;
					}
					else{
						randDirec = 4;
					}
				}
				if(randDirec == 3){
					if(currentEnemyOneRoomRow<MichaelPacManGameMain.cells.length-1 && checkIfOneAccessible(1,0)){
						currentEnemyOneRoomRow++;
					}
					else{
						randDirec = 1;
					}
				}
				if(randDirec == 4){
					if(currentEnemyOneRoomCol<MichaelPacManGameMain.cells[0].length-1 && checkIfOneAccessible(0,1)){
						currentEnemyOneRoomCol++;
					}
					else{
						randDirec = 2;
					}
				}
		}
		if(enemyNum == 2){
				if(randDirec == 1){
					if(currentEnemyTwoRoomRow>0 && checkIfTwoAccessible(-1,0)){
						currentEnemyTwoRoomRow--;
					}
					else{
						randDirec = 3;
					}
				}
				if(randDirec == 2){
					if(currentEnemyTwoRoomCol>0 && checkIfTwoAccessible(0,-1)){
						currentEnemyTwoRoomCol--;
					}
					else{
						randDirec = 4;
					}
				}
				if(randDirec == 3){
					if(currentEnemyTwoRoomRow<MichaelPacManGameMain.cells.length-1 && checkIfTwoAccessible(1,0)){
						currentEnemyTwoRoomRow++;
					}
					else{
						randDirec = 1;
					}
				}
				if(randDirec == 4){
					if(currentEnemyTwoRoomCol<MichaelPacManGameMain.cells[0].length-1 && checkIfTwoAccessible(0,1)){
						currentEnemyTwoRoomCol++;
					}
					else{
						randDirec = 2;
					}
				}
		}	
 	}
	public static boolean checkIfOneAccessible(int eRow, int eCol){
		if(MichaelPacManGameMain.cells[currentEnemyOneRoomRow+eRow][currentEnemyOneRoomCol+eCol].getAccessible() 
				&& !(currentEnemyOneRoomRow+eRow == currentEnemyTwoRoomRow) 
				&& !(currentEnemyOneRoomCol+eCol == currentEnemyTwoRoomCol)){
			return true;
		}
		else return false;
	}
	public static boolean checkIfTwoAccessible(int eRow, int eCol){
		if(MichaelPacManGameMain.cells[currentEnemyTwoRoomRow+eRow][currentEnemyTwoRoomCol+eCol].getAccessible() 
				&& !(currentEnemyTwoRoomRow+eRow == currentEnemyOneRoomRow) 
				&& !(currentEnemyTwoRoomCol+eCol == currentEnemyOneRoomCol)){
			return true;
		}
		else return false;
	}
	
	public static boolean checkLoseCondition(int currentRow, int currentCol){
		if((currentRow + 1) == MichaelCellRoom.currentRoomRow){
			return true;
		}
		else if((currentRow - 1) == MichaelCellRoom.currentRoomRow){
			return true;
		}
		else if((currentCol + 1) == MichaelCellRoom.currentRoomCol){
			return true;
		}
		else if((currentCol - 1) == MichaelCellRoom.currentRoomCol){
			return true;
		}
		else return false;
	}
}

