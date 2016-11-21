package shohebHansMineSweeper;

public class ShohebBackEnd {
	public static int[][] board;
	public static int[][] count;
	public static boolean[][] isNotHidden;
	public static final String[][] questionAnswers = {{"Q1", "GA", "BA", "GR", "BR"}, {"Q1", "GA", "BA", "GR", "BR"}, {"Q1", "GA", "BA", "GR", "BR"}, {"Q1", "GA", "BA", "GR", "BR"}, {"Q1", "GA", "BA", "GR", "BR"}, {"Q1", "GA", "BA", "GR", "BR"}};
	
	public static void cycleThroughQuestions(int totalQuestions){
		boolean[] availableQuestions = new boolean[questionAnswers.length];
		int i = 0;
		for(i = 0; i < totalQuestions; i++){
			int qIndex = (int)(Math.random()*questionAnswers.length);
			while(availableQuestions[qIndex]){
				qIndex = (int)(Math.random()*questionAnswers.length);
			}
			availableQuestions[qIndex] = true;
			System.out.println(questionAnswers[qIndex][0]);
			HansFrontEnd.getUserResponse();
			int boardSpace = board[HansFrontEnd.coords[0]][HansFrontEnd.coords[1]];
			updateBooleanArray(HansFrontEnd.coords[0], HansFrontEnd.coords[1]);
			HansFrontEnd.displayBoard();
			System.out.println(questionAnswers[qIndex][boardSpace]);
			if(boardSpace == 2){
				System.out.println(questionAnswers[qIndex][4]);
				HansFrontEnd.loseGame();
				break;
			}
			else{
				System.out.println(questionAnswers[qIndex][3]);
			}
		}
		if(i == totalQuestions){
			HansFrontEnd.winGame();
		}
	}

	public static void createBoards(){
		int rows = (int)(Math.random()*7 + 5);
		int columns = (int)(Math.random()*5 + 20);
		board = new int[rows][columns];
		fillBoard();
		System.out.println(rows + "   " + columns);
		count = new int[rows][columns];
		fillCount();
		isNotHidden = new boolean[rows][columns];
	}
	
	private static void fillBoard(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				if(Math.random() < .15){
					board[r][c] = 2;
				}
				else{
					board[r][c] = 1;
				}
			}
		}
	}
	
	private static void fillCount(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				count[r][c] = countAdjacent(board, r, c);
			}
		}
	}
	
	private static int countAdjacent(int[][] mines, int r, int c) {
		int count = 0;
		count+=(isAdjacentMine(mines, r, c-1));
		count+=(isAdjacentMine(mines, r, c+1));
		count+=(isAdjacentMine(mines, r-1, c));
		count+=(isAdjacentMine(mines, r+1, c));
		count+=(isAdjacentMine(mines, r-1, c-1));
		count+=(isAdjacentMine(mines, r-1, c+1));
		count+=(isAdjacentMine(mines, r+1, c-1));
		count+=(isAdjacentMine(mines, r-1, c+1));
		return count;
	}
	
	private static int isAdjacentMine(int[][] mines, int r, int c){
		if(r >= 0 && r < mines.length && c >=0 && c < mines[r].length && mines[r][c] == 2){
			return 1;
		}
		return 0;
	}

	private static void updateBooleanArray(int row, int col) {
		int[][] adjacentPosArray = {{row, col-1}, {row, col+1}, {row-1, col}, {row+1, col}, {row-1, col-1}, {row-1, col+1}, {row+1, col-1}, {row-1, col+1}};
		isNotHidden[row][col] = true;
		for(int p = 0; p < adjacentPosArray.length; p++){
			int r = adjacentPosArray[p][0];
			int c = adjacentPosArray[p][1];
			if(r >= 0 && r < board.length && c >=0 && c < board[r].length && isAdjacentMine(board, r, c) == 0){ 
				isNotHidden[r][c] = true;
				/*if(count[r][c] == 0) //if there is no mine and no adjacent mine
					updateBooleanArray(r, c);*/
			}
		
		}
	}
}
