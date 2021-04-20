/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Method createQueries() was copied 
 * from http://www.coderanch.com/t/306966/JDBC/databases/Execute-sql-file-java
 */
public class ExecuteManagement {
    
    private static ExecuteManagement instance;
    
    private ExecuteManagement() {
    }
    
    protected static synchronized ExecuteManagement getInstance() {
        if (instance == null) {
            instance = new ExecuteManagement();
        }
        return instance;
    }

    /**
     *
     * @param con
     * @param sql
     * @return -1 if get error
     */
    protected int executeSQL(Connection con, String sql) {
        int res = 0;
        try {
            Statement stmnt = con.createStatement();
            res = stmnt.executeUpdate(sql);
            
            stmnt.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return -1;
        }
        return res;
    }
    
    protected static void printDBTableNames(Connection con) {
        ResultSet rs = null;
        
        String stmntStr = "SELECT TABLE_NAME FROM USER_TABLES";
        
        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);
            
            System.out.println("\n--- All Tables ---\n");
            int i = 0;
            while (rs.next()) {
                i++;
                System.out.println(i + ") " + rs.getString(1));
            }
            System.out.println("\n");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    protected int executeSQLFile(Connection con, String fileName, String path) {
        int res = 0;
        ArrayList<String> array = createQueries(path+fileName);
        for (String s : array) {
            s = s.trim();
            if (!s.startsWith("@")) {
                executeSQL(con, s);
                res++;
            }
            else
            {
                String newS;
                newS = s.substring(1);
                newS = newS.replaceAll("\"", "");
                System.out.println(newS);
                res += executeSQLFile(con, newS, path);
            }
        }
        return res;
    }
    
    private static ArrayList<String> createQueries(String path) {
        String queryLine = new String();
        StringBuffer sBuffer = new StringBuffer();
        ArrayList listOfQueries = new ArrayList<String>();
        
        try {
            FileReader fr = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(fr);

            //read the SQL file line by line
            while ((queryLine = br.readLine()) != null) {
                // ignore comments beginning with #
                int indexOfCommentSign = queryLine.indexOf('#');
                if (indexOfCommentSign != -1) {
                    if (queryLine.startsWith("#")) {
                        queryLine = new String("");
                    } else {
                        queryLine = new String(queryLine.substring(0, indexOfCommentSign - 1));
                    }
                }
                // ignore comments beginning with --
                indexOfCommentSign = queryLine.indexOf("--");
                if (indexOfCommentSign != -1) {
                    if (queryLine.startsWith("--")) {
                        queryLine = new String("");
                    } else {
                        queryLine = new String(queryLine.substring(0, indexOfCommentSign - 1));
                    }
                }
                // ignore comments surrounded by /* */
                indexOfCommentSign = queryLine.indexOf("/*");
                if (indexOfCommentSign != -1) {
                    if (queryLine.startsWith("#")) {
                        queryLine = new String("");
                    } else {
                        queryLine = new String(queryLine.substring(0, indexOfCommentSign - 1));
                    }
                    
                    sBuffer.append(queryLine + " ");
                    // ignore all characters within the comment
                    do {
                        queryLine = br.readLine();
                    } while (queryLine != null && !queryLine.contains("*/"));
                    indexOfCommentSign = queryLine.indexOf("*/");
                    if (indexOfCommentSign != -1) {
                        if (queryLine.endsWith("*/")) {
                            queryLine = new String("");
                        } else {
                            queryLine = new String(queryLine.substring(indexOfCommentSign + 2, queryLine.length() - 1));
                        }
                    }
                }

                //  the + " " is necessary, because otherwise the content before and after a line break are concatenated
                // like e.g. a.xyz FROM becomes a.xyzFROM otherwise and can not be executed 
                if (queryLine != null) {
                    sBuffer.append(queryLine + " ");
                }
            }
            br.close();

            // here is our splitter ! We use ";" as a delimiter for each request 
            String[] splittedQueries = sBuffer.toString().split(";");

            // filter out empty statements
            for (int i = 0; i < splittedQueries.length; i++) {
                if (!splittedQueries[i].trim().equals("") && !splittedQueries[i].trim().equals("\t")) {
                    listOfQueries.add(new String(splittedQueries[i]));
                }
            }
        } catch (Exception e) {
            System.out.println("*** Error : " + e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            e.printStackTrace();
            System.out.println("################################################");
            System.out.println(sBuffer.toString());
        }
        return listOfQueries;
    }
}
