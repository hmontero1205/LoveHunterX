package michaelDavidPacMan;

public class DavidEnemy {
	public static boolean inOneLoop = true;
	public static boolean inTwoLoop = true;
	
	public static void updateEnemyMovement(int enemyNum){
		int randDirec = (int) ((Math.random() * 4) + 1);
		
		if(enemyNum == 1){
			while(inOneLoop){
				if(randDirec == 1){
					if(MichaelCellRoom.currentEnemyOneRoomRow>0 && checkIfOneAccessible(-1,0)){
						MichaelCellRoom.currentEnemyOneRoomRow--;
						inOneLoop = false;
					}
					else{
						randDirec = 3;
					}
				}
				if(randDirec == 2){
					if(MichaelCellRoom.currentEnemyOneRoomCol>0 && checkIfOneAccessible(0,-1)){
						MichaelCellRoom.currentEnemyOneRoomCol--;
						inOneLoop = false;
					}
					else{
						randDirec = 4;
					}
				}
				if(randDirec == 3){
					if(MichaelCellRoom.currentEnemyOneRoomRow<MichaelDavidPacManGameMain.cells.length-1 && checkIfOneAccessible(1,0)){
						MichaelCellRoom.currentEnemyOneRoomRow++;
						inOneLoop = false;
					}
					else{
						randDirec = 1;
					}
				}
				if(randDirec == 4){
					if(MichaelCellRoom.currentEnemyOneRoomCol<MichaelDavidPacManGameMain.cells[0].length-1 && checkIfOneAccessible(0,1)){
						MichaelCellRoom.currentEnemyOneRoomCol++;
						inOneLoop = false;
					}
					else{
						randDirec = 2;
					}
				}
			}
		}
		if(enemyNum == 2){
			if(randDirec == 1){
				if(MichaelCellRoom.currentEnemyTwoRoomRow>0 && checkIfTwoAccessible(-1,0)){
					MichaelCellRoom.currentEnemyTwoRoomRow--;
					inTwoLoop = false;
				}
				else{
					randDirec = 3;
				}
			}
			if(randDirec == 2){
				if(MichaelCellRoom.currentEnemyTwoRoomCol>0 && checkIfTwoAccessible(0,-1)){
					MichaelCellRoom.currentEnemyTwoRoomCol--;
					inTwoLoop = false;
				}
				else{
					randDirec = 4;
				}
			}
			if(randDirec == 3){
				if(MichaelCellRoom.currentEnemyTwoRoomRow<MichaelDavidPacManGameMain.cells.length-1 && checkIfTwoAccessible(1,0)){
					MichaelCellRoom.currentEnemyTwoRoomRow++;
					inTwoLoop = false;
				}
				else{
					randDirec = 1;
				}
			}
			if(randDirec == 4){
				if(MichaelCellRoom.currentEnemyTwoRoomCol<MichaelDavidPacManGameMain.cells[0].length-1 && checkIfTwoAccessible(0,1)){
					MichaelCellRoom.currentEnemyTwoRoomCol++;
					inTwoLoop = false;
				}
				else{
					randDirec = 2;
				}
			}
		}
		
 	}
	public static boolean checkIfOneAccessible(int eRow, int eCol){
		return MichaelDavidPacManGameMain.cells[MichaelCellRoom.currentEnemyOneRoomRow+eRow][MichaelCellRoom.currentEnemyOneRoomCol+eCol].getAccessible();
	}
	public static boolean checkIfTwoAccessible(int eRow, int eCol){
		return MichaelDavidPacManGameMain.cells[MichaelCellRoom.currentEnemyTwoRoomRow+eRow][MichaelCellRoom.currentEnemyTwoRoomCol+eCol].getAccessible();
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
