
package temperature_converter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ConvertTemperatureSoap", targetNamespace = "http://www.webserviceX.NET/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConvertTemperatureSoap {


    /**
     * 
     * @param fromUnit
     * @param toUnit
     * @param temperature
     * @return
     *     returns double
     */
    @WebMethod(operationName = "ConvertTemp", action = "http://www.webserviceX.NET/ConvertTemp")
    @WebResult(name = "ConvertTempResult", targetNamespace = "http://www.webserviceX.NET/")
    @RequestWrapper(localName = "ConvertTemp", targetNamespace = "http://www.webserviceX.NET/", className = "temperature_converter.ConvertTemp")
    @ResponseWrapper(localName = "ConvertTempResponse", targetNamespace = "http://www.webserviceX.NET/", className = "temperature_converter.ConvertTempResponse")
    public double convertTemp(
        @WebParam(name = "Temperature", targetNamespace = "http://www.webserviceX.NET/")
        double temperature,
        @WebParam(name = "FromUnit", targetNamespace = "http://www.webserviceX.NET/")
        TemperatureUnit fromUnit,
        @WebParam(name = "ToUnit", targetNamespace = "http://www.webserviceX.NET/")
        TemperatureUnit toUnit);

}
