
package com.situation.analysis.webservices.expenseinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>readExpensesDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="readExpensesDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="COL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COL5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICENUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TRAINL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNITNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNITTAXNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readExpensesDetail", propOrder = {
    "amount",
    "col1",
    "col2",
    "col3",
    "col4",
    "col5",
    "invoicecode",
    "invoiceno",
    "invoicenumber",
    "name",
    "tax",
    "trainl",
    "unitname",
    "unittaxno"
})
public class ReadExpensesDetail {

    @XmlElement(name = "AMOUNT")
    protected double amount;
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
    @XmlElement(name = "INVOICECODE")
    protected String invoicecode;
    @XmlElement(name = "INVOICENO")
    protected String invoiceno;
    @XmlElement(name = "INVOICENUMBER")
    protected String invoicenumber;
    @XmlElement(name = "NAME")
    protected String name;
    @XmlElement(name = "TAX")
    protected double tax;
    @XmlElement(name = "TRAINL")
    protected String trainl;
    @XmlElement(name = "UNITNAME")
    protected String unitname;
    @XmlElement(name = "UNITTAXNO")
    protected String unittaxno;

    /**
     * 获取amount属性的值。
     * 
     */
    public double getAMOUNT() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     * 
     */
    public void setAMOUNT(double value) {
        this.amount = value;
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
     * 获取invoicecode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICECODE() {
        return invoicecode;
    }

    /**
     * 设置invoicecode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICECODE(String value) {
        this.invoicecode = value;
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

    /**
     * 获取invoicenumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICENUMBER() {
        return invoicenumber;
    }

    /**
     * 设置invoicenumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICENUMBER(String value) {
        this.invoicenumber = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * 获取tax属性的值。
     * 
     */
    public double getTAX() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     */
    public void setTAX(double value) {
        this.tax = value;
    }

    /**
     * 获取trainl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRAINL() {
        return trainl;
    }

    /**
     * 设置trainl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRAINL(String value) {
        this.trainl = value;
    }

    /**
     * 获取unitname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITNAME() {
        return unitname;
    }

    /**
     * 设置unitname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITNAME(String value) {
        this.unitname = value;
    }

    /**
     * 获取unittaxno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITTAXNO() {
        return unittaxno;
    }

    /**
     * 设置unittaxno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITTAXNO(String value) {
        this.unittaxno = value;
    }

}
