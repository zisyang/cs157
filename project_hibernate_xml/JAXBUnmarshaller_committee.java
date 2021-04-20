package project_hibernate_xml;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.committee.CommitteeTableType;
import jaxb.generated.committee.CommitteeType;


public class JAXBUnmarshaller_committee {

	public static void unMarshall(File xmlDocument) {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.committee");
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			
			JAXBElement<CommitteeTableType> committeeTableElement = (JAXBElement<CommitteeTableType>) unMarshaller.unmarshal(xmlDocument);
			CommitteeTableType committeeTable = committeeTableElement.getValue();
			List<CommitteeType> committeeList = committeeTable.getCommittee();
			
	        if(committeeList != null) {
	        	
	        	Session session = HibernateContext.getSession();
	        	
	            Congressman lucas = Congressman.find("Lucas");
	            Congressman scott = Congressman.find("Scott");
	            Congressman costa = Congressman.find("Costa");
	            Congressman upton = Congressman.find("Upton");
	            Congressman hall = Congressman.find("Hall");
	            Congressman tonko = Congressman.find("Tonko");
	            Congressman markey = Congressman.find("Markey");
	            Congressman harris = Congressman.find("Harris");
	            Congressman cramer = Congressman.find("Cramer");
	            Congressman broun = Congressman.find("Broun");
	            Congressman mccaul = Congressman.find("McCaul");
	            Congressman neugebauer = Congressman.find("Neugebauer");
	        	
	        	for(CommitteeType committee : committeeList) {
	        		
	        		Transaction tx = session.beginTransaction();
	        		
	        		Committee c = new Committee(committee.getName());
	        		
	                // Assign congressman to committee
	                if(c.getName().equalsIgnoreCase("Agriculture")) {
	                    c.getCongressmen().add(lucas);
	                    c.getCongressmen().add(scott);
	                    c.getCongressmen().add(costa);
	                    c.getCongressmen().add(neugebauer);
	                }
	                else if(c.getName().equalsIgnoreCase("Energy_and_Commerce")) {
	                    c.getCongressmen().add(upton);
	                    c.getCongressmen().add(hall);
	                    c.getCongressmen().add(tonko);
	                    c.getCongressmen().add(markey);
	                }
	                else if(c.getName().equalsIgnoreCase("Natural_Resource")) {
	                    c.getCongressmen().add(markey);
	                    c.getCongressmen().add(harris);
	                    c.getCongressmen().add(cramer);
	                    c.getCongressmen().add(costa);
	                    c.getCongressmen().add(tonko);
	                }
	                else if(c.getName().equalsIgnoreCase("Science_Space_and_Technology")) {
	                    c.getCongressmen().add(broun);
	                    c.getCongressmen().add(mccaul);
	                    c.getCongressmen().add(neugebauer);
	                    c.getCongressmen().add(lucas);
	                    c.getCongressmen().add(hall);
	                    c.getCongressmen().add(tonko);
	                    c.getCongressmen().add(harris);
	                    c.getCongressmen().add(cramer);
	                }
	                
	        		session.save(c);
	        		tx.commit();
	        	}    	
	        	
	        	session.close();
	        }
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

	}
	
}
