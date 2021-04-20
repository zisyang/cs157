/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hibernate_xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.committee.CommitteeType;

/**
 *
 * @author sean
 */

@Entity
@Table(name="committee")
public class Committee {
    
    private int id;
    private String name;
    private List<Congressman> congressmen = new ArrayList<Congressman>();
    
    public Committee() {};
    
    public Committee(String name) {
        
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name="committee_id")
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    
    @Column(name="name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManyToMany
    @JoinTable(name="congressman_committee", 
            joinColumns={@JoinColumn(name="committee_id")},
            inverseJoinColumns={@JoinColumn(name="congressman_id")})
    public List<Congressman> getCongressmen() { return congressmen; }
    public void setCongressmen(List<Congressman> congressmen) { this.congressmen = congressmen;}    
    
    
    /**
     * Load the Congressman table
     */
    public static void load() {
        
        File xmlDocument = new File("xml_and_schema//committee_table.xml");
        
        if(!xmlDocument.exists()) {
        	System.out.println("XML file not found");
        	return;
        }
        
        JAXBUnmarshaller_committee.unMarshall(xmlDocument);
        
    }
    
    /**
     * List all the committee
     */
    public static void list() {
        Session session = HibernateContext.getSession();
        Query query = session.createQuery("from Committee");
        
        System.out.println("\nAll committees: ");
        
        try {
	        for(Committee c : (List<Committee>)query.list()) {
	            c.print();
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
    }
       
    /**
     * Print committee attributes
     */
    public void print() {
        System.out.printf("%d: %s\n", id, name);
    }    
}
