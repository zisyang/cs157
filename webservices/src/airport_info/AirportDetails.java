package airport_info;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AirportDetails {
	public String AirportCode;
	public String CityOrAirportName;
	public String Country;
	public String CountryAbbrviation;
	public int CountryCode;
	public int GMTOffset;
	public int RunwayLengthFeet;
	public int RunwayElevationFeet;
	public String Latitude;
	public String Longitude;
	
	static public ArrayList <AirportDetails> parsexml(String xmlstring) 
	{
		ArrayList <AirportDetails> list = new ArrayList <AirportDetails>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        InputSource is = new InputSource( new StringReader( xmlstring) );

        Document doc = null;
		try {
			doc = builder.parse( is );
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//get the root element
		Element docEle = (Element) doc.getDocumentElement();

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("Table");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the airport element
				Element el = (Element)nl.item(i);

				//get the airportdetails object
				AirportDetails a = getDetails(el);

				//add it to list
				if(a.Country.equalsIgnoreCase("United States") && !contains(list,a)) 
					list.add(a);  //filter US only, and only one airportcode for one airport
			}
		}

        System.out.println("Airport Found: "+list.size());
		return list;
	}
	
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n  AirportCode: "+AirportCode);
		buffer.append("\n  CityOrAirportName: "+CityOrAirportName);
		buffer.append("\n  Country: "+Country);
		buffer.append("\n  CountryAbbrviation: "+ CountryAbbrviation);
		buffer.append("\n  CountryCode: "+CountryCode);
		buffer.append("\n  GMTOffset: "+GMTOffset);
		buffer.append("\n  RunwayLengthFeet: "+RunwayLengthFeet);
		buffer.append("\n  RunwayElevationFeet: "+RunwayElevationFeet);
		buffer.append("\n  Latitude: "+Latitude);
		buffer.append("\n  Longitude: "+Longitude);
		
		return buffer.toString();
		
	}
	
	//prevent duplicated airport
	public static boolean contains(ArrayList<AirportDetails> list, AirportDetails a)
	{
		int i = 0;
		for(i=0; i<list.size(); i++)
		{	//one airport code represent only one airport
			if(a.AirportCode.equalsIgnoreCase(list.get(i).AirportCode))
				return true;
		}
		return false;
	}
	
	/**
	 * I take an employee element and read the values in, create
	 * an Employee object and return it
	 */
	private static AirportDetails getDetails(Element empEl) {
		
		//Create a new AirportDetails with the value read from the xml nodes
		AirportDetails a = new AirportDetails();

		//for each  AirportDetail get text or int values of
		//code ,city, country and etc.
		a.AirportCode = getTextValue(empEl,"AirportCode");
		a.CityOrAirportName = getTextValue(empEl, "CityOrAirportName");
		a.Country = getTextValue(empEl, "Country");
		a.CountryAbbrviation = getTextValue(empEl, "CountryAbbrviation");
		a.CountryCode = getIntValue(empEl, "CountryCode");
		a.GMTOffset = getIntValue(empEl, "GMTOffset");
		a.RunwayLengthFeet = getIntValue(empEl, "RunwayLengthFeet");
		a.RunwayElevationFeet = getIntValue(empEl, "RunwayElevationFeet");
		a.Latitude = getTextValue(empEl, "LatitudeNpeerS")+
				getTextValue(empEl, "LatitudeDegree")+"*"+
				getTextValue(empEl, "LatitudeMinute")+"\'"+
				getTextValue(empEl, "LatitudeSecond")+"\"";
		a.Longitude = getTextValue(empEl, "LongitudeEperW")+
				getTextValue(empEl, "LongitudeDegree")+"*"+
				getTextValue(empEl, "LongitudeMinute")+"\'"+
				getTextValue(empEl, "LongitudeSeconds")+"\"";

//		String type = empEl.getAttribute("type");

		return a;
	}


	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content
	 * i.e for John xml snippet if
	 * the Element points to employee node and tagName is 'name' I will return John
	 */
	static public String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}


	/**
	 * Calls getTextValue and returns a int value
	 */
	static public int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}
}
