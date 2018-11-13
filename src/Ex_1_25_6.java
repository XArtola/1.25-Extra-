import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
public class Ex_1_25_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList> dataBase = new ArrayList<ArrayList>();

		for (int a = 0; args.length - 1 >= a; a++) {

			File toRead = new File(args[a]);

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
			dataBase.add(matches);
		}

		for (int b = 0; dataBase.size() - 1 >= b; b++) {

			System.out.println("There are " + dataBase.get(b).size() + " matches in the number " + (b + 1)
					+ " result chart\n" + "They are: \n");
			for (int c = 0; dataBase.get(b).size() - 1 >= c; c++)
				System.out.println(((FootballMatch) dataBase.get(b).get(c)).getLocalTeam() + " "
						+ ((FootballMatch)dataBase.get(b).get(c)).getGoalsLocal() + " - "
						+ ((FootballMatch) dataBase.get(b).get(c)).getGoalsVisitor() + " "
						+ ((FootballMatch) dataBase.get(b).get(c)).getVisitorTeam());

			System.out.println("\n\n");
		}
	}
}
