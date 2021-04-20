package project_hibernate_xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxb.generated.district.DistrictTableType;
import jaxb.generated.district.DistrictType;
import jaxb.generated.district.ObjectFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class JAXBMarshaller_district {
	
	public static void generateXMLDocument() {
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.generated.district");
			Marshaller marshaller = jaxbContext.createMarshaller();
			ObjectFactory factory = new ObjectFactory();
			
			Session session = HibernateContext.getSession();
			Criteria criteria = session.createCriteria(District.class);
			criteria.addOrder(Order.asc("id"));
			
			DistrictTableType districtTable = factory.createDistrictTableType();			
			List<DistrictType> districtList = districtTable.getDistrict();
			List<District> dList = criteria.list();
			
			for(District d : dList) {
				
				DistrictType district = factory.createDistrictType();
				
				district.setId(d.getId());
				district.setName(d.getName());
				
				districtList.add(district);
			}
					
			File xmlDocument = new File("generatedXML//district_table");
			
			JAXBElement<DistrictTableType> districtTableElement = factory.createDistrictTable(districtTable);
			
			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "district_table.xsd");
			marshaller.marshal(districtTableElement, xmlDocument);
		} 
		catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}
	
}
