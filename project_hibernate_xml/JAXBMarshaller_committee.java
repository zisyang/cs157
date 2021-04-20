package project_hibernate_xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxb.generated.committee.CommitteeTableType;
import jaxb.generated.committee.CommitteeType;
import jaxb.generated.committee.ObjectFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class JAXBMarshaller_committee {
	
	public static void generateXMLDocument() {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.committee");
			Marshaller marshaller = jaxbContext.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			
			Session session = HibernateContext.getSession();
			Criteria criteria = session.createCriteria(Committee.class);
			criteria.addOrder(Order.asc("id"));
			
			CommitteeTableType committeeTable = factory.createCommitteeTableType();			
			List<CommitteeType> committeeList = committeeTable.getCommittee();
			List<Committee> cList = criteria.list();
			
			for(Committee c : cList) {
				
				CommitteeType committee = factory.createCommitteeType();
				
				committee.setCommitteeId(c.getID());
				committee.setName(c.getName());
				
				committeeList.add(committee);
			}
			
			File file = new File("generatedXML");
			file.mkdirs();
			File xmlDocument = new File("generatedXML//committee_table");
			
			JAXBElement<CommitteeTableType> committeeTableElement = factory.createCommitteeTable(committeeTable);
			
			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "committee_table.xsd");
			marshaller.marshal(committeeTableElement, xmlDocument);
		} 
		catch (JAXBException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
