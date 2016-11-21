package MichaelDavidPacMan;

public class MichaelCellRoom {
	private boolean accessible;
	private boolean boneFrag;
	
	private static boolean genCondition(int desireable, int total){
		//random generate a true/false statement based on parameter.
		//ex: i want a 1/4 chance to get a true.
		boolean[] test = new boolean[total];
		for(int i = 0; i<desireable; i++){
			test[i]=true;
		}
		int rand = (int)(Math.random() * total);
		return test[rand];
	}

	public MichaelCellRoom(){
		//chance room is accessible 	
		this.accessible = genCondition(8,10);
		if (accessible){
			//if accessible, probability of getting a bone frag.
			this.boneFrag = genCondition(3,8);
		}
	}
	
	public boolean getAccessible(){
		return accessible;
	}
	
	public boolean getBFrag(){
		return boneFrag;
	}
}
