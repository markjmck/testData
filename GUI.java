import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI {	
	private JFrame frame;
	private Vector<Standings> finalStandings = new Vector<Standings>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() { 
		initialize();
	}
	
	public void initialize(){
		frame = new JFrame("MY Software For Predicting Matches");
		frame.getContentPane().setForeground(new Color(240, 255, 255));
		frame.getContentPane().setBackground(new Color(235, 235, 235));
		frame.setBounds(100, 100, 452, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton premierLeague = new JButton("Premier League");
		premierLeague.setForeground(Color.BLACK);
		premierLeague.setBounds(30, 70,161,30);
		frame.getContentPane().add(premierLeague);
		premierLeague.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Main main = new Main("prem1516predictions.txt" );
				finalStandings = main.runCode();
				StringBuilder bld = new StringBuilder();
				String presentation = "";
				presentation = String.format("%-15s %-8s %-8s %-8s %-8s","Team Name", "Wins", "Draws", "Losses", "Points");
				bld.append(presentation);
				bld.append("\n");
				for(int i = 0; i < finalStandings.size(); i++){
					//presentation = presentation +  finalStandings.get(i).getTeam() + "	" + finalStandings.get(i).getWins() + "            " + finalStandings.get(i).getDraws() + "              " + finalStandings.get(i).getLosses() + "             " + finalStandings.get(i).getPoints() + "\n";
					String results2 = String.format("%-15s %-8s %-8s %-8s %-8s" , finalStandings.get(i).getTeam(), finalStandings.get(i).getWins(), finalStandings.get(i).getDraws(), finalStandings.get(i).getLosses(), finalStandings.get(i).getPoints());
					bld.append(results2);
					bld.append("\n");
				}
				presentation = "\n" + "Saving option is triggered when okay "+ "\n" + "is pressed. \n";
				bld.append(presentation);
				double successfullyPredicted = main.getSuccessfullyPredicted();
				String predicted = Double.toString(successfullyPredicted);
				String results = "The number of games predicted correctly for this \nseason were: ";
				bld.append(results);
				bld.append(predicted);
				JTextArea textArea = new JTextArea(15,30);
				textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
				textArea.setText(bld.toString());
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				Dimension preferredSize = new Dimension();
				preferredSize.setSize(380, 500);
				scrollPane.setPreferredSize(preferredSize);
				JOptionPane.showMessageDialog(null, scrollPane, "RESULTS FOR PREMIER LEAGUE", JOptionPane.PLAIN_MESSAGE);
				try {
					saving(bld.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton ligaBBva = new JButton("LIGA BBVA");
		ligaBBva.setForeground(Color.BLACK);
		ligaBBva.setBounds(30, 170, 161, 30);
		frame.getContentPane().add(ligaBBva);
		ligaBBva.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main main = new Main("spainmaster1516.txt");
				finalStandings = main.runCode();
				StringBuilder bld = new StringBuilder();
				String presentation = "";
				presentation = String.format("%-12s %-8s %-8s %-8s %-8s","Team Name", "Wins", "Draws", "Losses", "Points");
				bld.append(presentation);
				bld.append("\n");
				for(int i = 0; i < finalStandings.size(); i++){
					//presentation = presentation +  finalStandings.get(i).getTeam() + "	" + finalStandings.get(i).getWins() + "            " + finalStandings.get(i).getDraws() + "              " + finalStandings.get(i).getLosses() + "             " + finalStandings.get(i).getPoints() + "\n";
					String results2 = String.format("%-12s %-8s %-8s %-8s %-8s" , finalStandings.get(i).getTeam(), finalStandings.get(i).getWins(), finalStandings.get(i).getDraws(), finalStandings.get(i).getLosses(), finalStandings.get(i).getPoints());
					bld.append(results2);
					bld.append("\n");
				}
				presentation = "\n" + "Saving option is triggered when okay "+ "\n" + "is pressed. \n";
				bld.append(presentation);
				double successfullyPredicted = main.getSuccessfullyPredicted();
				String predicted = Double.toString(successfullyPredicted);
				String results = "The number of games predicted correctly for this \nseason were: ";
				bld.append(results);
				bld.append(predicted);
				JTextArea textArea = new JTextArea(15,30);
				textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
				textArea.setText(bld.toString());
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				Dimension preferredSize = new Dimension();
				preferredSize.setSize(380, 500);
				scrollPane.setPreferredSize(preferredSize);
				JOptionPane.showMessageDialog(null, scrollPane, "RESULTS FOR Liga BBVA", JOptionPane.INFORMATION_MESSAGE);
				try {
					saving(bld.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JButton Ligue1 = new JButton ("Ligue 1");
		Ligue1.setForeground(Color.BLACK);
		Ligue1.setBounds(250, 70, 161, 30);
		frame.getContentPane().add(Ligue1);
		Ligue1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main main = new Main("frenchleaguemaster1516.txt");
				finalStandings = main.runCode();
				StringBuilder bld = new StringBuilder();
				String presentation = "";
				presentation = String.format("%-12s %-8s %-8s %-8s %-8s","Team Name", "Wins", "Draws", "Losses", "Points");
				bld.append(presentation);
				bld.append("\n");

				for(int i = 0; i < finalStandings.size(); i++){
					//presentation = presentation +  finalStandings.get(i).getTeam() + "	" + finalStandings.get(i).getWins() + "            " + finalStandings.get(i).getDraws() + "              " + finalStandings.get(i).getLosses() + "             " + finalStandings.get(i).getPoints() + "\n";
					String results2 = String.format("%-12s %-8s %-8s %-8s %-8s" , finalStandings.get(i).getTeam(), finalStandings.get(i).getWins(), finalStandings.get(i).getDraws(), finalStandings.get(i).getLosses(), finalStandings.get(i).getPoints());
					bld.append(results2);
					bld.append("\n");
				}
				presentation = "\n" + "Saving option is triggered when okay "+ "\n" + "is pressed. \n";
				bld.append(presentation);
				double successfullyPredicted = main.getSuccessfullyPredicted();
				String predicted = Double.toString(successfullyPredicted);
				String results = "The number of games predicted correctly for this \nseason were: ";
				bld.append(results);
				bld.append(predicted);
				JTextArea textArea = new JTextArea(15,30);
				textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
				textArea.setText(bld.toString());
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				Dimension preferredSize = new Dimension();
				preferredSize.setSize(380, 500);
				scrollPane.setPreferredSize(preferredSize);
				JOptionPane.showMessageDialog(null, scrollPane, "RESULTS FOR Ligue 1", JOptionPane.INFORMATION_MESSAGE);
				try {
					saving(bld.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		JButton Bundesliga = new JButton ("Bundesliga");
		Bundesliga.setForeground(Color.BLACK);
		Bundesliga.setBounds(30, 280, 161, 30);
		frame.getContentPane().add(Bundesliga);
		Bundesliga.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main main = new Main("bundesligamaster1516.txt");
				finalStandings = main.runCode();
				StringBuilder bld = new StringBuilder();
				String presentation = "";
				presentation = String.format("%-15s %-8s %-8s %-8s %-8s","Team Name", "Wins", "Draws", "Losses", "Points");
				bld.append(presentation);
				bld.append("\n");

				for(int i = 0; i < finalStandings.size(); i++){
					String results2 = String.format("%-15s %-8s %-8s %-8s %-8s" , finalStandings.get(i).getTeam(), finalStandings.get(i).getWins(), finalStandings.get(i).getDraws(), finalStandings.get(i).getLosses(), finalStandings.get(i).getPoints());
					bld.append(results2);
					bld.append("\n");
				}
				presentation = "\n" + "Saving option is triggered when okay "+ "\n" + "is pressed. \n";
				bld.append(presentation);
				double successfullyPredicted = main.getSuccessfullyPredicted();
				String predicted = Double.toString(successfullyPredicted);
				String results = "The number of games predicted correctly for this \nseason were: ";
				bld.append(results);
				bld.append(predicted);
				JTextArea textArea = new JTextArea(15,30);
				textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
				textArea.setText(bld.toString());
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				Dimension preferredSize = new Dimension();
				preferredSize.setSize(380, 500);
				scrollPane.setPreferredSize(preferredSize);
				JOptionPane.showMessageDialog(null, scrollPane, "RESULTS FOR Bundesliga", JOptionPane.INFORMATION_MESSAGE);
				try {
					saving(bld.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		
		
		JButton serieA = new JButton ("Serie A");
		serieA.setForeground(Color.BLACK);
		serieA.setBounds(250, 170, 161, 30);
		frame.getContentPane().add(serieA);
		serieA.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main main = new Main("serieamaster1516.txt");
				finalStandings = main.runCode();
				StringBuilder bld = new StringBuilder();
				String presentation = "";
				presentation = String.format("%-12s %-8s %-8s %-8s %-8s","Team Name", "Wins", "Draws", "Losses", "Points");
				bld.append(presentation);
				bld.append("\n");
				for(int i = 0; i < finalStandings.size(); i++){
					String results2 = String.format("%-12s %-8s %-8s %-8s %-8s" , finalStandings.get(i).getTeam(), 
					finalStandings.get(i).getWins(), finalStandings.get(i).getDraws(), finalStandings.get(i).getLosses(), finalStandings.get(i).getPoints());
					bld.append(results2);
					bld.append("\n");
				}
				presentation = "\n" + "Saving option is triggered when okay "+ "\n" + "is pressed. \n";
				bld.append(presentation);
				double successfullyPredicted = main.getSuccessfullyPredicted();
				String predicted = Double.toString(successfullyPredicted);
				String results = "The number of games predicted correctly for this \nseason were: ";
				bld.append(results);
				bld.append(predicted);
				JTextArea textArea = new JTextArea(15,30);
				textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
				textArea.setText(bld.toString());
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				Dimension preferredSize = new Dimension();
				preferredSize.setSize(380, 500);
				scrollPane.setPreferredSize(preferredSize);
				JOptionPane.showMessageDialog(null, scrollPane, "RESULTS FOR Serie A", JOptionPane.INFORMATION_MESSAGE);
				try {
					saving(bld.toString());
				} catch (IOException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		
		JButton exit = new JButton ("EXIT PROGRAM");
		exit.setForeground(Color.BLACK);
		exit.setBounds(250, 280, 161, 30);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
	}
	
	public void saving(String standings) throws IOException{
		String output = "Would you like to save these results? \n";
		try{
			Object[] whichType = {"Save" , "Discard"};
			Object listType = JOptionPane.showInputDialog(null,output, "Results",
					JOptionPane.QUESTION_MESSAGE, null,
					whichType, whichType[0]);
			if(listType =="Save"){
				saveToFile(standings);
			}
		}catch(NullPointerException exception){
		}
	}
	
	public void saveToFile(String standings) throws IOException{
		JFrame frame2 = new JFrame("Saving");
		String fileName = JOptionPane.showInputDialog(frame2, "Please enter the name of the file that you wish to save too");
		try(Writer myWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))){
			myWriter.append(standings);
		}
	}

}


