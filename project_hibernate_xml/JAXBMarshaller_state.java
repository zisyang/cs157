package project_hibernate_xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxb.generated.state.ObjectFactory;
import jaxb.generated.state.StateTableType;
import jaxb.generated.state.StateType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class JAXBMarshaller_state {
	
	public static void generateXMLDocument() {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.state");
			Marshaller marshaller = jaxbContext.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			
			Session session = HibernateContext.getSession();
			Criteria criteria = session.createCriteria(State.class);
			criteria.addOrder(Order.asc("id"));
			
			StateTableType stateTable = factory.createStateTableType();			
			List<StateType> stateList = stateTable.getState();
			List<State> sList = criteria.list();
			
			for(State s : sList) {
				
				StateType state = factory.createStateType();
				
				state.setId(s.getId());
				state.setStateCode(s.getStateCode());
				
				stateList.add(state);
			}
					
			File xmlDocument = new File("generatedXML//state_table");
			
			JAXBElement<StateTableType> stateTableElement = factory.createStateTable(stateTable);
			
			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "state_table.xsd");
			marshaller.marshal(stateTableElement, xmlDocument);
		} 
		catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}
	
}
