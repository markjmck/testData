import java.util.Vector;

public class Form {
	Vector<String> results = new Vector<String>();
	String currentTeam;
	public Form(String teamName){
		currentTeam = teamName;
	}
	
	public void addToVector(String results2){
		if(results.size() == 5){
			results.remove(0);
			results.addElement(results2);
		}
		else if(results.size() < 5){
			results.addElement(results2);
		}
		else{
			System.out.println("ERROR!! RESULTS VECTOR TOO BIG");
			}
	}
	
	public String getTeamName(){
		return currentTeam;
	}
	public Vector<String> getResultsVector(){
		return results;
	}
}
