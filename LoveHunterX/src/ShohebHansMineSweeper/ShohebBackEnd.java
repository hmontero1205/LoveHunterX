package ShohebHansMineSweeper;

public class ShohebBackEnd {
	public static int[][] board;
	public static String[][] count;
	public static final String[][] questionAnswers = {{"Q1", "GA", "BA", "GR, BR"}, {"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"},{"Q1", "GA", "BA", "GR, BR"}};
	
	public static void main(String[] args){
		createBoards();
	}
	
	public void cycleThroughQuestions(int totalQuestions){
		boolean[] availableQuestions = new boolean[questionAnswers.length];
		for(int i = 0; i < totalQuestions; i++){
			int qIndex = (int)(Math.random()*questionAnswers.length);
			while(availableQuestions[qIndex]){
				qIndex = (int)(Math.random()*questionAnswers.length);
			}
			availableQuestions[qIndex] = true;
			System.out.println(questionAnswers[qIndex][0]);
			commenceUserResponse();
		}
	}
	
	private void commenceUserResponse() {
		// TODO Auto-generated method stub
		
	}

	private static void createBoards(){
		int rows = (int)(Math.random()*7 + 5);
		int columns = (int)(Math.random()*5 + 20);
		board = new int[rows][columns];
		fillBoard();
		System.out.println(rows + "   " + columns);
		print2DIntArray(board);
		count = new String[rows][columns];
		fillCount();
		print2DStringArray(count);
	}
	
	private static void fillBoard(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				if(Math.random() < .25){
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
				if(board[r][c] == 1){
					count[r][c] = countAdjacent(board, r, c);
				}
				else{
					count[r][c] = "X";
				}
			}
		}
	}
	
	private static String countAdjacent(int[][] mines, int r, int c) {
		int count = 0;
				
		count+=(isAdjacentMine(mines, r, c-1));
			
		count+=(isAdjacentMine(mines, r, c+1));
		
		count+=(isAdjacentMine(mines, r-1, c));
			
		count+=(isAdjacentMine(mines, r+1, c));
			
		count+=(isAdjacentMine(mines, r-1, c-1));
			
		count+=(isAdjacentMine(mines, r-1, c+1));
			
		count+=(isAdjacentMine(mines, r+1, c-1));
			
		count+=(isAdjacentMine(mines, r-1, c+1));
		
		return count + "";
	}
	
	private static int isAdjacentMine(int[][] mines, int r, int c){
		if(r >= 0 && r < mines.length && c >=0 && c < mines[r].length && mines[r][c] == 2){
			return 1;
		}
		return 0;
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
}
