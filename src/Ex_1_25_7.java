/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Ex_1_25_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length ==2) {

		File toRead = new File(args[0]);
		
		ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();

		try {
			Scanner sc = new Scanner(toRead);

			while (sc.hasNextLine()) {
				
				FootballMatch match = new FootballMatch();

				String lineValues[] = sc.nextLine().split("::");
				match.setLocalTeam(lineValues[0]);

				match.setVisitorTeam(lineValues[1]);

				match.setGoalsLocal(Integer.parseInt(lineValues[2]));

				match.setGoalsVisitor(Integer.parseInt(lineValues[3]));
			
				matches.add(match);

			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	File toRead2 = new File(args[1]);
		
		ArrayList<Team> teams = new ArrayList<Team>();

		try {
			Scanner sc = new Scanner(toRead2);

			while (sc.hasNextLine()) {
				
				Team team1 = new Team();

				String lineValues[] = sc.nextLine().split("::");
				team1.setName(lineValues[0]);
				
				team1.setStadium(lineValues[1]);
				
				team1.setWonLeagues(Integer.parseInt(lineValues[2]));

				team1.setShirtColor(lineValues[3]);
			
				teams.add(team1);

			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("There are " + matches.size() + " matches\n" + "They are: \n");
		for (int a = 0; matches.size() - 1 >= a; a++) {
			System.out.println(matches.get(a).getLocalTeam() + " " + matches.get(a).getGoalsLocal() + " - "
					+ matches.get(a).getGoalsVisitor() + " " + matches.get(a).getVisitorTeam());
		
			int indexLocal = 0;
			int indexVisitor = 0;

			for (int b = 0; teams.size() - 1 >= b; b++) {

				if (matches.get(a).getLocalTeam().matches(teams.get(b).getName())) {

					indexLocal = b;
				}
				if (matches.get(a).getVisitorTeam().matches(teams.get(b).getName())) {

					indexVisitor = b;
				}
				

			}

			System.out.println("\nThe info of the team " + matches.get(a).getLocalTeam() + " is:\n" + "Name:"
					+ teams.get(indexLocal).getName() + "\nStadium: " + teams.get(indexLocal).getStadium() + "\nWon Leagues: "
					+ teams.get(indexLocal).getWonLeagues() + "\nShirt color: " + teams.get(indexLocal).getShirtColor()+ "\n");
			System.out.println("The info of the team " + matches.get(a).getVisitorTeam() + " is:\n" + "Name: "
					+ teams.get(indexVisitor).getName() + "\nStadium: " + teams.get(indexVisitor).getStadium()
					+ "\nWon Leagues: " + teams.get(indexVisitor).getWonLeagues() + "\nShirt color: "
					+ teams.get(indexVisitor).getShirtColor()+"\n\n");


		}
		
		}
		
		else if(args.length <2)
		{
			
			System.out.println("Not enough information. Please run again the program and enter the file with the matches info and the file with the team info.");
			
		}
		
		else {
			
			System.out.println("So many information. Please run again the program and enter the file with the matches info and the file with the team info");
			
		}

	}

}