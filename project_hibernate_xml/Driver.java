/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hibernate_xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author sean
 */
public class Driver {
    
    private static final String HELP_MSG = 
            "* ---------------- Commands ---------------- *\n"
            + "* create, load, find <congressman_id>        *\n"
            + "* congressmen, districts, committees, states *\n"
            + "* createXMLs                                 *\n"
            + "* whosInDistrict <district_name>             *\n"
            + "* whosInState <state_code>                   *\n"
            + "* whosInCommittee <committee_name>           *\n"
            + "* quit                                       *\n"
            + "* ------------------------------------------ *";
    
    public static void main(String[] args) {
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        
        Class[] clases = {State.class, District.class, Congressman.class, Committee.class};
        
        HibernateContext.addClasses(clases);
        
        do {
            System.out.println();
            System.out.println(HELP_MSG);
            System.out.print("Command? ");
            
            try {
                command = stdin.readLine();
            }
            catch(java.io.IOException ex) {
                command = "?";
            }
            
            String parts[] = command.split(" ");
            
            if(command.equalsIgnoreCase("create")) {
                HibernateContext.createSchema();
            }
            
            else if(command.equalsIgnoreCase("load")) {
                State.load();
                District.load();
                Congressman.load();
                Committee.load();
            }
            
            else if(command.equalsIgnoreCase("congressmen")) {
                Congressman.list();
            }
            
            else if(command.equalsIgnoreCase("districts")) {
                District.list();
            }
            
            else if(command.equalsIgnoreCase("committees")) {
                Committee.list();
            }
            
            else if(command.equalsIgnoreCase("states")) {
                State.list();
            }
            
            else if(command.equalsIgnoreCase("createXMLs")) {
            	JAXBMarshaller_committee.generateXMLDocument();
            	JAXBMarshaller_congressman.generateXMLDocument();
            	JAXBMarshaller_district.generateXMLDocument();
            	JAXBMarshaller_state.generateXMLDocument();
            	
            	System.out.println("XML files exported to directory <generatedXML>");
            }
            
            else if(parts[0].equalsIgnoreCase("find") && parts.length >= 2) {
                try {
                    int id = Integer.parseInt(parts[1]);
                    Congressman congressman = Congressman.find(id);
                    
                    if(congressman != null)
                        congressman.printInSession();
                    else
                        System.out.printf("*** No congressman with id %d\n", id);
                } catch(NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
            else if(parts[0].equalsIgnoreCase("whosInDistrict") 
                    && parts.length >= 2) {
                Congressman.inDistrict(parts[1]);
            }
            
            else if(parts[0].equalsIgnoreCase("whosInState") 
                    && parts.length >= 2) {
                Congressman.inState(parts[1]);
            }
            
            else if(parts[0].equalsIgnoreCase("whosInCommittee") 
                    && parts.length >= 2) {
                Congressman.inCommittee(parts[1]);
            }
            
            else {
            	if(!command.equalsIgnoreCase("quit"))
            		System.out.println("Invalid Command");
            }
            
        } while(!command.equalsIgnoreCase("quit"));
        
        System.out.println("Bye");
        
    }
    
}
