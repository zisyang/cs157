
package local_time;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "LocalTimeHttpPost", targetNamespace = "http://www.ripedev.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LocalTimeHttpPost {


    /**
     * Returns local time for a given zip code.
     * 
     * @param zipCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LocalTimeByZipCode")
    @WebResult(name = "string", targetNamespace = "http://www.ripedev.com/", partName = "Body")
    public String localTimeByZipCode(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "ZipCode")
        String zipCode);

}
