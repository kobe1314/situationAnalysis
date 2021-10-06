
package com.situation.analysis.webservices.expenses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>expensenDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="expensenDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BILLNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPMAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPMONEY" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="INVMONEY" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="INVNUMS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REQDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expensenDetail", propOrder = {
    "billno",
    "col1",
    "col2",
    "col3",
    "col4",
    "col5",
    "expman",
    "expmoney",
    "invmoney",
    "invnums",
    "reqdate",
    "sid"
})
public class ExpensenDetail {

    @XmlElement(name = "BILLNO")
    protected String billno;
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
    @XmlElement(name = "EXPMAN")
    protected String expman;
    @XmlElement(name = "EXPMONEY")
    protected double expmoney;
    @XmlElement(name = "INVMONEY")
    protected double invmoney;
    @XmlElement(name = "INVNUMS")
    protected int invnums;
    @XmlElement(name = "REQDATE")
    protected String reqdate;
    @XmlElement(name = "SID")
    protected String sid;

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
     * 获取expman属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPMAN() {
        return expman;
    }

    /**
     * 设置expman属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPMAN(String value) {
        this.expman = value;
    }

    /**
     * 获取expmoney属性的值。
     * 
     */
    public double getEXPMONEY() {
        return expmoney;
    }

    /**
     * 设置expmoney属性的值。
     * 
     */
    public void setEXPMONEY(double value) {
        this.expmoney = value;
    }

    /**
     * 获取invmoney属性的值。
     * 
     */
    public double getINVMONEY() {
        return invmoney;
    }

    /**
     * 设置invmoney属性的值。
     * 
     */
    public void setINVMONEY(double value) {
        this.invmoney = value;
    }

    /**
     * 获取invnums属性的值。
     * 
     */
    public int getINVNUMS() {
        return invnums;
    }

    /**
     * 设置invnums属性的值。
     * 
     */
    public void setINVNUMS(int value) {
        this.invnums = value;
    }

    /**
     * 获取reqdate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREQDATE() {
        return reqdate;
    }

    /**
     * 设置reqdate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREQDATE(String value) {
        this.reqdate = value;
    }

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

}
