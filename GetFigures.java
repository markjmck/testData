import java.util.Vector;

public class GetFigures {
	//while(File has next line){
	//Get all figures and pass to Algorithm
	//store results for Algorithm
	//if result is Home then home 
	//else result is away then away team wins
	//else draw
	//Algorithm test = new Algorithm (All stuff here)
	//String result = test.getResult
	private Vector<Fixtures> fixtures;
	private int draws = 0;
	private int homeTeamWins = 0;
	private int awayTeamWins = 0;
	private int homeTeamGoals = 0;
	private int awayTeamGoals = 0;
	private Vector<Figures> figures = new Vector<Figures>();
	
	public GetFigures(Vector<Fixtures> fixtureList){
		fixtures = fixtureList;	
		getFigures();
	}
	
	private void getFigures(){
		Vector<Integer> figuresForEachFixture = new Vector<Integer>();
		for(int i = 0; i < fixtures.size(); i++){
			draws = 0;
			homeTeamWins = 0;
			awayTeamWins = 0;
			homeTeamGoals = 0;
			awayTeamGoals = 0;
			seasonOne(i);
			seasonTwo(i);
			seasonThree(i);
			seasonFour(i);
			seasonFive(i);
			figuresForEachFixture.add(draws);
			figuresForEachFixture.add(homeTeamWins);
			figuresForEachFixture.add(awayTeamWins);
			figuresForEachFixture.add(homeTeamGoals);
			figuresForEachFixture.add(awayTeamGoals);
			Figures eachFixture= new Figures(figuresForEachFixture);
			figures.add(eachFixture); // adds the new fixture object to the vector;
			figuresForEachFixture.clear(); // need to clear the fixture vector so empty for next fixture
		}
	}
	
	private void seasonOne(int i){
		if(fixtures.elementAt(i).getS1H() > fixtures.elementAt(i).getS1A()){
			homeTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS1H();
			awayTeamGoals += fixtures.elementAt(i).getS1A();
		}
		
		//in data file have -1 representing a game which didnt happen so need to identify that		
		else if(fixtures.elementAt(i).getS1H() == fixtures.elementAt(i).getS1A()){
			if(fixtures.elementAt(i).getS1H() >= 0 || fixtures.elementAt(i).getS1A() >= 0){
				draws++;
				homeTeamGoals += fixtures.elementAt(i).getS1H();
				awayTeamGoals += fixtures.elementAt(i).getS1A();
			}
		}
		
		else if(fixtures.elementAt(i).getS1H() < fixtures.elementAt(i).getS1A()){
			awayTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS1H();
			awayTeamGoals += fixtures.elementAt(i).getS1A();
		}
		else{
			System.out.println("error in season 1 figures");
		}
	}
	
	private void seasonTwo(int i){
		if(fixtures.elementAt(i).getS2H() > fixtures.elementAt(i).getS2A()){
			homeTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS2H();
			awayTeamGoals += fixtures.elementAt(i).getS2A();
		}
		
		else if(fixtures.elementAt(i).getS2H() == fixtures.elementAt(i).getS2A()){
			if(fixtures.elementAt(i).getS2H() < 0 || fixtures.elementAt(i).getS2A() < 0){
				
			}
			else{
				draws++;
				homeTeamGoals += fixtures.elementAt(i).getS2H();
				awayTeamGoals += fixtures.elementAt(i).getS2A();
			}
		}
		
		else if(fixtures.elementAt(i).getS2H() < fixtures.elementAt(i).getS2A()){
			awayTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS2H();
			awayTeamGoals += fixtures.elementAt(i).getS2A();
		}
		else{
			System.out.println("error in season 2 figures");
		}
	}
	
	private void seasonThree(int i){
		if(fixtures.elementAt(i).getS3H() > fixtures.elementAt(i).getS3A()){
			homeTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS3H();
			awayTeamGoals += fixtures.elementAt(i).getS3A();
		}
		
		else if(fixtures.elementAt(i).getS3H() == fixtures.elementAt(i).getS3A()){
			if(fixtures.elementAt(i).getS3H() < 0 || fixtures.elementAt(i).getS3A() < 0){
				
			}
			else{
				draws++;
				homeTeamGoals += fixtures.elementAt(i).getS3H();
				awayTeamGoals += fixtures.elementAt(i).getS3A();
			}
		}
		
		else if(fixtures.elementAt(i).getS3H() < fixtures.elementAt(i).getS3A()){
			awayTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS3H();
			awayTeamGoals += fixtures.elementAt(i).getS3A();
		}
		else{
			System.out.println("error in season 3 figures");
		}
	}
	
	private void seasonFour(int i){
		if(fixtures.elementAt(i).getS4H() > fixtures.elementAt(i).getS4A()){
			homeTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS4H();
			awayTeamGoals += fixtures.elementAt(i).getS4A();
		}
		
		else if(fixtures.elementAt(i).getS4H() == fixtures.elementAt(i).getS4A()){
			if(fixtures.elementAt(i).getS4H() < 0 || fixtures.elementAt(i).getS4A() < 0){
				
			}
			else{
				draws++;
				homeTeamGoals += fixtures.elementAt(i).getS4H();
				awayTeamGoals += fixtures.elementAt(i).getS4A();
			}
		}
		
		else if(fixtures.elementAt(i).getS4H() < fixtures.elementAt(i).getS4A()){
			awayTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS4H();
			awayTeamGoals += fixtures.elementAt(i).getS4A();
		}
		else{
			System.out.println("error in season 4 figures");
		}
	}
	
	private void seasonFive(int i){
		if(fixtures.elementAt(i).getS5H() > fixtures.elementAt(i).getS5A()){
			homeTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS2H();
			awayTeamGoals += fixtures.elementAt(i).getS2A();
		}
		
		else if(fixtures.elementAt(i).getS5H() == fixtures.elementAt(i).getS5A()){
			if(fixtures.elementAt(i).getS5H() < 0 || fixtures.elementAt(i).getS5A() < 0){
				
			}
			else{
				draws++;
				homeTeamGoals += fixtures.elementAt(i).getS5H();
				awayTeamGoals += fixtures.elementAt(i).getS5A();
			}
		}
		
		else if(fixtures.elementAt(i).getS5H() < fixtures.elementAt(i).getS5A()){
			awayTeamWins++;
			homeTeamGoals += fixtures.elementAt(i).getS5H();
			awayTeamGoals += fixtures.elementAt(i).getS5A();
		}
		else{
			System.out.println("error in season 5 figures");
		}
	}

	public Vector<Figures> returnFigures(){
		return figures;
	}
}