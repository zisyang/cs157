package project_hibernate_xml;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.state.StateTableType;
import jaxb.generated.state.StateType;


public class JAXBUnmarshaller_state {

	public static void unMarshall(File xmlDocument) {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.state");
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			
			JAXBElement<StateTableType> stateTableElement = (JAXBElement<StateTableType>)unMarshaller.unmarshal(xmlDocument);
			StateTableType stateTable = stateTableElement.getValue();
			List<StateType> stateList = stateTable.getState();
			
	    	if(stateList != null) {
	    		
	    		Session session = HibernateContext.getSession();
	    		Transaction tx = session.beginTransaction();
	    		
	    		for(StateType state : stateList) {
	    			State s = new State(state.getStateCode());
	    			session.save(s);
	    		}

	    		tx.commit();
	    		session.close();
	    	}
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

	}

}
