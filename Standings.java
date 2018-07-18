
public class Standings {
	private String teamName;
	private int point;

	private int win;
	private int draw;
	private int losses;

	public Standings(String team, int wins, int draws, int loss, int points){
		teamName = team;
		win = wins;
		draw = draws;
		losses = loss;
		point = points;
	}
	
	public String getTeam(){
		return teamName;
	}
	
	public int getPoints(){
		return point;
	}
	
	public int getWins(){
		return win;
	}
	
	public int getDraws(){
		return draw;
	}
	
	public int getLosses(){
		return losses;
	}
	public void setPoints(int points){
		point = point + points;
	}
	
	public void setWins(int wins){
		win = win + wins;
	}
	
	public void setLosses(){
		losses = losses + 1;
	}
	
	public void setDraws(int draws){
		draw = draw + draws;
	}
	
	public int compareTo(Standings other){
		if(this.getPoints() == other.getPoints()){
			return 0;
		}
		
		else if(this.getPoints() < other.getPoints()){
			return -1;
		}
		
		else if(this.getPoints() < other.getPoints()){
			return 1;
		}
		return 0;
	}
}
