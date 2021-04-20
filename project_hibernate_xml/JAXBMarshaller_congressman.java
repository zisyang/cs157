package project_hibernate_xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import jaxb.generated.congressman.CongressmanTableType;
import jaxb.generated.congressman.CongressmanType;
import jaxb.generated.congressman.ObjectFactory;

public class JAXBMarshaller_congressman {

	public static void generateXMLDocument() {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.congressman");
			Marshaller marshaller = jaxbContext.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			
			Session session = HibernateContext.getSession();
			Criteria criteria = session.createCriteria(Congressman.class);
			criteria.addOrder(Order.asc("id"));
			
			CongressmanTableType congressmanTable = factory.createCongressmanTableType();			
			List<CongressmanType> congressmanList = congressmanTable.getCongressman();
			List<Congressman> cList = criteria.list();
			
			for(Congressman c : cList) {
				
				CongressmanType congressman = factory.createCongressmanType();
				
				congressman.setCongressmanId(c.getId());
				congressman.setFirstName(c.getFirstName());
				congressman.setLastName(c.getLastName());
				congressman.setParty(c.getparty());
				congressman.setStateCode(c.getState().getStateCode());
				congressman.setDistrict(c.getDistrict().getName());
				
				congressmanList.add(congressman);
			}
					
			File xmlDocument = new File("generatedXML//congressman_table");
			
			JAXBElement<CongressmanTableType> congressmanTableElement = factory.createCongressmanTable(congressmanTable);
			
			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "congressman_table.xsd");
			marshaller.marshal(congressmanTableElement, xmlDocument);
		} 
		catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

}
