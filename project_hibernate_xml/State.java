/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hibernate_xml;

import java.io.File;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.state.StateType;

/**
 *
 * @author sean
 */

@Entity
@Table(name="state")
public class State {

    private int id;
    private String stateCode;
    private List<Congressman> congressmen;
    
    public State() {}
    
    public State(String stateCode) {
        
        this.stateCode = stateCode;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name="state_code")
    public String getStateCode() { return stateCode; }
    public void setStateCode(String stateCode) { this.stateCode = stateCode; }
    
    @OneToMany(mappedBy="state", targetEntity=Congressman.class,
            cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List<Congressman> getCongressmen() { return congressmen; }
    public void setCongressmen(List<Congressman> congressmen) { this.congressmen = congressmen; }
    
    
    /**
     * Load the state table
     */
    public static void load() {
        
    	File xmlDocument = new File("xml_and_schema//state_table.xml");
    	
    	if(!xmlDocument.exists()) {
        	System.out.println("XML file not found");
        	return;
    	}
    	
    	JAXBUnmarshaller_state.unMarshall(xmlDocument);
    }
    
    /**
     * List all the states
     */
    public static void list() {
        Session session = HibernateContext.getSession();
        Query query = session.createQuery("from State");
        
        System.out.println("\nAll states: ");
        
        try {
	        for(State s : (List<State>)query.list()) {
	            s.print();
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    /**
     * Find the state by its code
     * @param stateCode the name code for the state
     * @return a State object
     */
    public static State find(String stateCode) {
        
    	State state = null;
    	
        Session session = HibernateContext.getSession();
        Query query = 
                session.createQuery("from State where state_code = :stateCode");    
        query.setString("stateCode", stateCode);
        
        try {
        	state = (State)query.uniqueResult();
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
        return state;
    }    
    
    /**
     * Print state attributes
     */
    public void print() {
        System.out.printf("%d: %s\n", id, stateCode);
    }
    
}
