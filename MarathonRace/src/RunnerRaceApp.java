import java.util.Scanner;

/**
 * @author: WanLing Hsieh
 * description: Final project - RunnerRaceApp.java
 * A sports company has hired you to write an application that would simulate a
 * marathon race between interesting groups of participants. They could be slow as a tortoise, as
 * fast as a hare, and anything in between. The runners differ in their speed and how often they need
 * to rest. Some may be slow and never rest; others may run fast but lose steam quickly and rest a
 * lot of the time. Still others could be anything in between.
 */

public class RunnerRaceApp {
	private static RunnerDAO runnerDAO = null; 
	private static Scanner sc = null; 
	
	public static void main (String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Marathon Race Runner Program \n");
		System.out.println("Select your data source: \n");
		MarathonRace race = new MarathonRace();
		
		// create the Scanner object
		sc = new Scanner(System.in);		

        race.displayMenu();
 
        int menu = 0;
		// perform 1 or more actions
        while (!(menu == 5))
 		{	
           	// get input from user
        	menu = Validator.getIntWithinRange(sc,  "Enter your choice: ", 1, 5);
        	
 			// Derby Database
 			if (menu == 1) {
 				// read derby DB
 				runnerDAO = DAOFactory.getRunnerDAO("derby"); 	
 				// get runner list and start race
 				race.startRunnerRace(runnerDAO.getRunners());
 			}
 			// XML file
 			else if (menu == 2) {
 				String fileName = Validator.getRequiredString(sc, "Enter XML file name: ");
 				if (fileName.equalsIgnoreCase("runners.xml")) {
 					// read runners.xml file
 	 				runnerDAO = DAOFactory.getRunnerDAO("xml"); 	
 	 				// get runner list and start race
 	 				race.startRunnerRace(runnerDAO.getRunners());
 					
 				}else 
 					System.out.printf("Failed to create runners from %s\n", fileName);
 			}
 			// Text file
 			else if (menu == 3) {
 				String fileName = Validator.getRequiredString(sc, "Enter TEXT file name: ");
 				if (fileName.equalsIgnoreCase("runners.txt")) {
 					// read runners.xml file
 	 				runnerDAO = DAOFactory.getRunnerDAO("txt"); 	
 	 				// get runner list and start race
 	 				race.startRunnerRace(runnerDAO.getRunners());
 					
 				}else 
 					System.out.printf("Failed to create runners from %s\n", fileName);
 			}
			// Default two runners
 			else if (menu == 4) {
 				race.startDefaultTwoRunnersRace();
 				break;
 			}
			// Exit
 			else if (menu == 5) {
 				System.out.println();
 				System.out.println("Thank you for using my Marathon Race Program");
 			}
 			else {
 				System.out.println("Error! You typed in wrong menu number.");
 			}
 		//if (menu !=5)
 			Validator.waitAnyKey(sc); // wait for any key to be entered
 		} // end while
	} // end main		   
} // end RunnerRace class
