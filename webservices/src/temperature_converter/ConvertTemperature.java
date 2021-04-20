
package temperature_converter;

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
@WebServiceClient(name = "ConvertTemperature", targetNamespace = "http://www.webserviceX.NET/", wsdlLocation = "http://www.webservicex.net/ConvertTemperature.asmx?WSDL")
public class ConvertTemperature
    extends Service
{

    private final static URL CONVERTTEMPERATURE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(temperature_converter.ConvertTemperature.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = temperature_converter.ConvertTemperature.class.getResource(".");
            url = new URL(baseUrl, "http://www.webservicex.net/ConvertTemperature.asmx?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://www.webservicex.net/ConvertTemperature.asmx?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CONVERTTEMPERATURE_WSDL_LOCATION = url;
    }

    public ConvertTemperature(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConvertTemperature() {
        super(CONVERTTEMPERATURE_WSDL_LOCATION, new QName("http://www.webserviceX.NET/", "ConvertTemperature"));
    }

    /**
     * 
     * @return
     *     returns ConvertTemperatureSoap
     */
    @WebEndpoint(name = "ConvertTemperatureSoap")
    public ConvertTemperatureSoap getConvertTemperatureSoap() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureSoap"), ConvertTemperatureSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConvertTemperatureSoap
     */
    @WebEndpoint(name = "ConvertTemperatureSoap")
    public ConvertTemperatureSoap getConvertTemperatureSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureSoap"), ConvertTemperatureSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns ConvertTemperatureSoap
     */
    @WebEndpoint(name = "ConvertTemperatureSoap12")
    public ConvertTemperatureSoap getConvertTemperatureSoap12() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureSoap12"), ConvertTemperatureSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConvertTemperatureSoap
     */
    @WebEndpoint(name = "ConvertTemperatureSoap12")
    public ConvertTemperatureSoap getConvertTemperatureSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureSoap12"), ConvertTemperatureSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns ConvertTemperatureHttpGet
     */
    @WebEndpoint(name = "ConvertTemperatureHttpGet")
    public ConvertTemperatureHttpGet getConvertTemperatureHttpGet() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureHttpGet"), ConvertTemperatureHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConvertTemperatureHttpGet
     */
    @WebEndpoint(name = "ConvertTemperatureHttpGet")
    public ConvertTemperatureHttpGet getConvertTemperatureHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureHttpGet"), ConvertTemperatureHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns ConvertTemperatureHttpPost
     */
    @WebEndpoint(name = "ConvertTemperatureHttpPost")
    public ConvertTemperatureHttpPost getConvertTemperatureHttpPost() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureHttpPost"), ConvertTemperatureHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConvertTemperatureHttpPost
     */
    @WebEndpoint(name = "ConvertTemperatureHttpPost")
    public ConvertTemperatureHttpPost getConvertTemperatureHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "ConvertTemperatureHttpPost"), ConvertTemperatureHttpPost.class, features);
    }

}
