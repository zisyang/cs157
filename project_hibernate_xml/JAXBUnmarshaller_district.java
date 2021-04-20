package project_hibernate_xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jaxb.generated.district.DistrictTableType;
import jaxb.generated.district.DistrictType;

public class JAXBUnmarshaller_district {

	/**
	 * method to unmarshall an xml document
	 * @param xmlDocument
	 */
	public static void unMarshall (File xmlDocument)
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance("jaxb.generated.district");
			Unmarshaller unMarshaller = context.createUnmarshaller();
			JAXBElement<DistrictTableType> districtTableElement = 
					(JAXBElement<DistrictTableType>) unMarshaller.unmarshal(xmlDocument);
			DistrictTableType districtTable = districtTableElement.getValue();
			
			List<DistrictType> districtList = districtTable.getDistrict();
			
			/*
			//for testing purpose
			for (DistrictType district : districtList)
			{
				System.out.format("id: %d name: %-20s", district.getId(), district.getName());
				System.out.println();
			}
			*/
			
			if(districtList != null) {
				
				Session session = HibernateContext.getSession();
				Transaction tx = session.beginTransaction();
				
				for(DistrictType district : districtList) {
					District d = new District(district.getName());
	        		session.save(d);
				}

				tx.commit();
				session.close();
			}		
		}
        catch (JAXBException ex) 
        {
			ex.printStackTrace();
		}

	}
	
}
