
package com.situation.analysis.webservices.expenses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>searchExpenses complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="searchExpenses">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "searchExpenses", propOrder = {
    "hrmno"
})
public class SearchExpenses {

    @XmlElement(name = "HRMNO")
    protected String hrmno;

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
