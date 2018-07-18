
public class Fixtures {
	private String homeTeam;
	private String awayTeam;
	private int s1H; //season 1 home team score
	private int s1A; //season 1 away team score
	private int s2H; //season 2 home team score
	private int s2A; //season 2 away team score
	private int s3H; //season 3 home team score
	private int s3A; //season 3 away team score
	private int s4H; //season 4 home team score
	private int s4A; //season 4 away team score
	private int s5H; //season 5 home team score
	private int s5A; //season 5 away team score
	private String actualResult; // the actual result of the game
	
	public Fixtures(String[] splitLine){
		homeTeam = splitLine[0];
		awayTeam = splitLine[1];
		s1H = Integer.parseInt(splitLine[2]);
		s1A = Integer.parseInt(splitLine[3]);
		s2H = Integer.parseInt(splitLine[4]);
		s2A = Integer.parseInt(splitLine[5]);
		s3H = Integer.parseInt(splitLine[6]);
		s3A = Integer.parseInt(splitLine[7]);
		s4H = Integer.parseInt(splitLine[8]);
		s4A = Integer.parseInt(splitLine[9]);
		s5H = Integer.parseInt(splitLine[10]);
		s5A = Integer.parseInt(splitLine[11]);	
		actualResult = splitLine[12];
	}

	public String getActualResult(){
		return actualResult;
	}
	public String getHomeTeam(){
		return homeTeam;
	}
	
	public String getAwayTeam(){
		return awayTeam;
	}
	public int getS1H(){
		return s1H;
	}
	
	public int getS1A(){
		return s1A;
	}
	
	public int getS2H(){
		return s2H;
	}
	
	public int getS2A(){
		return s2A;
	}
	
	public int getS3H(){
		return s3H;
	}
	
	public int getS3A(){
		return s3A;
	}
	
	public int getS4H(){
		return s4H;
	}
	
	public int getS4A(){
		return s4A;
	}
	
	public int getS5H(){
		return s5H;
	}
	
	public int getS5A(){
		return s5A;
	}	
}