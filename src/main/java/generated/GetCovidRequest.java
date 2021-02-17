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
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rValue" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nDays" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "info",
    "rValue",
    "nDays"
})
@XmlRootElement(name = "getCovidRequest", namespace = "http://innova.com/models/soap/emp")
public class GetCovidRequest {

    @XmlElement(namespace = "http://innova.com/models/soap/emp", required = true)
    protected String info;
    @XmlElement(namespace = "http://innova.com/models/soap/emp")
    protected int rValue;
    @XmlElement(namespace = "http://innova.com/models/soap/emp")
    protected int nDays;

    /**
     * Ruft den Wert der info-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Legt den Wert der info-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Ruft den Wert der rValue-Eigenschaft ab.
     * 
     */
    public int getRValue() {
        return rValue;
    }

    /**
     * Legt den Wert der rValue-Eigenschaft fest.
     * 
     */
    public void setRValue(int value) {
        this.rValue = value;
    }

    /**
     * Ruft den Wert der nDays-Eigenschaft ab.
     * 
     */
    public int getNDays() {
        return nDays;
    }

    /**
     * Legt den Wert der nDays-Eigenschaft fest.
     * 
     */
    public void setNDays(int value) {
        this.nDays = value;
    }

}
