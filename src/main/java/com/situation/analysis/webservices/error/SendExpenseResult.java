
package com.situation.analysis.webservices.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sendExpenseResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sendExpenseResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CEHCKSTATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ERRORNUM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "sendExpenseResult", propOrder = {
    "cehckstatus",
    "col1",
    "col2",
    "col3",
    "col4",
    "col5",
    "errornum",
    "message",
    "status"
})
public class SendExpenseResult {

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
    @XmlElement(name = "ERRORNUM")
    protected int errornum;
    @XmlElement(name = "MESSAGE")
    protected String message;
    @XmlElement(name = "STATUS")
    protected String status;

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
