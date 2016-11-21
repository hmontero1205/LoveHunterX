package shohebHansMineSweeper;

public class ShohebBackEnd {
	public static int[][] board;
	public static int[][] count;
	public static boolean[][] isHidden;
	public static final String[][] questionAnswers = {{"Q1", "GA", "BA", "GR, BR"}, {"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"}};
	
	public void cycleThroughQuestions(int totalQuestions){
		boolean[] availableQuestions = new boolean[questionAnswers.length];
		int i = 0;
		for(i = 0; i < totalQuestions; i++){
			int qIndex = (int)(Math.random()*questionAnswers.length);
			while(availableQuestions[qIndex]){
				qIndex = (int)(Math.random()*questionAnswers.length);
			}
			availableQuestions[qIndex] = true;
			System.out.println(questionAnswers[qIndex][0]);
			int[] coords = HansFrontEnd.getUserResponse();
			if(board[coords[0]][coords[1]] == 2){
				loseGame(qIndex);
				break;
			}
			else{
				updateBooleanArray(coords[0], coords[1]);
			}
		}
		if(i == totalQuestions){
			winGame();
		}
	}

	private void winGame() {
		// TODO Auto-generated method stub
		
	}

	private void loseGame(int questionNum) {
		// TODO Auto-generated method stub
		
	}

	public static void createBoards(){
		int rows = (int)(Math.random()*7 + 5);
		int columns = (int)(Math.random()*5 + 20);
		board = new int[rows][columns];
		fillBoard();
		System.out.println(rows + "   " + columns);
		//print2DIntArray(board);
		count = new int[rows][columns];
		fillCount();
		isHidden = new boolean[rows][columns];
		//print2DStringArray(count);
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
//
	public static void updateBooleanArray(int row, int col) {
		//isHidden[]
		
	}
	
	
}
