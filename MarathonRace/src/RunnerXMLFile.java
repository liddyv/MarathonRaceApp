import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.*;  // StAX API
import java.util.ArrayList;

public class RunnerXMLFile implements RunnerDAO {

	private String dirPath;
	private Path runnersPath = null;
    private ArrayList<Runner> runners = null;
    private RunnerList list;

    public RunnerXMLFile()
    {
    	dirPath = "./resources";
    	runnersPath = Paths.get(dirPath,"runners.xml");
       // runners = this.getRunners();
    }
 
	@Override
	public ArrayList<Runner> getRunners() {
        // if the XML file has already been read, don't read it again
        if (runners != null)
            return runners;        

        runners = new ArrayList<>();        
        Runner r = null;        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(runnersPath.toFile());
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                String runnersName = "";
    			double runnersSpeed = 0;
    			double restPercentage = 0;

                // read the products from the file
                while (reader.hasNext()) {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                				runnersName = reader.getAttributeValue(0);
                           //     r.setName(runnersName);
                            }
                            if (elementName.equals("RunnersMoveIncrement"))
                            {
                            	runnersSpeed = Double.parseDouble(reader.getElementText());
                             //   r.setSpeed(runnersSpeed);
                            }
                            if (elementName.equals("RestPercentage"))
                            {
                            	restPercentage = Double.parseDouble(reader.getElementText());
                            	//r.setRestPercentage(restPercentage);
                            }
                            r = new Runner(runnersName, runnersSpeed, restPercentage);
            	            runners.add(r);
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                            	// create a runner
                            	//list.addRunner(r);
                            	runners.add(r);  
                            }
                            break;
                        
                        default:
                            break;
                    }
                    reader.next();
                }
            }
            catch (IOException | XMLStreamException e)
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
