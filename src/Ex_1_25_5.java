/**
 * 
 */

/**
 * @author Xabier
 *
 */
/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.*;

public class Ex_1_25_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File toRead = new File(args[0]);

		ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();

		try {
			Scanner sc = new Scanner(toRead);

			while (sc.hasNextLine()) {
				
				FootballMatch match = new FootballMatch(); //ZERGATIK????

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
		
		
		ListIterator li = matches.listIterator();
		
		while(li.hasNext()) {
			
			FootballMatch auxMatch = (FootballMatch) li.next(); //Konpondu
			
			if(auxMatch.getGoalsLocal()==auxMatch.getGoalsVisitor()) {
				
				System.out.println(auxMatch.getLocalTeam() + " " + auxMatch.getGoalsLocal() + " - "
						+ auxMatch.getGoalsVisitor() + " " + auxMatch.getVisitorTeam());
				
				li.remove();
			}
			
			
		}

		System.out.println("There are " + matches.size() + " matches\n" + "They are: \n");
		for (int a = 0; matches.size() - 1 >= a; a++)
			System.out.println(matches.get(a).getLocalTeam() + " " + matches.get(a).getGoalsLocal() + " - "
					+ matches.get(a).getGoalsVisitor() + " " + matches.get(a).getVisitorTeam());

	}

}
