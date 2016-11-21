package ExplorerMain;

public class Inventory {
	private boolean hasMap;
	private String map;
	
	public Inventory(){
		hasMap = true;
		updateMap();
	}
	public void updateMap() {
		map = " ";
		for(int i=0;i<CaveExplorer.caves[0].length-1;i++){
			map+="____";//4 underscores (TOP)
		}
		map+="___\n";//top right
		//for(CaveRoom[] row: CaveExplorer.caves){//for rows
		for(int r=0;r<CaveExplorer.caves.length;r++){
			//3 rows of text
			for(int i=0;i<3;i++){
				//a line of text for each room
				String text = "";
				//for(CaveRoom cr:row){//for each
				for(int c=0;c<CaveExplorer.caves[r].length;c++){
					
					if(CaveExplorer.caves[r][c].getDoor(CaveRoom.WEST)!=null && !CaveExplorer.caves[r][c].getDoor(CaveRoom.WEST).isLocked()){
						if(CaveExplorer.caves[r][c].getDoor(CaveRoom.WEST).getIsRoom()){
							text+=" ";
						}
						else{
							if(i!=1){
								text+="|";//wall for openings
							}
							else{
								text+=" ";//side opening
							}
						}
					}
					else{
						text+="|";//no opening
					}
					
					
					if(i==0){
						text+="   ";//3 spaces - top empty
					}
					else{
						if(i==1){
							text+=" "+CaveExplorer.caves[r][c].getContents()+" ";//middle empty
						}
						else{
							if(i==2){
								if(CaveExplorer.caves[r][c].getDoor(CaveRoom.SOUTH)!=null && !CaveExplorer.caves[r][c].getDoor(CaveRoom.SOUTH).isLocked()){
									if(CaveExplorer.caves[r][c].getDoor(CaveRoom.SOUTH).getIsRoom())
										text+="   ";
									else
										text+="_ _";//bottom/top opening
								}
								else{
									
									text+="___";
								}
							}
						}
					}
				}//last caveroom
				text+="|";//end wall
				map+=text+"\n";
			}//last of the 3 txt lines
		}//last row
		
	}
	public String getDescription() {
		if(hasMap)
			return map;
		else
			return "There is nothing in your inventory!";
	}

	public void setMap(boolean b) {
		hasMap = b;
	}
}
