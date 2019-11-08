public class DAOFactory
{
    // this method maps the RunnerDAO interface
    // to the appropriate data storage mechanism
    public static RunnerDAO getRunnerDAO(String strDatabase)
    {
        RunnerDAO rDAO; 
    		switch (strDatabase) {
    		case "derby":
    	        rDAO = new RunnerDB();
    			break;
    		case "xml":
    	        rDAO = new RunnerXMLFile();
    			break;
    		case "txt":
    		default:
    	        rDAO = new RunnerTextFile();
    		}
        return rDAO;
    }
}