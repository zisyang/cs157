package project_hibernate_xml;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.congressman.CongressmanTableType;
import jaxb.generated.congressman.CongressmanType;

public class JAXBUnmarshaller_congressman {
	
	public static void unMarshall(File xmlDocument) {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.congressman");
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			
			JAXBElement<CongressmanTableType> congressmanTableElement = (JAXBElement<CongressmanTableType>) unMarshaller.unmarshal(xmlDocument);
			CongressmanTableType congressmanTable = congressmanTableElement.getValue();
			List<CongressmanType> congressmanList = congressmanTable.getCongressman();
		
	        if(congressmanList != null) {
	        	
	        	Session session = HibernateContext.getSession();
	        	Transaction tx = session.beginTransaction();
	        	
	        	for(CongressmanType congressman : congressmanList) {
	      		
	      			State state = State.find(congressman.getStateCode());
	      			District district = District.find(congressman.getDistrict());
	      			
	        		Congressman c = new Congressman(congressman.getFirstName(), congressman.getLastName(), congressman.getParty(), state, district);
	        		session.save(c);
	        	}
	        	
	        	tx.commit();
	        	session.close();
	        }
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

	}
	
}