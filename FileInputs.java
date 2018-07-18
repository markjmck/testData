import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class FileInputs {
	String file;
	private BufferedReader bRead;
	private Vector<Fixtures> myVector = new Vector<Fixtures>();
	private Vector<String> teams = new Vector<String>();

	public FileInputs(String fileName) throws IOException{
		file = fileName;
		readContentFromFile();
		getTeams();
	}
	
	private void readContentFromFile() throws IOException{
		String nextLine;
		try{
			FileReader fileReader = new FileReader(file);
			bRead = new BufferedReader(fileReader);
			nextLine = bRead.readLine(); //need this to skip the first line in the file that contains the headers
			while((nextLine = bRead.readLine()) != null){
				String[] splitLine = nextLine.split("\t");
				Fixtures currentFixture = new Fixtures(splitLine);
				myVector.add(currentFixture);
			}
		
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
	}
	
	private void getTeams(){
		for(int i = 0; i < myVector.size(); i++){
			if(!(teams.contains(myVector.elementAt(i).getHomeTeam()))){
				teams.add(myVector.elementAt(i).getHomeTeam());
			}
			
			if(! (teams.contains(myVector.elementAt(i).getAwayTeam()))){
				teams.add(myVector.elementAt(i).getAwayTeam());
			}
		}
	}
	
	public Vector<String> returnTeams(){
		return teams;
	}
	public Vector<Fixtures> getVector(){
		return myVector;
	}
}