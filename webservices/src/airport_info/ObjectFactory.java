
package airport_info;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the airport_info package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://www.webserviceX.NET", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: airport_info
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAirportInformationByCountryResponse }
     * 
     */
    public GetAirportInformationByCountryResponse createGetAirportInformationByCountryResponse() {
        return new GetAirportInformationByCountryResponse();
    }

    /**
     * Create an instance of {@link GetAirportInformationByCountry }
     * 
     */
    public GetAirportInformationByCountry createGetAirportInformationByCountry() {
        return new GetAirportInformationByCountry();
    }

    /**
     * Create an instance of {@link GetAirportInformationByISOCountryCodeResponse }
     * 
     */
    public GetAirportInformationByISOCountryCodeResponse createGetAirportInformationByISOCountryCodeResponse() {
        return new GetAirportInformationByISOCountryCodeResponse();
    }

    /**
     * Create an instance of {@link GetAirportInformationByAirportCode }
     * 
     */
    public GetAirportInformationByAirportCode createGetAirportInformationByAirportCode() {
        return new GetAirportInformationByAirportCode();
    }

    /**
     * Create an instance of {@link GetAirportInformationByAirportCodeResponse }
     * 
     */
    public GetAirportInformationByAirportCodeResponse createGetAirportInformationByAirportCodeResponse() {
        return new GetAirportInformationByAirportCodeResponse();
    }

    /**
     * Create an instance of {@link GetAirportInformationByCityOrAirportName }
     * 
     */
    public GetAirportInformationByCityOrAirportName createGetAirportInformationByCityOrAirportName() {
        return new GetAirportInformationByCityOrAirportName();
    }

    /**
     * Create an instance of {@link GetAirportInformationByISOCountryCode }
     * 
     */
    public GetAirportInformationByISOCountryCode createGetAirportInformationByISOCountryCode() {
        return new GetAirportInformationByISOCountryCode();
    }

    /**
     * Create an instance of {@link GetAirportInformationByCityOrAirportNameResponse }
     * 
     */
    public GetAirportInformationByCityOrAirportNameResponse createGetAirportInformationByCityOrAirportNameResponse() {
        return new GetAirportInformationByCityOrAirportNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.webserviceX.NET", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
