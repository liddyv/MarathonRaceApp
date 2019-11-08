import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: WanLing Hsieh
 * description: This class implements thread for each runner
 */
class Runner extends Thread {
	//private String name;
	private double runnersSpeed;
	private double restPercentage;
	
	private int randomInt;
	private int currentDistance;
	private static final int TARGET_DISTANCE = 1000;
	private static final Object winnerLock = new Object();
	/* volatile variable will have only one main copy which will be 
	 * updated by different threads and update made by one thread to the 
	 * volatile variable will immediately reflect to the other Thread*/
	private static volatile boolean finished; 
	
	MarathonRace race = new MarathonRace();

	// Constructor initialized all variables 
	Runner(String name, double runnersSpeed, double restPercentage) {
		super(name);  
		this.runnersSpeed = runnersSpeed;
		this.restPercentage = restPercentage; 
		currentDistance = 0;
		finished = false;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " gets created"); // debug

		try {
			// while no Winner && current runner's distance < target distance
			while (finished == false && currentDistance < TARGET_DISTANCE) {
				// generate a random integer
				randomInt = getRandomInt();
				//System.out.println("randomInt: " + randomInt);//debug
				// 1st if random number > rest percentage, runner will run
				if (randomInt > restPercentage) { 
					currentDistance += runnersSpeed;
					// 2nd if current distance < 1k meters, print out currentThread name and it’s currentDistance 
					if (currentDistance < TARGET_DISTANCE) {
						System.out.println(Thread.currentThread().getName() + " : " + currentDistance);
						//continue;
					} // end 2nd if
					else // currentDistance >= TARGET_DISTANCE
						break; 
					
				} // end 1st if
				// Run method sleeps 100 milliseconds for each repetition of the loop
				Thread.sleep(100);
			} // end while
			
			synchronized(winnerLock) {
				while (finished == false) {
					finished = true; // only 1 Winner 
					
					
					String winner = Thread.currentThread().getName();
					System.out.println( winner + " : " + TARGET_DISTANCE);
					System.out.println( winner + " : I finished! \n");
				
					// Notify main thread that currentThread is the Winner and interrupt all other runners.
					//race.finishRunnerRace(winner);
					System.out.println("The race is over! The " + winner + " is the winner.");
					Thread.currentThread().interrupt();				
					
				} // end while	
				// wait for all other runners
				Thread.sleep(1000);
			} // end synchronized block
		
		} catch (InterruptedException e) {
			// all other runners got interrupted. 
			System.out.println(Thread.currentThread().getName() + " : You beat me fair and squre.");
			/*
			for (Runner r: MarathonRace.runners) {
				//r.interrupt();
				System.out.println(Thread.currentThread().getName() + " : You beat me fair and squre.");			
			}
			*/		
		}	
	} // end run()
	
	/** 
	 * @return randomInt Return random number between 1~100
	 */
	int getRandomInt() {
		return randomInt = ThreadLocalRandom.current().nextInt(1, 101);
	}
}
