package project_hibernate_xml;

import java.io.File;
import java.io.Serializable;
import java.util.List;


import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

import jaxb.generated.district.DistrictType;

/**
 * this class represents a district table on the database
 * @author lamlu
 *
 */
@Entity
@Table(name = "district")

public class District implements Serializable
{
	private int id;
	private String name;
	private Congressman congressman;
	
	/**
	 * default constructor
	 */
	public District(){}
	/**
	 * constructor for the class
	 * @param name the district name
	 */
	public District (String districtName)
	{
		this.name = districtName;
	}
	
	@Id
	@GeneratedValue
	@Column(name ="id")
	public int getId (){ return this.id;}	
	public void setId (int anID){ this.id = anID;};
	
	@Column(name = "name")
	public String getName(){ return this.name;}
	public void setName(String aName){ this.name = aName;}
	
    //@OneToOne(mappedBy = "district", fetch=FetchType.LAZY)
	@OneToOne(mappedBy="district", fetch=FetchType.LAZY)
    public Congressman getCongressman(){return this.congressman;}
    public void setCongressman(Congressman cg){this.congressman = cg;}
	
	/**
	 * Load the district name into district table
	 */
	public static void load()
	{
		File xmlDocument = new File("xml_and_schema//district_table.xml");
		
		if(!xmlDocument.exists()) {
			System.out.println("XML file not found");
			return;
		}
		
		JAXBUnmarshaller_district.unMarshall(xmlDocument);
	}
	
	/**
	 * list all the districts
	 */
	public static void list()
	{
		Session session = HibernateContext.getSession();
		Criteria c = session.createCriteria(District.class);
		c.addOrder(Order.asc("id"));
		System.out.println("\nAll District: ");
		
		try {
			for (District district : (List<District>) c.list())
			{
				System.out.format("%-3d: %20s\n", district.getId(), district.getName());
			}
		}
		catch(HibernateException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * fetch the district with the id
	 * @param id the matching id
	 * @return the district object or null
	 */
	public static District find (int id)
	{
		District district = null;
		
		Session session = HibernateContext.getSession();
		Query query = session.createQuery("from District where id = :idvar");
		query.setInteger("idvar" , id);
		
		try {
			district = (District) query.uniqueResult();
		}
		catch(HibernateException ex) {
			System.out.println(ex.getMessage());
		}
		
		session.close();
		return district;
	}
	
	/**
	 * fetch the district with the name of the district
	 * @param name the matching name
	 * @return the district object or null
	 */
	public static District find (String name)
	{
		District district = null;
		
		Session session = HibernateContext.getSession();
		Query query = session.createQuery("from District where name = :namevar");
		query.setString("namevar" , name);
		
		try {
			district = (District) query.uniqueResult();
		}
		catch(HibernateException ex) {
			System.out.println(ex.getMessage());
		}
		
		session.close();
		return district;
	}
}
