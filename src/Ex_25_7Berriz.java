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

public class Ex_25_7Berriz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length == 2) {

			// Take teams info
			File toRead2 = new File(args[0]);

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

			File toRead = new File(args[1]);

			ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();

			try {
				Scanner sc = new Scanner(toRead);

				while (sc.hasNextLine()) {

					FootballMatch match = new FootballMatch();

					String lineValues[] = sc.nextLine().split("::");

					for (int a = 0; a < teams.size(); a++) {

						if (lineValues[0].matches(teams.get(a).getName())) {

							match.setLocalTeam(teams.get(a));

						}

						else if (lineValues[1].matches(teams.get(a).getName())) {

							match.setVisitorTeam(teams.get(a));

						}

					}

					match.setGoalsLocal(Integer.parseInt(lineValues[2]));

					match.setGoalsVisitor(Integer.parseInt(lineValues[3]));

					matches.add(match);

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("There are " + matches.size() + " matches\n" + "They are: \n");

			for (int a = 0; a <= matches.size()-1; a++) {

				System.out.println(matches.get(a).getLocalTeam().getName() + " " + matches.get(a).getGoalsLocal() + " - "
						+ matches.get(a).getGoalsVisitor() + " " + matches.get(a).getVisitorTeam().getName());

				System.out.println("\n\tThe info of the team " + matches.get(a).getLocalTeam().getName() + " is:\n\n"
						+ "\t\tName: " + matches.get(a).getLocalTeam().getName() + "\n\t\tStadium: "
						+ matches.get(a).getLocalTeam().getStadium() + "\n\t\tWon Leagues: "
						+ matches.get(a).getLocalTeam().getWonLeagues() + "\n\t\tShirt color: "
						+ matches.get(a).getLocalTeam().getShirtColor() + "\n");
				System.out.println("\n\tThe info of the team " + matches.get(a).getVisitorTeam().getName() + " is:\n\n"
						+ "\t\tName: " + matches.get(a).getVisitorTeam().getName() + "\n\t\tStadium: "
						+ matches.get(a).getVisitorTeam().getStadium() + "\n\t\tWon Leagues: "
						+ matches.get(a).getVisitorTeam().getWonLeagues() + "\n\t\tShirt color: "
						+ matches.get(a).getVisitorTeam().getShirtColor() + "\n");
			}

		}

		else if (args.length < 2) {

			System.out.println(
					"Not enough information. Please run again the program and enter the file with the matches info and the file with the team info.");

		}

		else {

			System.out.println(
					"So many information. Please run again the program and enter the file with the matches info and the file with the team info");

		}

	}

}
