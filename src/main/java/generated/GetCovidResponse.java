//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.02.17 um 02:01:46 AM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="covid" type="{http://innova.com/models/soap/emp}covid"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "covid"
})
@XmlRootElement(name = "getCovidResponse", namespace = "http://innova.com/models/soap/emp")
public class GetCovidResponse {

    @XmlElement(namespace = "http://innova.com/models/soap/emp", required = true)
    protected Covid covid;

    /**
     * Ruft den Wert der covid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Covid }
     *     
     */
    public Covid getCovid() {
        return covid;
    }

    /**
     * Legt den Wert der covid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Covid }
     *     
     */
    public void setCovid(Covid value) {
        this.covid = value;
    }

}
