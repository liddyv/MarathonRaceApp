import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public final class RunnerTextFile implements RunnerDAO
{
	private String dirPath;
	private Path runnersPath = null;
    private ArrayList<Runner> runners = null;
    private final String FIELD_SEP = ",";

    public RunnerTextFile()
    {
    	dirPath = "./resources";
    	runnersPath = Paths.get(dirPath,"runners.txt");
        runners = this.getRunners();
    }


 	@Override
    public ArrayList<Runner> getRunners()
    {
        // if the products file has already been read, don't read it again
        if (runners != null)
            return runners;        

        runners = new ArrayList<>();        
        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            try (BufferedReader in = 
                     new BufferedReader(
                     new FileReader(runnersPath.toFile())))
            {
                // read all products stored in the file
                // into the array list
                String line = in.readLine();
                while(line != null)
                {
                    String[] columns = line.split(FIELD_SEP);
                    String runnersName = columns[0].trim();
                    int runnersSpeed = Integer.parseInt(columns[1].trim());
                    int restPercentage = Integer.parseInt(columns[2].trim());
                    
                    Runner r = new Runner(
                    		runnersName, runnersSpeed, restPercentage);

                    runners.add(r);

                    line = in.readLine();                    
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return runners;            
    }

	@Override
	public boolean addRunner(Runner r) {
		runners.add(r);
		return true;
	}
}