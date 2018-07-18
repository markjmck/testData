import java.util.Vector;

public class Odds {
	private float homeOdds;
	private float awayOdds;
	private float draw;
	
	public Odds(Vector<Float> oddsOfGames){
		homeOdds = oddsOfGames.elementAt(0);
		awayOdds = oddsOfGames.elementAt(1);
		draw = oddsOfGames.elementAt(2);
	}
	
	public float getHomeOdds(){
		return homeOdds;
	}
	
	public float getAwayOdds(){
		return awayOdds;
	}
	
	public float getDrawOdds(){
		return draw;
	}
}
