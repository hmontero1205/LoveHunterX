package michaelDavidPacMan;

public class DavidEnemy {
	public static void updateEnemyMovement(int enemyNum){
		int randDirec = (int) ((Math.random() * 4) + 1);
		
		if(enemyNum == 1){
				if(randDirec == 1){
					if(MichaelCellRoom.currentEnemyOneRoomRow>0 && checkIfOneAccessible(-1,0)){
						MichaelCellRoom.currentEnemyOneRoomRow--;
					}
					else{
						randDirec = 3;
					}
				}
				if(randDirec == 2){
					if(MichaelCellRoom.currentEnemyOneRoomCol>0 && checkIfOneAccessible(0,-1)){
						MichaelCellRoom.currentEnemyOneRoomCol--;
					}
					else{
						randDirec = 4;
					}
				}
				if(randDirec == 3){
					if(MichaelCellRoom.currentEnemyOneRoomRow<MichaelDavidPacManGameMain.cells.length-1 && checkIfOneAccessible(1,0)){
						MichaelCellRoom.currentEnemyOneRoomRow++;
					}
					else{
						randDirec = 1;
					}
				}
				if(randDirec == 4){
					if(MichaelCellRoom.currentEnemyOneRoomCol<MichaelDavidPacManGameMain.cells[0].length-1 && checkIfOneAccessible(0,1)){
						MichaelCellRoom.currentEnemyOneRoomCol++;
					}
					else{
						randDirec = 2;
					}
				}
		}
		if(enemyNum == 2){
				if(randDirec == 1){
					if(MichaelCellRoom.currentEnemyTwoRoomRow>0 && checkIfTwoAccessible(-1,0)){
						MichaelCellRoom.currentEnemyTwoRoomRow--;
					}
					else{
						randDirec = 3;
					}
				}
				if(randDirec == 2){
					if(MichaelCellRoom.currentEnemyTwoRoomCol>0 && checkIfTwoAccessible(0,-1)){
						MichaelCellRoom.currentEnemyTwoRoomCol--;
					}
					else{
						randDirec = 4;
					}
				}
				if(randDirec == 3){
					if(MichaelCellRoom.currentEnemyTwoRoomRow<MichaelDavidPacManGameMain.cells.length-1 && checkIfTwoAccessible(1,0)){
						MichaelCellRoom.currentEnemyTwoRoomRow++;
					}
					else{
						randDirec = 1;
					}
				}
				if(randDirec == 4){
					if(MichaelCellRoom.currentEnemyTwoRoomCol<MichaelDavidPacManGameMain.cells[0].length-1 && checkIfTwoAccessible(0,1)){
						MichaelCellRoom.currentEnemyTwoRoomCol++;
					}
					else{
						randDirec = 2;
					}
				}
		}	
 	}
	public static boolean checkIfOneAccessible(int eRow, int eCol){
		if(MichaelDavidPacManGameMain.cells[MichaelCellRoom.currentEnemyOneRoomRow+eRow][MichaelCellRoom.currentEnemyOneRoomCol+eCol].getAccessible() 
				&& !(MichaelCellRoom.currentEnemyOneRoomRow+eRow == MichaelCellRoom.currentEnemyTwoRoomRow) 
				&& !(MichaelCellRoom.currentEnemyOneRoomCol+eCol == MichaelCellRoom.currentEnemyTwoRoomCol)){
			return true;
		}
		else return false;
	}
	public static boolean checkIfTwoAccessible(int eRow, int eCol){
		if(MichaelDavidPacManGameMain.cells[MichaelCellRoom.currentEnemyTwoRoomRow+eRow][MichaelCellRoom.currentEnemyTwoRoomCol+eCol].getAccessible() 
				&& !(MichaelCellRoom.currentEnemyTwoRoomRow+eRow == MichaelCellRoom.currentEnemyOneRoomRow) 
				&& !(MichaelCellRoom.currentEnemyTwoRoomCol+eCol == MichaelCellRoom.currentEnemyOneRoomCol)){
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

