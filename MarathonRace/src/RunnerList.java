import java.util.ArrayList;

public class RunnerList {
	
	private ArrayList<Runner> runners; 
	
	// constructor
	RunnerList() {
		 runners = new ArrayList<>();
	}
	
	/**
	 * @return runners list
	 */
	ArrayList<Runner> getRunners() {
		return runners;
	}
	
	/**
	 * @return runners Return two default runners
	 */
	ArrayList<Runner> getDefaultRunners() {
		Runner runner1 = new Runner("Hare", 100, 90);
		Runner runner2 = new Runner("Tortoise", 10, 0);
		
		runners.add(runner1);
		runners.add(runner2);
		
		return runners;
}
	/**
	 * @param runner A Runner
	 * @return true if addRunner successful
	 */
	boolean addRunner(Runner runner) {
		return runners.add(runner);
		
	}
	
	/**
	 * Clears runners 
	 */
	void clearRunners() {
		runners.clear();
	}
	
}
