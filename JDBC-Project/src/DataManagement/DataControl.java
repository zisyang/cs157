/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Connection.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataControl {

    private final static String path = "./DataFile/";
    private final static String importFile = "BULK_IMPORT.sql";
    private final static String dropFile = "DROP_ALL.sql";
    
    private static ExecuteManagement exmg = ExecuteManagement.getInstance();
    private static DBConnection dbCon;
    private static Connection con;    
    private static void readFile() {
        File file = new File(path+importFile);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //readFile();
        updateDB();
        printDBTableNames();
        
    }
    public static void dropDB()
    {
        connectDB();
        exmg.executeSQLFile(con, dropFile, path);
        disconnectDB();
    }
    public static void updateDB() {
        connectDB();
        exmg.executeSQLFile(con, importFile, path);
        disconnectDB();
    }
    public static void printDBTableNames()
    {
        connectDB();
        exmg.printDBTableNames(con);
        disconnectDB();
    }
    private static void connectDB()
    {
        dbCon = new DBConnection();
        con = dbCon.getDBConnection();
    }
    private static void disconnectDB()
    {
        dbCon.disconnectFromDB();
    }
}
