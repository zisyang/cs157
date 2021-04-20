import java.sql.*;
import java.util.*;



import cs.jdbc.driver.CompositeConnection;

public class CompositeJDBC 
{
	private static final String DATASOURCE = "TRexDB";
	private static final String HOST       = "cs08.cs.sjsu.edu";     
	private static final String USERNAME   = "trex";
	private static final String PASSWORD   = "S13trex";
	private static final String DOMAIN     = "composite";
	private static final int    PORT       = 9401;  

	/**
	 * connect to the database
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connect() 
			throws ClassNotFoundException, SQLException
			{
		Class.forName("cs.jdbc.driver.CompositeDriver");
		String url = "jdbc:compositesw:dbapi@" + HOST + ":" + PORT + 
				"?domain=" + DOMAIN + "&dataSource=" + DATASOURCE;
		Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
		CompositeConnection compConn = (CompositeConnection) conn;
		compConn.clearAllDataSourceCredentials();
		compConn.setDataSourceCredentials(DATASOURCE, USERNAME, PASSWORD);
		return conn;
			}

	/**
	 * close connection
	 * @param conn
	 * @throws SQLException
	 */
	private void closeConnection(Connection conn) throws SQLException
	{
		if (conn != null) conn.close();
	}

	/**
	 * get the attraction list from the database
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private HashMap<Integer, String> getAttractionList(Connection conn) throws SQLException
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null; 
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		try 
		{
			stmt = conn.createStatement();
			stmt.execute("SELECT distinct name AS attraction " +
					"FROM TRexView");

			rs = stmt.getResultSet();
			rsmd = rs.getMetaData();

			int count = 1;
			while (rs.next()) 
			{
				map.put(new Integer(count++), (String)rs.getString(1));
			}

		}
		finally
		{
			if (rs   != null) 
				rs.close();
			if (stmt != null) stmt.close();
			//if (conn != null) conn.close();

		}
		return map;
	}


	/**
	 * process query and print the output
	 * @param conn
	 * @param query
	 * @throws SQLException
	 */
	private void printQuery(Connection conn, String query) throws SQLException
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;  

		try 
		{
			stmt = conn.createStatement();
			stmt.execute(query);
			rs = stmt.getResultSet();
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			this.printHeaders(rsmd, colCount);
			while (rs.next()) 
			{
				for (int i = 1; i <= colCount; i++)
				{
					System.out.format("%-38s", rs.getString(i));
				}
				System.out.println();
			}

		}
		finally 
		{
			if (rs   != null)
				rs.close();
			if (stmt != null) stmt.close();
			//if (conn != null) conn.close();
		}
	}


	/**
	 * print headers out query results
	 * @param rsmd
	 * @param colCount
	 * @throws SQLException
	 */
	private void printHeaders(ResultSetMetaData rsmd, int colCount)
			throws SQLException
			{
		int lengths[] = new int[colCount + 1];

		for (int i = 1; i <= colCount; i++) {
			String colName = rsmd.getColumnName(i);
			lengths[i] = colName.length();
			System.out.format("%-38s", colName);
		}
		System.out.println();

		for (int i = 1; i <= colCount; i++) {
			String dashes = "----------------".substring(0, lengths[i]);
			System.out.format("%-38s", dashes);
		}
		System.out.println();
			}


	/**
	 * Print the value for the query result
	 * @param conn
	 * @param query
	 * @throws SQLException
	 */
	private void printValues(Connection conn, String query) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		ArrayList<String> values = new ArrayList<String>();

		try 
		{
			stmt = conn.createStatement();
			stmt.execute(query);
			rs = stmt.getResultSet();
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			//this.printHeaders(rsmd, colCount);
			while (rs.next()) 
			{
				for (int i = 1; i <= colCount; i++)
				{
					values.add(rs.getString(i));
				}
			}

			for(String s : values) {
				System.out.println(s);
			}

		}
		finally 
		{
			if (rs   != null)
				rs.close();
			if (stmt != null) stmt.close();
			//if (conn != null) conn.close();
		}
	}


	/**
	 * main function
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String args[]) throws SQLException 
	{
		Connection conn;
		CompositeJDBC composite = new CompositeJDBC();

		try 
		{
			conn = composite.connect();
			HashMap<Integer, String> map = composite.getAttractionList(conn);
			boolean exit=false;
			do 
			{
				System.out.println("*****************************************");
				System.out.println("*                                       *");
				System.out.println("*    Pick an attraction by entering     *");
				System.out.println("*    attraction's id                    *");
				System.out.println("*                                       *");
				System.out.println("*****************************************");

				//print out the attraction list
				for (Integer key : map.keySet())
				{
					System.out.format("%-2d %-38s", key, map.get(key));
					System.out.println();
				}
				//print out the quit option
				System.out.format("%-2s %-38s", "q", "Quit");
				System.out.println();

				//get user input for an attraction using id
				Scanner scanner = new Scanner (System.in);
				System.out.print("Enter attraction's id: ");  
				String input  = scanner.next();
				int attractionID = 0;
				try 
				{
					attractionID = Integer.parseInt(input);
					if(attractionID > map.size() || attractionID < 1)
						throw(new NumberFormatException());
				}
				catch (NumberFormatException e)
				{
					if(input.equalsIgnoreCase("q"))
					{
						exit = true;
						System.out.println("Thank you for using! See you soon!");
						composite.closeConnection(conn);

						System.exit(0);
					}
					else 
						System.out.println("Invalid id");

				}
				System.out.println();

				if(attractionID <= map.size() && attractionID >=1) 
				{
					//print info for the selected attraction
					String q = "select distinct name as Attraction, Location as address, zipcode as Zipcode from TRexView" +
							" where name = '" + map.get(attractionID) + "'";
					composite.printValues(conn, q);
					System.out.println();

					//prompt for finding restaurant or parking option
					System.out.println("What are you looking for?");
					System.out.println("1 Find restaurants near the attraction");
					System.out.println("2 Find parkings near the attraction");
					scanner = null;
					input = null;
					scanner = new Scanner (System.in);
					System.out.print("Enter your option: ");
					input = scanner.next();
					int option = 0;
					try 
					{
						option = Integer.parseInt(input);
						if (option == 1)
						{
							String query = "select distinct name as Attraction, r_name as Restaurant, r_location as Location," +
									" r_category as Category from TRexView where" +
									" name = " + "'" + map.get(attractionID) + "'" ;
							composite.printQuery(conn, query);
						}
						else if (option == 2)
						{
							String query = "select distinct name as Attraction, p_name as Parking, p_location as Location" +
									" from TRexView where" +
									" name = " + "'" + map.get(attractionID) + "'" ;
							composite.printQuery(conn, query);
						}
						else 
						{
							System.out.println("No result found");
						}

					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid option");
						//System.exit(0);
					}
				}
				System.out.println();
			}while(!exit);

			composite.closeConnection(conn);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}