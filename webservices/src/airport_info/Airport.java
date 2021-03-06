
package airport_info;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "airport", targetNamespace = "http://www.webserviceX.NET", wsdlLocation = "http://www.webservicex.net/airport.asmx?WSDL")
public class Airport
    extends Service
{

    private final static URL AIRPORT_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(airport_info.Airport.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = airport_info.Airport.class.getResource(".");
            url = new URL(baseUrl, "http://www.webservicex.net/airport.asmx?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://www.webservicex.net/airport.asmx?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        AIRPORT_WSDL_LOCATION = url;
    }

    public Airport(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Airport() {
        super(AIRPORT_WSDL_LOCATION, new QName("http://www.webserviceX.NET", "airport"));
    }

    /**
     * 
     * @return
     *     returns AirportSoap
     */
    @WebEndpoint(name = "airportSoap")
    public AirportSoap getAirportSoap() {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportSoap"), AirportSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AirportSoap
     */
    @WebEndpoint(name = "airportSoap")
    public AirportSoap getAirportSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportSoap"), AirportSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns AirportSoap
     */
    @WebEndpoint(name = "airportSoap12")
    public AirportSoap getAirportSoap12() {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportSoap12"), AirportSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AirportSoap
     */
    @WebEndpoint(name = "airportSoap12")
    public AirportSoap getAirportSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportSoap12"), AirportSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns AirportHttpGet
     */
    @WebEndpoint(name = "airportHttpGet")
    public AirportHttpGet getAirportHttpGet() {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportHttpGet"), AirportHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AirportHttpGet
     */
    @WebEndpoint(name = "airportHttpGet")
    public AirportHttpGet getAirportHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportHttpGet"), AirportHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns AirportHttpPost
     */
    @WebEndpoint(name = "airportHttpPost")
    public AirportHttpPost getAirportHttpPost() {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportHttpPost"), AirportHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AirportHttpPost
     */
    @WebEndpoint(name = "airportHttpPost")
    public AirportHttpPost getAirportHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET", "airportHttpPost"), AirportHttpPost.class, features);
    }

}
