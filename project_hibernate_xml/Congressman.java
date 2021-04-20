/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hibernate_xml;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import jaxb.generated.congressman.CongressmanType;


/**
 *
 * @author sean
 */

@Entity
@Table(name="congressman")
public class Congressman implements Serializable{
    
    private int id;
    private String firstName;
    private String lastName;
    private String party;
    private State state;
    private District district;
    private List<Committee> committees = new ArrayList<Committee>();

    
    public Congressman() {}
    
    public Congressman(String firstName, String lastName, String party, State state, District district) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.state = state;
        this.district = district;
    }

    @Id
    @GeneratedValue
    @Column(name="congressman_id")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name="first_name")
    public String getFirstName() { return firstName; } 
    public void setFirstName(String name) { firstName = name; }

    @Column(name="last_name")
    public String getLastName() { return lastName; }
    public void setLastName(String name) { lastName = name; }
   
    @Column(name="party")
    public String getparty() { return party; }
    public void setparty(String party) { this.party = party; }    
    
    @ManyToOne
    @JoinColumn(name="state_code")
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="district")
    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; };   
    
    @ManyToMany
    @JoinTable(name="congressman_committee", 
            joinColumns={@JoinColumn(name="congressman_id")},
            inverseJoinColumns={@JoinColumn(name="committee_id")})
    public List<Committee> getCommittees() { return committees; }
    public void setCommittees(List<Committee> committees) { this.committees = committees;}   
    
    /**
     * Load the congressman table
     */   
    public static void load() {
        
        File xmlDocument = new File("xml_and_schema//congressman_table.xml");
        
        if(!xmlDocument.exists()) {
        	System.out.println("XML file not found");
        	return;
        }
        
        JAXBUnmarshaller_congressman.unMarshall(xmlDocument);
        
    }
        
    /**
     * List all the congressmen
     */
    public static void list() {
        Session session = HibernateContext.getSession();
        Criteria criteria = session.createCriteria(Congressman.class);
        criteria.addOrder(Order.asc("id"));
        
        try {
	        List<Congressman> congressmen = criteria.list();
	        System.out.println("\nAll comgressmen: ");
	        
	        for(Congressman congressman : congressmen) {
	            congressman.print();
	            
	            for(Committee committee : congressman.getCommittees()) {
	                System.out.printf(" In committee: %s\n", committee.getName());
	            }
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
    }   
    
    /**
     * Fetch the congressman with a matching id.
     * @param id the id to match.
     * @return the student or null.
     */
    public static Congressman find(int id) {
    	
    	Congressman congressman = null;
        Session session = HibernateContext.getSession();
        Query query = session.createQuery("from Congressman where congressman_id = :id");
        
        query.setInteger("id", id);
        
        try {
        	congressman = (Congressman) query.uniqueResult();
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
        return congressman;
    }
    
    
    /**
     * Find the congressman by his/her last name
     * @param lastName
     * @return a congressman object
     */
    public static Congressman find(String lastName) {
        
    	Congressman congressman = null;
        Session session = HibernateContext.getSession();
        Query query = 
                session.createQuery("from Congressman where last_name = :name");
        
        query.setString("name", lastName);
        
        try {
        	congressman = (Congressman)query.uniqueResult();
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
        return congressman;
    }
    
    
    public static void inDistrict(String district) {
        
        Session session = HibernateContext.getSession();
        Criteria congressmanCriteria = session.createCriteria(Congressman.class).createCriteria("district");
        
       // districtCriteria.add(Restrictions.eq("name", district));
        congressmanCriteria.add(Restrictions.eq("name", district));
        // Distict congressman sorted by id
        congressmanCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        congressmanCriteria.addOrder(Order.asc("id"));
        
        try {
	        List<Congressman> congressmen = (List<Congressman>)congressmanCriteria.list();
	        System.out.printf("\nCongressmen in district %s:\n", district);
	        
	        for(Congressman congressman : congressmen) {
	            System.out.printf("%d. %s %s\n", congressman.getId(), 
	                    congressman.getFirstName(), congressman.getLastName());
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();   
    }
    
    
    /**
     * Print congressmen from state
     * @param stateCode name code for state
     */
    public static void inState(String stateCode) {
        
        Session session = HibernateContext.getSession();
        Criteria congressmanCriteria = session.createCriteria(Congressman.class);
        Criteria stateCriteria = congressmanCriteria.createCriteria("state");
        
        stateCriteria.add(Restrictions.eq("stateCode", stateCode));
        
        // Distict congressman sorted by id
        congressmanCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        congressmanCriteria.addOrder(Order.asc("id"));
        
        try {
	        List<Congressman> congressmen = (List<Congressman>)congressmanCriteria.list();
	        System.out.printf("\nCongressmen in state %s:\n", stateCode);
	        
	        for(Congressman congressman : congressmen) {
	            System.out.printf("%d, %s %s\n", congressman.getId(), 
	                    congressman.getFirstName(), congressman.getLastName());
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();        
    }
    
    
    /**
     * Print committee's members
     * @param committee_name the name of the committee
     */
    public static void inCommittee(String committee_name) {
        
        Session session = HibernateContext.getSession();
        Criteria congressmanCriteria = session.createCriteria(Congressman.class);
        Criteria committeeCriteria = congressmanCriteria.createCriteria("committees");
        
        committeeCriteria.add(Restrictions.eq("name", committee_name));
        
        // Distict congressman sorted by id
        congressmanCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        congressmanCriteria.addOrder(Order.asc("id"));
        
        try {
	        List<Congressman> congressmen = (List<Congressman>)congressmanCriteria.list();
	        System.out.printf("\nCongressmen in committee %s:\n", committee_name);
	        
	        for(Congressman congressman : congressmen) {
	            System.out.printf("%d, %s %s\n", congressman.getId(), 
	                    congressman.getFirstName(), congressman.getLastName());
	        }
        }
        catch(HibernateException ex) {
        	System.out.println(ex.getMessage());
        }
        
        session.close();
    }    
    
    
    /**
     * Print congressman attributes
     */
    public void print() {
        System.out.printf("\n%d, %s %s, %s, %s, %s\n", id, firstName, lastName, party, state.getStateCode(),
        		district.getName());
    }

    
    /**
     * Print congressman attributes within a session.
     */
    public void printInSession()
    {
        Session session = HibernateContext.getSession();
        session.update(this);
        print();
        session.close();
    }
    
}
