
import java.util.*;
import java.sql.*;

public class RunnerDB implements RunnerDAO
{
    ArrayList<Runner> runners = new ArrayList<Runner>();

    private Connection connect()
    {
        Connection connection = null;
        
        try
        {
            String dbDirectory = "resources";
            System.setProperty("derby.system.home", dbDirectory);

            String url = "jdbc:derby:RunnersDB";
            String user = "";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e)
        {
            System.err.println("Error loading database driver: " + e);
        }
        
        /*
        try {
        	String dbUrl = "jdbc:derby:RunnersDB";
            connection = DriverManager.getConnection(dbUrl);        
        } catch (SQLException e) {
            System.err.println(e);
           
        } 
        */       
 
        
        return connection;
    }

	@Override
	public ArrayList<Runner> getRunners() {
		String query = "SELECT * FROM RunnersStats";
        try {
            Connection connection = connect();
 
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
            	String runnersName = rs.getString("Name");
				double runnersSpeed = rs.getDouble("RunnersSpeed");
				double restPercentage = rs.getDouble("RestPercentage");
				Runner r = new Runner(runnersName, runnersSpeed, restPercentage);
	            runners.add(r);
			}
            rs.close();
            ps.close();
            connection.close();
            return runners;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();  // for debugging
            return null;
        }
    }

	@Override
	public boolean addRunner(Runner r) {
			runners.add(r);
			return true;
	}
}
