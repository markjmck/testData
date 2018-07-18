import java.util.Random;
import java.util.Vector;

//Purpose of this class is to take in figures obtained in GetFigures and calculate which team will win each fixture
public class Algorithm {	
	private Vector<Figures> vectorOfFigures;
	private int numberOfSeasons = 5;
	private Vector<Odds> odds = new Vector<Odds>();
	private Vector<Result> resultsOfGames = new Vector<Result>();
	private Random rand = new Random();
	private String result;
	private Vector<Form> currentTeamForm = new Vector<Form>();
	private Vector<Fixtures> fixturesVector = new Vector<Fixtures>();
	private Vector<String> teams = new Vector<String>();


	public Algorithm(Vector<Figures> figures, Vector<Fixtures> fixtureVector){
		vectorOfFigures = figures;
		this.fixturesVector = fixtureVector;
		getTeamVector();
		algorithm();
		calculateResult();
	}
	
	private void getTeamVector(){
		for(int i = 0; i < fixturesVector.size(); i++){
			if(!(teams.contains(fixturesVector.elementAt(i).getHomeTeam()))){
				teams.add(fixturesVector.elementAt(i).getHomeTeam());
			}
			
			if(!(teams.contains(fixturesVector.elementAt(i).getAwayTeam()))){
				teams.add(fixturesVector.elementAt(i).getAwayTeam());
			}
		}
		
		for(int j = 0; j < teams.size(); j++){
			Form startForm = new Form(teams.get(j));
			currentTeamForm.addElement(startForm);
		}
	}
	
	private void algorithm(){ //purpose of this is to calculate the odds of each game
		for(int i = 0; i < vectorOfFigures.size(); i++){
			float home = 0;
			float away = 0;
			float draw = 0;
			float totalOdds = 0;
			home = oddsOfHome(i); //gets home team odds
			away = oddsOfAway(i); //gets away team odds
			draw = oddsOfDraw(i); //gets the odds of a draw in the current fixture
			totalOdds = home + away + draw;
			
			if(home == 0.0 && away == 0.0 && draw == 0.0){
				
			}
			else{
				home = home/totalOdds; //purpose of these three lines is to normalise the odds

				away = away/totalOdds;
				draw = draw/totalOdds;
			}
		
			Vector<Float> vectorOfOdds = new Vector<Float>();
			vectorOfOdds.add(home);
			vectorOfOdds.add(away);
			vectorOfOdds.add(draw);
			Odds currentGameOdds = new Odds(vectorOfOdds);
			odds.add(currentGameOdds);			
		}
	}
	
	private float oddsOfHome(int i){
		int homeForm = getFormFigure(fixturesVector.get(i).getHomeTeam());
		int goals = vectorOfFigures.elementAt(i).GetHomeGoalsScored();
		int homeWins = vectorOfFigures.elementAt(i).getHomeWins();

		float oddsOfHome =(goals*10)*(homeWins*20)*(homeForm*5);
		oddsOfHome = oddsOfHome/numberOfSeasons;
		return oddsOfHome;
	}
	
	private float oddsOfAway(int i){
		int awayForm = getFormFigure(fixturesVector.get(i).getAwayTeam());
		int goals = vectorOfFigures.elementAt(i).GetAwayGoalsScored();
		int awayWins = vectorOfFigures.elementAt(i).getAwayWins();
	
		float oddsOfAway =(goals*10)*(awayWins*20)*(awayForm*5);
		oddsOfAway = oddsOfAway/numberOfSeasons;
		return oddsOfAway;
	}
	
	private float oddsOfDraw(int i){
		float oddsOfDraw = (vectorOfFigures.elementAt(i).getDraws());
		oddsOfDraw = oddsOfDraw/numberOfSeasons;
		return oddsOfDraw;
	}
	
	private void calculateResult(){ //purpose of this method is to compare the odds gathered to see who won and assign the teams either 3, 1 or zero points
		for(int i = 0; i < odds.size(); i++){
			float homeOdds = odds.elementAt(i).getHomeOdds();
			float awayOdds = odds.elementAt(i).getAwayOdds();
			float drawOdds = odds.elementAt(i).getDrawOdds();
			
			if(homeOdds > awayOdds && homeOdds > drawOdds){
				//home team wins
				result = "home";
				addToVector(i, result);
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}
			
			else if(awayOdds > homeOdds && awayOdds > drawOdds){
				//away team wins
				result = "away";
				addToVector(i, result);
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}
			
			else if(drawOdds > homeOdds && drawOdds> awayOdds){
				//draw
				result = "draw";
				addToVector(i, result);
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}
			
			
			else if(homeOdds == 0.0 && awayOdds == 0.0 && drawOdds == 0.0){
				int number = rand.nextInt(3);
				if(number == 0){
					result = "home";
					addToVector(i, result);
				}
				else if(number == 1){
					result = "away";
					addToVector(i, result);
				}
				
				else if(number == 2){
					result = "draw";
					addToVector(i, result);
				}
				else{
					System.out.println("ERROR IN RANDOM NUMBER");
				}
				Result currentResult = new Result(result);
				resultsOfGames.add(currentResult);
			}		
			
			else if(homeOdds == drawOdds){
				int random = rand.nextInt(2);
				if(random == 0){
					result = "home";
					addToVector(i, result);
				}
				
				if(random == 1){
					result = "draw";
					addToVector(i, result);
				}
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}
			else if(awayOdds == drawOdds){
				int random = rand.nextInt(2);
				if(random == 0){
					result = "away";
					addToVector(i, result);
				}
				
				if(random == 1){
					result = "draw";
					addToVector(i, result);
				}
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}
			
			else if(homeOdds == awayOdds){
				int random = rand.nextInt(2);
				if(random == 0){
					result = "home";
					addToVector(i, result);
				}
				
				if(random == 1){
					result = "away";
					addToVector(i, result);
				}
				Result currentResult = new Result(result);
				resultsOfGames.addElement(currentResult);
			}						
			else{
				System.out.println("Error for odds");
			}
		}
	}
	private void addToVector(int i, String result){
		if(result.equals("away")){
			String home = fixturesVector.get(i).getAwayTeam();
			String away = fixturesVector.get(i).getHomeTeam();
			for(int j = 0; j < currentTeamForm.size(); j++){
				if(currentTeamForm.get(j).getTeamName().equals(home)){
					currentTeamForm.get(j).addToVector("win");
				}
				
				if(currentTeamForm.get(j).getTeamName().equals(away)){
					currentTeamForm.get(j).addToVector("lose");
				}
			}
		}
		else if(result.equals("home")){
			String home = fixturesVector.get(i).getHomeTeam();
			String away = fixturesVector.get(i).getAwayTeam();
			for(int j = 0; j < currentTeamForm.size(); j++){
				if(currentTeamForm.get(j).getTeamName().equals(home)){
					currentTeamForm.get(j).addToVector("win");
				}
				
				if(currentTeamForm.get(j).getTeamName().equals(away)){
					currentTeamForm.get(j).addToVector("lose");
				}
			}
		}
		
		else if(result.equals("draw")){
			String team = fixturesVector.get(i).getAwayTeam();
			String away = fixturesVector.get(i).getHomeTeam();
			for(int j = 0; j < currentTeamForm.size(); j++){
				if(currentTeamForm.get(j).getTeamName().equals(team)){
					currentTeamForm.get(j).addToVector("draw");
				}
				
				if(currentTeamForm.get(j).getTeamName().equals(away)){
					currentTeamForm.get(j).addToVector("draw");
				}
			}
		}
		else{
			System.out.println("ERROR!!");
		}
	}
	private int getFormFigure(String teamName){
		String nameOfTeam = teamName;
		String formWin = "win";
		Vector<String> form = new Vector<String>();
		int numberOfWins = 0;
		
		for(int i = 0; i < currentTeamForm.size(); i++){
			if(nameOfTeam.equals(currentTeamForm.get(i).getTeamName())){
				form = currentTeamForm.get(i).getResultsVector();
			}
		}
		if(form.isEmpty()){
			numberOfWins = 1;
		}
		else{
			for(int j = 0; j < form.size(); j++){
				if(form.get(j).equals(formWin)){
					numberOfWins++;
				}
				else{
					
				}
			}
		}
		return numberOfWins;
	}

	public Vector<Result> getResultsOfFixtures(){
		return resultsOfGames;
	}
			
	public Vector<Odds> forTesting(){
		return odds;
	}
}
