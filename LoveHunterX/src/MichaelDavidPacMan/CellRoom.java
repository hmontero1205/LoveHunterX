package MichaelDavidPacMan;

public class CellRoom {
	private boolean accessible;
	private boolean boneFrag;

	private static boolean genCondition(int desireable, int total){
		//random generate a true/false statement based on parameter.
		//ex: i want a 1/4 chance to get a true.
		boolean[] test = new boolean[total];
		for(int i = 0; i<desireable; i++){
			test[i]=true;
		}
		int rand = (int)Math.random() * total;
		return test[rand];
	}

	public CellRoom(){
		accessible = genCondition(8,10);
		if (accessible){
			boneFrag = genCondition(1,2);
		}
	}
}