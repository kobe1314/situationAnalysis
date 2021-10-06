
package com.situation.analysis.webservices.expenses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>expensesResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="expensesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AT_RETURN" type="{http://service.webservice.invoice.app.eweaver.com/}expensenDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECORDNUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expensesResult", propOrder = {
    "atreturn",
    "message",
    "recordnumber",
    "status"
})
public class ExpensesResult {

    @XmlElement(name = "AT_RETURN", nillable = true)
    protected List<ExpensenDetail> atreturn;
    @XmlElement(name = "MESSAGE")
    protected String message;
    @XmlElement(name = "RECORDNUMBER")
    protected int recordnumber;
    @XmlElement(name = "STATUS")
    protected String status;

    /**
     * Gets the value of the atreturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atreturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATRETURN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpensenDetail }
     * 
     * 
     */
    public List<ExpensenDetail> getATRETURN() {
        if (atreturn == null) {
            atreturn = new ArrayList<ExpensenDetail>();
        }
        return this.atreturn;
    }

    /**
     * 获取message属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMESSAGE() {
        return message;
    }

    /**
     * 设置message属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMESSAGE(String value) {
        this.message = value;
    }

    /**
     * 获取recordnumber属性的值。
     * 
     */
    public int getRECORDNUMBER() {
        return recordnumber;
    }

    /**
     * 设置recordnumber属性的值。
     * 
     */
    public void setRECORDNUMBER(int value) {
        this.recordnumber = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

}
