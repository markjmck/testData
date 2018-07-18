import java.io.IOException;
import java.util.Vector;

public class Main {
	private String fileName;
	private double successfullyPredicted;
	public Main(String fileName){
		this.fileName = fileName;
	}
	public Vector<Standings> runCode(){
		Vector<Fixtures> fixturesVector = new Vector<Fixtures>();
		Vector<Figures> figuresVector = new Vector<Figures>();
		Vector<Result> results = new Vector<Result>();
		Vector<Standings> standing = new Vector<Standings>();
		int correctPredictions;
		int numberOfMatches;

		try {
			FileInputs newFile = new FileInputs(fileName);
			fixturesVector = newFile.getVector();
		} catch (IOException e) {
			e.printStackTrace();
		}

		GetFigures figures = new GetFigures(fixturesVector);
		figuresVector = figures.returnFigures();
		Algorithm algorithm = new Algorithm(figuresVector, fixturesVector);
		results = algorithm.getResultsOfFixtures();
		CalculateStandings standings = new CalculateStandings(results, fixturesVector, figuresVector);
		standing = standings.getStandings();
		correctPredictions = standings.correctResult();
		numberOfMatches = fixturesVector.size();
		double correctPrediction = correctPredictions;
		double TotalMatches = numberOfMatches;
		successfullyPredicted = 100*(correctPrediction/TotalMatches);		
		return standing;
	}	
	
	public double getSuccessfullyPredicted(){
		return successfullyPredicted;
	}
}