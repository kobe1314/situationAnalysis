
package com.situation.analysis.webservices.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>invoiceException complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="invoiceException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ERROR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceException", propOrder = {
    "error",
    "invoiceno"
})
public class InvoiceException {

    @XmlElement(name = "ERROR")
    protected String error;
    @XmlElement(name = "INVOICENO")
    protected String invoiceno;

    /**
     * 获取error属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERROR() {
        return error;
    }

    /**
     * 设置error属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERROR(String value) {
        this.error = value;
    }

    /**
     * 获取invoiceno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICENO() {
        return invoiceno;
    }

    /**
     * 设置invoiceno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICENO(String value) {
        this.invoiceno = value;
    }

}
