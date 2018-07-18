import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class CalculateStandings {
	private Vector<Result> resultOfFixtures;
	private Vector<Fixtures> fixtures;
	private int points = 0;
	private int wins = 0;
	private int resultWin = 1;
	private int resultDraw = 1;
	private int draws = 0;
	private int loss = 0;
	private Vector<String> teams = new Vector<String>();
	private Vector<Standings> teams2 = new Vector<Standings>();
	private int numberOfCorrectPredictions;
	private int numberOfIncorrectPredictions;
	private int win = 3;
	private int draw = 1;
	//the reason I take in Results and Fixtures is result to see the results from algorithm 
	//and the fixture to get the teams for each game played.
	public CalculateStandings(Vector<Result> results, Vector<Fixtures> fixture, Vector<Figures> figures){
		resultOfFixtures = results;
		fixtures = fixture;
		calculateStandings();
		sort();
	}
	
	private void calculateStandings(){
		//only need to say either fixtures.size or resultOfFixtures.size as they are the same size	
		//gets a vector that contains team names
		for(int i = 0; i < fixtures.size(); i++){
			if(!(teams.contains(fixtures.elementAt(i).getHomeTeam()))){
				teams.add(fixtures.elementAt(i).getHomeTeam());
			}
			
			if(!(teams.contains(fixtures.elementAt(i).getAwayTeam()))){
				teams.add(fixtures.elementAt(i).getAwayTeam());
			}
		}
		
		for(int i = 0 ; i < teams.size(); i ++){
			Standings currentTeam = new Standings(teams.elementAt(i), wins, draws, loss,  points);
			teams2.add(currentTeam);
		}
		for(int i = 0; i < resultOfFixtures.size(); i++){
			if(resultOfFixtures.elementAt(i).getResult() == "home"){
				String result = "H";
				String team = fixtures.elementAt(i).getHomeTeam();
				String lossTeam = fixtures.elementAt(i).getAwayTeam();
				for(int j = 0; j < teams2.size(); j++){					
					if(teams2.elementAt(j).getTeam().equals(team)){
						teams2.elementAt(j).setPoints(win);
						teams2.elementAt(j).setWins(resultWin);
					}
					
					if(teams2.elementAt(j).getTeam().equals(lossTeam)){
						teams2.elementAt(j).setLosses();
					}					
				}
				checkPredictions(result, i);
			}
			
			if(resultOfFixtures.elementAt(i).getResult().equals("away")){
				String away = "A";
				String team = fixtures.elementAt(i).getAwayTeam();
				String lossTeam = fixtures.elementAt(i).getHomeTeam();
					for(int j = 0; j < teams2.size(); j++){
						if(teams2.elementAt(j).getTeam().equals(team)){
							teams2.elementAt(j).setPoints(win);
							teams2.elementAt(j).setWins(resultWin);
						}
						
						if(teams2.elementAt(j).getTeam().equals(lossTeam)){
							teams2.elementAt(j).setLosses();
						}
					}
					checkPredictions(away, i);		
			}
			
			if(resultOfFixtures.elementAt(i).getResult() == "draw"){
				String draws = "D";
				String teamOne = fixtures.elementAt(i).getHomeTeam();
				String teamTwo = fixtures.elementAt(i).getAwayTeam();
				for(int j = 0; j < teams2.size(); j++){
					if(teams2.elementAt(j).getTeam().equals(teamOne)){
						teams2.elementAt(j).setPoints(draw);
						teams2.elementAt(j).setDraws(resultDraw);
					}
					
					if(teams2.elementAt(j).getTeam().equals(teamTwo)){
						teams2.elementAt(j).setPoints(draw);
						teams2.elementAt(j).setDraws(resultDraw);						
					}
				}
				checkPredictions(draws, i);
			}
		}
	}
	
	private void checkPredictions(String result, int i){
		if(fixtures.elementAt(i).getActualResult().equals(result)){
			numberOfCorrectPredictions += 1;
		}
		else{
			numberOfIncorrectPredictions += 1;
		}
	}
	
	private void sort(){
        Collections.sort(teams2, new Comparator<Standings>(){
            public int compare(Standings other, Standings current){
                if(current.getPoints() == other.getPoints()){
                    return 0;
                }

                else if(current.getPoints() < other.getPoints()){
                    return -1;
                }

                else if(current.getPoints() < other.getPoints()){
                    return 1;
                }
                return 0;
            }
        });
	}
	public int correctResult(){
		return numberOfCorrectPredictions;
	}
	
	public int incorrectResults(){
		return numberOfIncorrectPredictions;
	}
	public Vector<Standings> getStandings(){
		return teams2;
	}
}
