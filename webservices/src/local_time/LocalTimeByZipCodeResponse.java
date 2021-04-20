
package local_time;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocalTimeByZipCodeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "localTimeByZipCodeResult"
})
@XmlRootElement(name = "LocalTimeByZipCodeResponse")
public class LocalTimeByZipCodeResponse {

    @XmlElement(name = "LocalTimeByZipCodeResult")
    protected String localTimeByZipCodeResult;

    /**
     * Gets the value of the localTimeByZipCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalTimeByZipCodeResult() {
        return localTimeByZipCodeResult;
    }

    /**
     * Sets the value of the localTimeByZipCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalTimeByZipCodeResult(String value) {
        this.localTimeByZipCodeResult = value;
    }

}
