
package com.situation.analysis.webservices.expenseinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>readExpenseinfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="readExpenseinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BILLNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HRMNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readExpenseinfo", propOrder = {
    "sid",
    "billno",
    "hrmno"
})
public class ReadExpenseinfo {

    @XmlElement(name = "SID")
    protected String sid;
    @XmlElement(name = "BILLNO")
    protected String billno;
    @XmlElement(name = "HRMNO")
    protected String hrmno;

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

}
