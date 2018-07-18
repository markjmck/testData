import java.util.Vector;

public class Figures {
	private int draws;
	private int homeWins;
	private int awayWins;
	private int homeGoalsScored;
	private int awayGoalsScored;
	
	public Figures(Vector<Integer> figuresForEachMatch){
		draws = figuresForEachMatch.elementAt(0);
		homeWins = figuresForEachMatch.elementAt(1);
		awayWins = figuresForEachMatch.elementAt(2);
		homeGoalsScored = figuresForEachMatch.elementAt(3);
		awayGoalsScored = figuresForEachMatch.elementAt(4);
	}
	
	public int getDraws(){
		return draws;
	}
	
	public int getHomeWins(){
		return homeWins;
	}
	
	public int getAwayWins(){
		return awayWins;
	}
	
	public int GetHomeGoalsScored(){
		return homeGoalsScored;
	}
	
	public int GetAwayGoalsScored(){
		return awayGoalsScored;
	}
}
