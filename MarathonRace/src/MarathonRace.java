import java.util.ArrayList;
import java.util.List;

public class MarathonRace {
	private static ArrayList<Runner> runners; 
	private RunnerList list;
	
	// constructor
	MarathonRace() {
		list = new RunnerList();
	}

	public void displayMenu() {
		System.out.print("1.  Derby database \n");
		System.out.print("2.  XML file \n");
		System.out.print("3.  Text file \n");
		System.out.print("4.  Default two runner \n");
		System.out.println("5.  Exit \n");
	}

	public List<RunnerList> readDB() {
		// TODO Auto-generated method stub
		return null;
	}

	public void startRunnerRace() {
		runners = list.getRunners();	
		try {
			Thread.sleep(100);
			System.out.println("Get Set ...Go!");
					
			for (Runner r: runners) {
				r.start();
			}
		} catch (InterruptedException e) {
			System.out.println("startDefaultTwoRunnersRace() gets interrupted ");
		}
		list.clearRunners();
	}

	public void startRunnerRace(ArrayList<Runner> runners) {
		//runners = list.getRunners();	

		try {
			Thread.sleep(100);
			System.out.println("Get Set ...Go!");
					
			for (Runner r: runners) {
				r.start();
			}
		} catch (InterruptedException e) {
			System.out.println("startRunnersRace() gets interrupted ");
		}
		list.clearRunners();
	}
	
	public void startDefaultTwoRunnersRace() {
		runners = list.getDefaultRunners();
		try {
			Thread.sleep(100);
			System.out.println("Get Set ...Go!");
					
			for (Runner r: runners) {
				r.start();
			}
		} catch (InterruptedException e) {
			System.out.println("startDefaultTwoRunnersRace() gets interrupted ");
		}
		list.clearRunners();
	}

	public void finishRunnerRace(String winner) {
		System.out.println("The race is over! The " + winner + " is the winner.");
		
		// interrupt all other threads
		Thread.currentThread().interrupt();
		
		/*
		for (Runner r: runners) {
			r.interrupt();
			System.out.println(Thread.currentThread().getName() + " : You beat me fair and squre.");			
		}		
		*/
		
	}
}
