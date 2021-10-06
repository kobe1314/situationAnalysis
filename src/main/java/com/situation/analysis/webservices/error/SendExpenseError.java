
package com.situation.analysis.webservices.error;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sendExpenseError complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sendExpenseError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BILLNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HRMNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ERRORNUM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CEHCKSTATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AT_DATA" type="{http://service.webservice.invoice.app.eweaver.com/}invoiceException" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendExpenseError", propOrder = {
    "sid",
    "billno",
    "hrmno",
    "errornum",
    "cehckstatus",
    "col1",
    "col2",
    "col3",
    "col4",
    "col5",
    "atdata"
})
public class SendExpenseError {

    @XmlElement(name = "SID")
    protected String sid;
    @XmlElement(name = "BILLNO")
    protected String billno;
    @XmlElement(name = "HRMNO")
    protected String hrmno;
    @XmlElement(name = "ERRORNUM")
    protected int errornum;
    @XmlElement(name = "CEHCKSTATUS")
    protected int cehckstatus;
    @XmlElement(name = "COL1")
    protected String col1;
    @XmlElement(name = "COL2")
    protected String col2;
    @XmlElement(name = "COL3")
    protected String col3;
    @XmlElement(name = "COL4")
    protected String col4;
    @XmlElement(name = "COL5")
    protected String col5;
    @XmlElement(name = "AT_DATA")
    protected List<InvoiceException> atdata;

    /**
     * 获取sid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSID() {
        return sid;
    }

    /**
     * 设置sid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSID(String value) {
        this.sid = value;
    }

    /**
     * 获取billno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBILLNO() {
        return billno;
    }

    /**
     * 设置billno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBILLNO(String value) {
        this.billno = value;
    }

    /**
     * 获取hrmno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHRMNO() {
        return hrmno;
    }

    /**
     * 设置hrmno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHRMNO(String value) {
        this.hrmno = value;
    }

    /**
     * 获取errornum属性的值。
     * 
     */
    public int getERRORNUM() {
        return errornum;
    }

    /**
     * 设置errornum属性的值。
     * 
     */
    public void setERRORNUM(int value) {
        this.errornum = value;
    }

    /**
     * 获取cehckstatus属性的值。
     * 
     */
    public int getCEHCKSTATUS() {
        return cehckstatus;
    }

    /**
     * 设置cehckstatus属性的值。
     * 
     */
    public void setCEHCKSTATUS(int value) {
        this.cehckstatus = value;
    }

    /**
     * 获取col1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOL1() {
        return col1;
    }

    /**
     * 设置col1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOL1(String value) {
        this.col1 = value;
    }

    /**
     * 获取col2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOL2() {
        return col2;
    }

    /**
     * 设置col2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOL2(String value) {
        this.col2 = value;
    }

    /**
     * 获取col3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOL3() {
        return col3;
    }

    /**
     * 设置col3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOL3(String value) {
        this.col3 = value;
    }

    /**
     * 获取col4属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOL4() {
        return col4;
    }

    /**
     * 设置col4属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOL4(String value) {
        this.col4 = value;
    }

    /**
     * 获取col5属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOL5() {
        return col5;
    }

    /**
     * 设置col5属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOL5(String value) {
        this.col5 = value;
    }

    /**
     * Gets the value of the atdata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atdata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATDATA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceException }
     * 
     * 
     */
    public List<InvoiceException> getATDATA() {
        if (atdata == null) {
            atdata = new ArrayList<InvoiceException>();
        }
        return this.atdata;
    }

}
